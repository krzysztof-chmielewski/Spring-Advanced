package io.kch.sda.spring.jpa16.player;

import io.kch.sda.spring.jpa16.song.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InternetRadioTest {
    @Mock
    private ArtistRepository artistRepository;

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private SongRepository songRepository;

    private InternetRadio internetRadio;

    @Before
    public void setUp() throws Exception {
        internetRadio = new InternetRadio(artistRepository, albumRepository, songRepository);
    }

    @Test
    public void noSongsArePlayedAtTheBeginning() throws Exception {
        assertThat(internetRadio.playedSongs()).isEqualTo(Collections.emptyList());
        assertThat(internetRadio.currentSong()).isNull();
    }

    @Test
    public void playingOneSongsAddsItToTheListOfSongs() throws Exception {
        SongBean song = new SongBean("Artist", "Album", "Title");

        when(albumRepository.findByAlbum(anyString())).thenReturn(new Album(new Artist("Artist"), "Album"));
        List<Song> entity = Collections.singletonList(internetRadio.beanToEntity(song));
        when(songRepository.findAll()).thenReturn(entity);

        internetRadio.playSong(song);

        assertThat(internetRadio.playedSongs()).contains(song);
        assertThat(internetRadio.playedSongs()).hasSize(1);
        assertThat(internetRadio.currentSong()).isEqualTo(song);
    }

    @Test
    public void playingThreeSongsAddsThemToTheListOfSongs() throws Exception {
        SongBean first = new SongBean("Artist", "Album", "Title");
        SongBean second = new SongBean("Artist2", "Album2", "Title2");
        SongBean third = new SongBean("Artist3", "Album3", "Title2");

        when(albumRepository.findByAlbum("Album")).thenReturn(new Album(new Artist("Artist"), "Album"));
        when(albumRepository.findByAlbum("Album2")).thenReturn(new Album(new Artist("Artist2"), "Album2"));
        when(albumRepository.findByAlbum("Album3")).thenReturn(new Album(new Artist("Artist3"), "Album3"));
        List<Song> entity = Arrays.asList(internetRadio.beanToEntity(first),
                internetRadio.beanToEntity(second), internetRadio.beanToEntity(third));
        when(songRepository.findAll()).thenReturn(entity);

        internetRadio.playSong(first);
        internetRadio.playSong(second);
        internetRadio.playSong(third);

        assertThat(internetRadio.playedSongs()).contains(first, second, third);
        assertThat(internetRadio.playedSongs()).hasSize(3);
        assertThat(internetRadio.currentSong()).isEqualTo(third);
    }

    @Test
    public void clearPlaylist() throws Exception {
        internetRadio.clearPlaylist();

        verify(songRepository).deleteAll();
    }

    @Test
    public void removeSongFromPlaylist() throws Exception {
        internetRadio.removeSongFromPlaylist(3);

        verify(songRepository).delete(3);
    }

    @Test
    public void replaceSongInPlaylist() throws Exception {
        SongBean song = new SongBean("artist", "album", "title");
        song.setId(5);

        when(albumRepository.findByAlbum(anyString())).thenReturn(new Album(new Artist("Artist"), "Album"));

        internetRadio.replaceSongInPlaylist(song);

        verify(songRepository).save(any(Song.class));
    }

    @Test
    public void filterByArtistName() {
        internetRadio.filterByArtist("artist");

        verify(songRepository).findByArtist(any(Artist.class));
    }
}
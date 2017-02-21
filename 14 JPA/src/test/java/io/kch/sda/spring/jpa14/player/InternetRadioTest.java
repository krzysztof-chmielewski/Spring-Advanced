package io.kch.sda.spring.jpa14.player;

import io.kch.sda.spring.jpa14.song.Song;
import io.kch.sda.spring.jpa14.song.SongRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InternetRadioTest {
    @Mock
    private SongRepository songRepository;

    private InternetRadio internetRadio;

    @Before
    public void setUp() throws Exception {
        internetRadio = new InternetRadio(songRepository);
    }

    @Test
    public void noSongsArePlayedAtTheBeginning() throws Exception {
        assertThat(internetRadio.playedSongs()).isEqualTo(Collections.emptyList());
        assertThat(internetRadio.currentSong()).isNull();
    }

    @Test
    public void playingOneSongsAddsItToTheListOfSongs() throws Exception {
        Song song = new Song("Artist", "Album", "Title");

        internetRadio.playSong(song);
        when(songRepository.findAll()).thenReturn(Collections.singletonList(song));

        assertThat(internetRadio.playedSongs()).contains(song);
        assertThat(internetRadio.playedSongs()).hasSize(1);
        assertThat(internetRadio.currentSong()).isEqualTo(song);
    }

    @Test
    public void playingThreeSongsAddsThemToTheListOfSongs() throws Exception {
        Song first = new Song("Artist", "Album", "Title");
        Song second = new Song("Artist2", "Album2", "Title2");
        Song third = new Song("Artist3", "Album3", "Title2");

        internetRadio.playSong(first);
        internetRadio.playSong(second);
        internetRadio.playSong(third);
        when(songRepository.findAll()).thenReturn(Arrays.asList(first, second, third));

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
        Song song = new Song("artist", "album", "title");
        song.setId(5);
        internetRadio.replaceSongInPlaylist(song);

        verify(songRepository).save(song);
    }

    @Test
    public void filterByArtistName() {
        internetRadio.filterByArtist("artist");

        verify(songRepository).findByArtist("artist");
    }
}
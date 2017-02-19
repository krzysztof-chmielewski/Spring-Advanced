package io.kch.sda.spring.orm11.player;

import io.kch.sda.spring.orm11.song.Song;
import io.kch.sda.spring.orm11.song.SongRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

//FIXME: make me pass again!
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

        assertThat(internetRadio.playedSongs()).contains(first, second, third);
        assertThat(internetRadio.playedSongs()).hasSize(3);
        assertThat(internetRadio.currentSong()).isEqualTo(third);
    }
}
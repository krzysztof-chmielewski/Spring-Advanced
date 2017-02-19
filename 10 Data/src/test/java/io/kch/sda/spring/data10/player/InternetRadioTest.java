package io.kch.sda.spring.data10.player;

import io.kch.sda.spring.data10.song.Song;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class InternetRadioTest {
    private final InternetRadio internetRadio = new InternetRadio();

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
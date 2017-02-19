package io.kch.sda.spring.unit06.player;

import io.kch.sda.spring.unit06.song.Song;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;

public class InternetRadioTest {
    private final InternetRadio internetRadio = new InternetRadio();

    @Test
    public void noSongsArePlayedAtTheBeginning() throws Exception {
        Assertions.assertThat(internetRadio.playedSongs()).isEqualTo(Collections.emptyList());
        Assertions.assertThat(internetRadio.currentSong()).isNull();
    }

    @Test
    public void playingOneSongsAddsItToTheListOfSongs() throws Exception {
        Song song = new Song("Artist", "Album", "Title");

        internetRadio.playSong(song);

        Assertions.assertThat(internetRadio.playedSongs()).contains(song);
        Assertions.assertThat(internetRadio.playedSongs()).hasSize(1);
        Assertions.assertThat(internetRadio.currentSong()).isEqualTo(song);
    }

    @Test
    public void playingThreeSongsAddsThemToTheListOfSongs() throws Exception {
        Song first = new Song("Artist", "Album", "Title");
        Song second = new Song("Artist2", "Album2", "Title2");
        Song third = new Song("Artist3", "Album3", "Title2");

        //FIXME: finish testing that one
        throw new Exception();
    }
}
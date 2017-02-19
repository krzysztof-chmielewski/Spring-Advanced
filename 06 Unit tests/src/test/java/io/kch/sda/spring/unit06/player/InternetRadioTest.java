package io.kch.sda.spring.unit06.player;

import io.kch.sda.spring.unit06.song.Song;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;

public class InternetRadioTest {

    @Test
    public void noSongsArePlayedAtTheBeginning() throws Exception {
        Assertions.assertThat(new InternetRadio().playedSongs()).isEqualTo(Collections.emptyList());
    }

    @Test
    public void playingOneSongsAddsItToTheListOfSongs() throws Exception {
        InternetRadio internetRadio = new InternetRadio();
        Song song = new Song("Artist", "Album", "Title");

        internetRadio.playSong(song);

        Assertions.assertThat(internetRadio.playedSongs()).contains(song);
        Assertions.assertThat(internetRadio.playedSongs()).hasSize(1);
    }

    @Test
    public void playingThreeSongsAddsThemToTheListOfSongs() throws Exception {
        InternetRadio internetRadio = new InternetRadio();
        Song first = new Song("Artist", "Album", "Title");
        Song second = new Song("Artist2", "Album2", "Title2");
        Song third = new Song("Artist3", "Album3", "Title2");

        //FIXME: finish testing that one
        throw new Exception();
    }
}
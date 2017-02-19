package io.kch.sda.spring.rest03.player;

import io.kch.sda.spring.rest03.song.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InternetRadio implements MusicPlayer {
    private final List<Song> playedSongs = new ArrayList<>();
    private Song currentSong;

    public InternetRadio() {
        playSong(new Song("Iron Maiden", "A Matter of Life and Death", "For the Greater Good of God"));
        playSong(new Song("Iron Maiden", "Fear of the Dark", "Fear od the Dark"));
    }

    @Override
    public void playSong(Song song) {
        currentSong = song;
        playedSongs.add(song);
    }

    @Override
    public Song currentSong() {
        return currentSong;
    }

    @Override
    public List<Song> playedSongs() {
        return playedSongs;
    }
}

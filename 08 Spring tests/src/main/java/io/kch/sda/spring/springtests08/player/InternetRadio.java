package io.kch.sda.spring.springtests08.player;

import io.kch.sda.spring.springtests08.song.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InternetRadio implements MusicPlayer {
    private final List<Song> playedSongs = new ArrayList<>();
    private Song currentSong;

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

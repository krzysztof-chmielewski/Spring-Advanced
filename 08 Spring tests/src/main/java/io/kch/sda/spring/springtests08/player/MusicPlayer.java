package io.kch.sda.spring.springtests08.player;

import io.kch.sda.spring.springtests08.song.Song;

import java.util.List;

public interface MusicPlayer {
    void playSong(Song song);

    Song currentSong();

    List<Song> playedSongs();
}

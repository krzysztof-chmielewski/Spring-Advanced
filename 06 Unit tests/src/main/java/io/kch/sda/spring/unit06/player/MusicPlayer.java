package io.kch.sda.spring.unit06.player;

import io.kch.sda.spring.unit06.song.Song;

import java.util.List;

public interface MusicPlayer {
    void playSong(Song song);

    Song currentSong();

    List<Song> playedSongs();
}

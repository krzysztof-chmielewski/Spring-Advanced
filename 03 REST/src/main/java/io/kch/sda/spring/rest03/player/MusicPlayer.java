package io.kch.sda.spring.rest03.player;

import io.kch.sda.spring.rest03.song.Song;

import java.util.List;

public interface MusicPlayer {
    void playSong(Song song);

    Song currentSong();

    List<Song> playedSongs();
}

package io.kch.sda.spring.orm12.player;

import io.kch.sda.spring.orm12.song.Song;

import java.util.List;

public interface MusicPlayer {
    void playSong(Song song);

    Song currentSong();

    List<Song> playedSongs();

    void clearPlaylist();

    void removeSongFromPlaylist(Integer id);

    void replaceSongInPlaylist(Song song);
}

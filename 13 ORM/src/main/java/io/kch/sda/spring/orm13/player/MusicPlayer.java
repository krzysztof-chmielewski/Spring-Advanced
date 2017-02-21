package io.kch.sda.spring.orm13.player;

import io.kch.sda.spring.orm13.song.Song;

import java.util.List;

public interface MusicPlayer {
    void playSong(Song song);

    Song currentSong();

    List<Song> playedSongs();

    List<Song> filterByArtist(String artist);

    void clearPlaylist();

    void removeSongFromPlaylist(Integer id);

    void replaceSongInPlaylist(Song song);
}

package io.kch.sda.spring.jpa14.player;

import io.kch.sda.spring.jpa14.song.Song;

import java.util.List;

public interface MusicPlayer {
    void playSong(Song song);

    Song currentSong();

    List<Song> playedSongs();

    List<Song> filterByArtist(String artist);

    List<Song> filterByArtist(String artist, int start, int offset);

    List<Song> filterByArtistAndAlbum(String artist, String album);

    List<Song> filterTop5ByArtist(String artist);

    void clearPlaylist();

    void removeSongFromPlaylist(Integer id);

    void replaceSongInPlaylist(Song song);
}

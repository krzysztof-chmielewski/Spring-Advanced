package io.kch.sda.spring.security16.player;

import io.kch.sda.spring.security16.song.SongBean;

import java.util.List;

public interface MusicPlayer {
    void playSong(SongBean song);

    SongBean currentSong();

    List<SongBean> playedSongs();

    List<SongBean> filterByArtist(String artist);

    List<SongBean> filterByArtist(String artist, int start, int offset);

    List<SongBean> filterByArtistAndAlbum(String artist, String album);

    List<SongBean> filterTop5ByArtist(String artist);

    List<SongBean> orderAndFilterBy(int start, int offset, String orderBy, String field);

    void clearPlaylist();

    void removeSongFromPlaylist(Integer id);

    void replaceSongInPlaylist(SongBean song);
}

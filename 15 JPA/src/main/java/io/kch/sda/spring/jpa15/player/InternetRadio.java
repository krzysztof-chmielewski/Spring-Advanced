package io.kch.sda.spring.jpa15.player;

import io.kch.sda.spring.jpa15.song.Song;
import io.kch.sda.spring.jpa15.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternetRadio implements MusicPlayer {
    private final SongRepository songRepository;
    private Song currentSong;

    @Autowired
    public InternetRadio(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void playSong(Song song) {
        songRepository.save(song);
        currentSong = song;
    }

    @Override
    public Song currentSong() {
        return currentSong;
    }

    @Override
    public List<Song> playedSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<Song> filterByArtist(String artist) {
        return songRepository.findByArtist(artist);
    }

    @Override
    public List<Song> filterByArtist(String artist, int start, int size) {
        return songRepository.findByArtist(artist, new PageRequest(start, size));
    }

    @Override
    public List<Song> filterByArtistAndAlbum(String artist, String album) {
        return songRepository.findByArtistAndAlbumOrderByTitle(artist, album);
    }

    @Override
    public List<Song> filterTop5ByArtist(String artist) {
        return songRepository.findTop5ByArtist(artist);
    }

    @Override
    public List<Song> orderAndFilterBy(int start, int offset, String orderBy, String field) {
        return songRepository.findAll(new PageRequest(start, offset, Sort.Direction.fromString(orderBy), field)).getContent();
    }

    @Override
    public void clearPlaylist() {
        songRepository.deleteAll();
    }

    @Override
    public void removeSongFromPlaylist(Integer id) {
        songRepository.delete(id);
    }

    @Override
    public void replaceSongInPlaylist(Song song) {
        songRepository.save(song);
    }
}

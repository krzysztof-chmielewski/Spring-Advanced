package io.kch.sda.spring.jpa14.player;

import io.kch.sda.spring.jpa14.song.Song;
import io.kch.sda.spring.jpa14.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

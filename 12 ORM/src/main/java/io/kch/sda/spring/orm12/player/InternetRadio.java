package io.kch.sda.spring.orm12.player;

import io.kch.sda.spring.orm12.song.Song;
import io.kch.sda.spring.orm12.song.SongRepository;
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
    public void clearPlaylist() {

    }

    @Override
    public void removeSongFromPlaylist(Integer id) {

    }

    @Override
    public void replaceSongInPlaylist(Song song) {

    }
}

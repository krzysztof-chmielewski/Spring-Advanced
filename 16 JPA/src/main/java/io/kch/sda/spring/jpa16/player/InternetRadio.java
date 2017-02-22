package io.kch.sda.spring.jpa16.player;

import io.kch.sda.spring.jpa16.song.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InternetRadio implements MusicPlayer {
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private SongBean currentSong;

    @Autowired
    public InternetRadio(ArtistRepository artistRepository, AlbumRepository albumRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    @Override
    public void playSong(SongBean song) {
        Song entity = new Song();
        entity.setId(song.getId());
        entity.setAlbum(albumRepository.findByAlbum(song.getAlbum()));
        entity.setTitle(song.getTitle());
        songRepository.save(entity);
        currentSong = song;
    }

    @Override
    public SongBean currentSong() {
        return currentSong;
    }

    @Override
    public List<SongBean> playedSongs() {
        return entitiesToBeans(songRepository.findAll());
    }

    @Override
    public List<SongBean> filterByArtist(String artist) {
        return entitiesToBeans(songRepository.findByArtist(artistRepository.findByArtist(artist)));
    }

    @Override
    public List<SongBean> filterByArtist(String artist, int start, int size) {
        return entitiesToBeans(songRepository.findByArtist(artistRepository.findByArtist(artist), new PageRequest(start, size)));
    }

    @Override
    public List<SongBean> filterByArtistAndAlbum(String artist, String album) {
        return entitiesToBeans(songRepository.findByArtistAndAlbumOrderByTitle(
                artistRepository.findByArtist(artist), albumRepository.findByAlbum(album)));
    }

    @Override
    public List<SongBean> filterTop5ByArtist(String artist) {
        return entitiesToBeans(songRepository.findTop5ByArtist(artistRepository.findByArtist(artist)));
    }

    @Override
    public List<SongBean> orderAndFilterBy(int start, int offset, String orderBy, String field) {
        return entitiesToBeans(songRepository.findAll(new PageRequest(start, offset, Sort.Direction.fromString(orderBy), field)).getContent());
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
    public void replaceSongInPlaylist(SongBean song) {
        songRepository.save(beanToEntity(song));
    }

    private List<SongBean> entitiesToBeans(List<Song> entities) {
        List<SongBean> beans = new ArrayList<>(entities.size());

        for (Song song : entities ) {
            beans.add(song.toBean());
        }

        return beans;
    }

    Song beanToEntity(SongBean bean) {
        Album album = albumRepository.findByAlbum(bean.getAlbum());
        Artist artist = artistRepository.findByArtist(bean.getArtist());
        if (artist == null) {
            artist = artistRepository.save(new Artist(bean.getArtist()));
        }
        if (album == null) {
            album = albumRepository.save(new Album(artist, bean.getAlbum()));
        }

        return new Song(bean.getId(), album, bean.getTitle());
    }
}

package io.kch.sda.spring.security16.song;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByArtist(Artist artist);

    List<Song> findByArtistAndAlbumOrderByTitle(Artist artist, Album album);

    List<Song> findTop5ByArtist(Artist artist);

    List<Song> findByArtist(Artist artist, Pageable pageable);
}

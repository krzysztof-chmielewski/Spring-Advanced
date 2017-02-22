package io.kch.sda.spring.jpa15.song;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByArtist(String artist);

    List<Song> findByArtistAndAlbumOrderByTitle(String artist, String album);

    List<Song> findTop5ByArtist(String artist);

    List<Song> findByArtist(String artist, Pageable pageable);
}

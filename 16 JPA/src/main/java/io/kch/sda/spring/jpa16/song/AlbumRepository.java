package io.kch.sda.spring.jpa16.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album findByAlbum(String album);

    List<Album> findByArtist(Artist artist);

    List<Album> findByArtist(Integer artistId);
}

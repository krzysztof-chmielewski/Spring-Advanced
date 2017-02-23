package io.kch.sda.spring.boot17.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "songs", path = "songs")
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findByArtist(@Param("artist") String artist);

    List<Song> findByAlbum(@Param("album") String album);

    List<Song> findByTitle(@Param("title") String title);

    List<Song> findByArtistAndAlbum(@Param("artist") String artist, @Param("album") String album);
}

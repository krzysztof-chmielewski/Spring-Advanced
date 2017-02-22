package io.kch.sda.spring.security16.song;

import javax.persistence.*;

@Entity
@Table(name = "song", catalog = "spring")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Album album;

    private String title;

    public Song(Integer id, Album album, String title) {
        this.id = id;
        this.album = album;
        this.artist = album.getArtist();
        this.title = title;
    }

    public Song(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
        artist = album.getArtist();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SongBean toBean() {
        return new SongBean(id, artist.getArtist(), album.getAlbum(), title);
    }
}

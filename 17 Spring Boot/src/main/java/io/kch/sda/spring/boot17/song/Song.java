package io.kch.sda.spring.boot17.song;

import javax.persistence.*;

@Entity
@Table(name = "song", catalog = "spring")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String artist;
    private String album;
    private String title;

    public Song(String artist, String album, String title) {
        this.artist = artist;
        this.album = album;
        this.title = title;
    }

    public Song() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return artist + ": " + album + ": " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (artist != null ? !artist.equals(song.artist) : song.artist != null) return false;
        if (album != null ? !album.equals(song.album) : song.album != null) return false;
        return title != null ? title.equals(song.title) : song.title == null;
    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (album != null ? album.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}

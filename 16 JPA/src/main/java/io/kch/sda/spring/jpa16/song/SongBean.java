package io.kch.sda.spring.jpa16.song;

import org.hibernate.validator.constraints.NotEmpty;

public class SongBean {
    private Integer id;

    @NotEmpty
    private String artist;

    @NotEmpty
    private String album;

    @NotEmpty
    private String title;


    public SongBean(Integer id, String artist, String album, String title) {
        this.id = id;
        this.artist = artist;
        this.album = album;
        this.title = title;
    }

    public SongBean(String artist, String album, String title) {
        this.artist = artist;
        this.album = album;
        this.title = title;
    }

    public SongBean() {
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

        SongBean song = (SongBean) o;

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

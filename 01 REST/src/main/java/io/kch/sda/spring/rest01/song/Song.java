package io.kch.sda.spring.rest01.song;

import org.hibernate.validator.constraints.NotEmpty;

public class Song {
    @NotEmpty
    private String artist;

    @NotEmpty
    private String album;

    @NotEmpty
    private String title;

    public Song(String artist, String album, String title) {
        this.artist = artist;
        this.album = album;
        this.title = title;
    }

    public Song() {
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
}

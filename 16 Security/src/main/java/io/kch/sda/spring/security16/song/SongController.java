package io.kch.sda.spring.security16.song;

import io.kch.sda.spring.security16.player.MusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "songs")
public class SongController {
    private final MusicPlayer musicPlayer;

    @Autowired
    public SongController(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @GetMapping(path = "")
    public List<SongBean> list() {
        return musicPlayer.playedSongs();
    }

    @GetMapping(path = "artist/{artist}")
    public List<SongBean> listByArtist(@PathVariable String artist) {
        return musicPlayer.filterByArtist(artist);
    }

    @GetMapping(path = "orderBy/{field}/{direction}/{start}/{size}")
    public List<SongBean> listByArtist(@PathVariable String field, @PathVariable String direction, @PathVariable int start,
                                       @PathVariable int size) {
        return musicPlayer.orderAndFilterBy(start, size, direction, field);
    }

    @GetMapping(path = "artist/{artist}/album/{album}")
    public List<SongBean> listByArtistAndAlbum(@PathVariable String artist, @PathVariable String album) {
        return musicPlayer.filterByArtistAndAlbum(artist, album);
    }

    @GetMapping(path = "artist/{artist}/top5")
    public List<SongBean> listTop5ByArtist(@PathVariable String artist) {
        return musicPlayer.filterTop5ByArtist(artist);
    }


    @GetMapping(path = "artist/{artist}/{start}/{size}")
    public List<SongBean> listByArtist(@PathVariable String artist, @PathVariable int start,
                                       @PathVariable int size) {
        return musicPlayer.filterByArtist(artist, start, size);
    }

    @GetMapping(path = "{id}")
    public SongBean get(@PathVariable Integer id) {
        return musicPlayer.playedSongs().get(id);
    }

    @GetMapping(path = "range/{beginIndex}/{endIndex}")
    public List<SongBean> listFromTo(@PathVariable Integer beginIndex, @PathVariable Integer endIndex) {
        return musicPlayer.playedSongs().subList(beginIndex, endIndex);
    }

    @PostMapping(path = "")
    public String post(@Valid SongBean song, HttpServletRequest request) throws IOException {
        musicPlayer.playSong(song);

        return request.getRequestURL() + "/" + String.valueOf(musicPlayer.playedSongs().size() - 1);
    }

    @DeleteMapping(path = "")
    public void delete() throws IOException {
        musicPlayer.clearPlaylist();
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) throws IOException {
        musicPlayer.removeSongFromPlaylist(id);
    }

    @PutMapping(path = "{id}")
    public void put(@PathVariable int id, @Valid SongBean song) throws IOException {
        song.setId(id);
        musicPlayer.replaceSongInPlaylist(song);
    }
}

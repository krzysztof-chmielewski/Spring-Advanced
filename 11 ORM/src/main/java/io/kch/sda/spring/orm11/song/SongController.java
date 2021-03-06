package io.kch.sda.spring.orm11.song;

import io.kch.sda.spring.orm11.player.MusicPlayer;
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
    public List<Song> list() {
        return musicPlayer.playedSongs();
    }

    @GetMapping(path = "{id}")
    public Song get(@PathVariable Integer id) {
        return musicPlayer.playedSongs().get(id);
    }

    @GetMapping(path = "range/{beginIndex}/{endIndex}")
    public List<Song> listFromTo(@PathVariable Integer beginIndex, @PathVariable Integer endIndex) {
        return musicPlayer.playedSongs().subList(beginIndex, endIndex);
    }

    @PostMapping(path = "")
    public String post(@Valid Song song, HttpServletRequest request) throws IOException {
        musicPlayer.playSong(song);

        return request.getRequestURL() + "/" + String.valueOf(musicPlayer.playedSongs().size() - 1);
    }

    @DeleteMapping(path = "")
    public void delete() throws IOException {
        musicPlayer.playedSongs().clear();
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) throws IOException {
        musicPlayer.playedSongs().remove(id);
    }

    @PutMapping(path = "{id}")
    public void put(@PathVariable int id, @Valid Song song) throws IOException {
        Song currentSong = musicPlayer.playedSongs().get(id);

        currentSong.setArtist(song.getArtist());
        currentSong.setAlbum(song.getAlbum());
        currentSong.setTitle(song.getTitle());
    }
}

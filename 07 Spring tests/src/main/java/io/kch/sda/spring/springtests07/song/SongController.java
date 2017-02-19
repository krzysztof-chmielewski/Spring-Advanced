package io.kch.sda.spring.springtests07.song;

import io.kch.sda.spring.springtests07.player.MusicPlayer;
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
}

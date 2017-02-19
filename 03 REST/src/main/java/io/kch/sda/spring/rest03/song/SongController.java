package io.kch.sda.spring.rest03.song;

import io.kch.sda.spring.rest03.player.MusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //FIXME create method that will POST a Song, play it and return its URI
}

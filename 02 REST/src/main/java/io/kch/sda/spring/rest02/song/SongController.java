package io.kch.sda.spring.rest02.song;

import io.kch.sda.spring.rest02.player.MusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//FIXME: I am definitely too verbose. Time to get thinner!
@Controller
public class SongController {
    private final MusicPlayer musicPlayer;

    @Autowired
    public SongController(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @ResponseBody
    @RequestMapping(path = "songs", method = RequestMethod.GET)
    public List<Song> list() {
        return musicPlayer.playedSongs();
    }

    @ResponseBody
    @RequestMapping(path = "songs/{id}", method = RequestMethod.GET)
    public Song get(@PathVariable Integer id) {
        return musicPlayer.playedSongs().get(id);
    }

    @ResponseBody
    @RequestMapping(path = "songs/range/{beginIndex}/{endIndex}", method = RequestMethod.GET)
    public List<Song> listFromTo(@PathVariable Integer beginIndex, @PathVariable Integer endIndex) {
        return musicPlayer.playedSongs().subList(beginIndex, endIndex);
    }
}

package io.kch.sda.spring.data10.song;

import io.kch.sda.spring.data10.player.MusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path = "songs")
public class SongController {
    private final MusicPlayer musicPlayer;
    private final DataSource dataSource;

    @Autowired
    public SongController(MusicPlayer musicPlayer, DataSource dataSource) {
        this.musicPlayer = musicPlayer;
        this.dataSource = dataSource;
    }

    @PostMapping(path = "prepopulate")
    public void prepopulate() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        List<Song> songs = template.query("SELECT * FROM song", new RowMapper<Song>() {
            @Override
            public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Song(rs.getString("artist"),
                        rs.getString("album"),
                        rs.getString("title"));
            }
        });

        for (Song song : songs) {
            musicPlayer.playSong(song);
        }
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

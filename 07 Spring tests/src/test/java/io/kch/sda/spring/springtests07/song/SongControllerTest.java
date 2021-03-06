package io.kch.sda.spring.springtests07.song;

import io.kch.sda.spring.springtests07.player.InternetRadio;
import io.kch.sda.spring.springtests07.player.MusicPlayer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SongControllerTest {
    private MusicPlayer musicPlayer = new InternetRadio();

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        SongController controller = new SongController(musicPlayer);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void getForNonEmptyList() throws Exception {
        musicPlayer.playSong(new Song("Artist", "Album", "Title"));

        mockMvc.perform(get("/songs/0"))
                .andExpect(status().isOk())
                .andExpect(content().json("{artist:'Artist',album:'Album',title:'Title'}"));
    }

    @Test
    public void getRangeForOneElementList() throws Exception {
        musicPlayer.playSong(new Song("Artist", "Album", "Title"));

        mockMvc.perform(get("/songs/range/0/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{artist:'Artist',album:'Album',title:'Title'}]"));
    }

    @Test
    public void getRangeForMoreElements() throws Exception {
        Song first = new Song("Artist", "Album", "Title");
        Song second = new Song("Artist2", "Album2", "Title2");
        Song third = new Song("Artist3", "Album3", "Title3");
        Song fourth = new Song("Artist4", "Album4", "Title4");

        musicPlayer.playSong(first);
        musicPlayer.playSong(second);
        musicPlayer.playSong(third);
        musicPlayer.playSong(fourth);

        //FIXME: perform mock request to verify if /songs/range works. You may check it for get(songs/range/1/3)
        throw new Exception();
    }
}
package io.kch.sda.spring.data10.song;

import io.kch.sda.spring.data10.player.MusicPlayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class SongControllerTest {
    @Mock
    private MusicPlayer musicPlayer;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        SongController controller = new SongController(musicPlayer);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void getForNonEmptyList() throws Exception {
        Song song = new Song("Artist", "Album", "Title");
        when(musicPlayer.playedSongs()).thenReturn(Collections.singletonList(song));

        mockMvc.perform(get("/songs/0"))
                .andExpect(status().isOk())
                .andExpect(content().json("{artist:'Artist',album:'Album',title:'Title'}"));
    }

    @Test
    public void getRangeForOneElementList() throws Exception {
        Song song = new Song("Artist", "Album", "Title");
        when(musicPlayer.currentSong()).thenReturn(song);
        when(musicPlayer.playedSongs()).thenReturn(Collections.singletonList(song));

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

        when(musicPlayer.playedSongs()).thenReturn(Arrays.asList(first, second, third, fourth));

        mockMvc.perform(get("/songs/range/1/3"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{artist:'Artist2',album:'Album2',title:'Title2'}," +
                        "{artist:'Artist3',album:'Album3',title:'Title3'}]"));
    }

    @Test
    public void deleteWholeCollectionOfSongs() throws Exception {
        Song first = new Song("Artist", "Album", "Title");
        Song second = new Song("Artist2", "Album2", "Title2");
        Song third = new Song("Artist3", "Album3", "Title3");
        Song fourth = new Song("Artist4", "Album4", "Title4");

        when(musicPlayer.playedSongs()).thenReturn(new ArrayList<>(Arrays.asList(first, second, third, fourth)));

        mockMvc.perform(delete("/songs"))
                .andExpect(status().isOk());

        assertThat(musicPlayer.playedSongs()).hasSize(0);
    }

    @Test
    public void deleteOneSong() throws Exception {
        Song first = new Song("Artist", "Album", "Title");
        Song second = new Song("Artist2", "Album2", "Title2");
        Song third = new Song("Artist3", "Album3", "Title3");
        Song fourth = new Song("Artist4", "Album4", "Title4");

        when(musicPlayer.playedSongs()).thenReturn(new ArrayList<>(Arrays.asList(first, second, third, fourth)));

        mockMvc.perform(delete("/songs/1"))
                .andExpect(status().isOk());

        assertThat(musicPlayer.playedSongs().get(1)).isSameAs(third);
    }

    @Test
    public void putSong() throws Exception {
        Song song = new Song("Artist", "Album", "Title");

        when(musicPlayer.playedSongs()).thenReturn(Collections.singletonList(song));

        mockMvc.perform(put("/songs/0?artist=ArtistNew&album=AlbumNew&title=TitleNew"))
                .andExpect(status().isOk());

        Song expectedResult = new Song("ArtistNew", "AlbumNew", "TitleNew");

        assertThat(musicPlayer.playedSongs().get(0)).isEqualTo(expectedResult);
    }
}
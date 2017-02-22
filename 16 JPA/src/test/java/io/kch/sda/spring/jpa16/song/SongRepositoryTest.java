package io.kch.sda.spring.jpa16.song;

import io.kch.sda.spring.jpa16.configuration.SqlConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SqlConfig.class)
@ActiveProfiles("test")
public class SongRepositoryTest {
    @Autowired
    private SongRepository songRepository;

    @Test
    public void sanityTest() throws Exception {
        assertThat(songRepository).isNotNull();
        assertThat(songRepository.findAll()).isNotEmpty();
    }
}
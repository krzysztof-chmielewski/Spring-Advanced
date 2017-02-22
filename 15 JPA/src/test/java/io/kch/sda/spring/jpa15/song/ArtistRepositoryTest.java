package io.kch.sda.spring.jpa15.song;

import io.kch.sda.spring.jpa15.configuration.SqlConfig;
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
public class ArtistRepositoryTest {
    @Autowired
    private ArtistRepository artistRepository;

    @Test
    public void sanityTest() throws Exception {
        assertThat(artistRepository).isNotNull();
        assertThat(artistRepository.findAll()).isNotEmpty();
    }
}
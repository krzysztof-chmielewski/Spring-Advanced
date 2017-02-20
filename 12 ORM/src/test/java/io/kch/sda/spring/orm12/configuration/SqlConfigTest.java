package io.kch.sda.spring.orm12.configuration;

import io.kch.sda.spring.orm12.configuration.SqlConfig;
import io.kch.sda.spring.orm12.song.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SqlConfig.class)
@ActiveProfiles("test")
public class SqlConfigTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void smoke() throws Exception {
        assertThat(dataSource).isNotNull();
    }

    @Test
    public void selectAllSongs() throws Exception {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        List<Song> songs = template.query("SELECT * FROM song", new RowMapper<Song>() {
            @Override
            public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Song(rs.getString("artist"),
                        rs.getString("album"),
                        rs.getString("title"));
            }
        });

        assertThat(songs).hasSize(2);
    }
}
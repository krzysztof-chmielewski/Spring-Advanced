package io.kch.sda.spring.jpa14.configuration;

import io.kch.sda.spring.jpa14.common.GlobalControllerExceptionHandler;
import io.kch.sda.spring.jpa14.player.MusicPlayer;
import io.kch.sda.spring.jpa14.song.SongController;
import io.kch.sda.spring.jpa14.song.SongRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {MusicPlayer.class, SongController.class, GlobalControllerExceptionHandler.class})
@Import(SqlConfig.class)
@PropertySource("classpath:config.properties")
@EnableJpaRepositories(basePackageClasses = SongRepository.class)
public class Config {
}

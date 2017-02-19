package io.kch.sda.spring.rest04.configuration;

import io.kch.sda.spring.rest04.player.MusicPlayer;
import io.kch.sda.spring.rest04.song.SongController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {MusicPlayer.class, SongController.class})
public class Config {
}

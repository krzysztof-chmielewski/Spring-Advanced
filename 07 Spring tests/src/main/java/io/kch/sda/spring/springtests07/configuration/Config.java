package io.kch.sda.spring.springtests07.configuration;

import io.kch.sda.spring.springtests07.common.GlobalControllerExceptionHandler;
import io.kch.sda.spring.springtests07.player.MusicPlayer;
import io.kch.sda.spring.springtests07.song.SongController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {MusicPlayer.class, SongController.class, GlobalControllerExceptionHandler.class})
public class Config {
}

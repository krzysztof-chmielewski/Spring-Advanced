package io.kch.sda.spring.springtests09.configuration;

import io.kch.sda.spring.springtests09.common.GlobalControllerExceptionHandler;
import io.kch.sda.spring.springtests09.player.MusicPlayer;
import io.kch.sda.spring.springtests09.song.SongController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {MusicPlayer.class, SongController.class, GlobalControllerExceptionHandler.class})
public class Config {
}

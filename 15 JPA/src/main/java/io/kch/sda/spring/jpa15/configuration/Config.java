package io.kch.sda.spring.jpa15.configuration;

import io.kch.sda.spring.jpa15.common.GlobalControllerExceptionHandler;
import io.kch.sda.spring.jpa15.player.MusicPlayer;
import io.kch.sda.spring.jpa15.song.SongController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {MusicPlayer.class, SongController.class, GlobalControllerExceptionHandler.class})
@Import(SqlConfig.class)
@PropertySource("classpath:config.properties")
public class Config {
}

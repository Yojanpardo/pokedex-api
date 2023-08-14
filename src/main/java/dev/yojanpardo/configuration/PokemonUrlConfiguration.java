package dev.yojanpardo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokemonUrlConfiguration {

    @Value("${pokeapi.url}")
    private String pokeApiUrl;


    @Bean
    public String getPokeApiUrl(){
        return this.pokeApiUrl;
    }

}

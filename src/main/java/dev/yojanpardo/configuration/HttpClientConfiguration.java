package dev.yojanpardo.configuration;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfiguration {

    @Bean
    public OkHttpClient httpClient(){
        return new OkHttpClient();
    }
}

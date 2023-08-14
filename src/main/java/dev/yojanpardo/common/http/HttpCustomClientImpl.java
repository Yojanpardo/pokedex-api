package dev.yojanpardo.common.http;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpCustomClientImpl implements HttpCustomClient {

    private final OkHttpClient httpClient;

    @Override
    public <T> T executeRequest(Request request, Class<T> responseType) {
        try {
            log.info("getting pokemons from pokeApi");
            Date start = new Date();
            final Response response = httpClient.newCall(request).execute();
            Date end = new Date();
            log.debug("time took to get pokemons {} milis", end.getTime() - start.getTime());
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body().string(), responseType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

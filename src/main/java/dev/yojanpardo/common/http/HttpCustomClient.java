package dev.yojanpardo.common.http;

import com.squareup.okhttp.Request;
import org.springframework.stereotype.Component;

public interface HttpCustomClient{
    <T> T executeRequest(final Request request, Class<T> responseType);
}

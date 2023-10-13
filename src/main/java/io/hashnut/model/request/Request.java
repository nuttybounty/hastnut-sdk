package io.hashnut.model.request;

import java.util.Map;

public interface Request<T> {
    boolean needSign();
    String getUri();
    String getMethod();
    Map<String,Object> getPayload() throws Exception;
    Class<T> getResponseClass();
}

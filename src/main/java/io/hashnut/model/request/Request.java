package io.hashnut.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public interface Request<T> {
    @JsonIgnore
    boolean needSign();
    @JsonIgnore
    String getUri();
    @JsonIgnore
    String getMethod();
    @JsonIgnore
    String getPayload(ObjectMapper objectMapper) throws Exception;
    @JsonIgnore
    Class<T> getResponseClass();
}

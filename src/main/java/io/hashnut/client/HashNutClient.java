package io.hashnut.client;

import java.util.Map;

public interface HashNutClient {
    HashNutClientResponse request(String method, boolean needSign, String uri, Map<String,Object> payload);
}

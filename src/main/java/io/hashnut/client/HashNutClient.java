package io.hashnut.client;

import java.util.Map;

public interface HashNutClient {
    HashNutClientResponse request(String uri, String body,boolean needSign);
}

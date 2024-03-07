package io.hashnut.authentication;

import io.hashnut.util.PayDigestUtil;

public class Authentication {
    private final String requestKey;
    private final String responseKey;

    public Authentication(String requestKey, String responseKey) {
        this.requestKey = requestKey;
        this.responseKey = responseKey;
    }

    public String generateHashNutSign(String uuid,long timestamp,String body) throws Exception {
        String signMessage=String.format("%s%d%s",uuid,timestamp,body);
        return PayDigestUtil.HMACSHA256Base64(requestKey,signMessage);
    }
}

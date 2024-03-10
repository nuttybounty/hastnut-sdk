package io.hashnut.authentication;

import io.hashnut.util.PayDigestUtil;

public class Authentication {
    private final String secretKey;

    public Authentication(String secretKey) {
        this.secretKey = secretKey;
    }

    public String generateHashNutSign(String uuid,long timestamp,String body) throws Exception {
        String signMessage=String.format("%s%d%s",uuid,timestamp,body);
        return PayDigestUtil.HMACSHA256Base64(secretKey,signMessage);
    }
}

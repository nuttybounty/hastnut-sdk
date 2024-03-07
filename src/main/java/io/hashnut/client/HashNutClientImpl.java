package io.hashnut.client;

import io.hashnut.authentication.Authentication;
import io.hashnut.exception.SystemErrorException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.*;

public class HashNutClientImpl implements HashNutClient {
    /**
     * The production environment
     */
    private static final String PRODUCTION_URL = "https://hashnut.io/api/v2.0.0";

    /**
     * The sandbox environment
     */
    private static final String SANDBOX_URL = "https://testnet-web3.hashnut.io/api/v2.0.0";

    private final Authentication authentication;
    private final String baseUrl;

    public HashNutClientImpl(String requestKey, String responseKey, boolean testMode) {
        this.baseUrl = testMode ? SANDBOX_URL : PRODUCTION_URL;
        this.authentication = new Authentication(requestKey, responseKey);
    }

    @Override
    public HashNutClientResponse request(String uri, String body,boolean needSign) {
        TrustManager[] trustManagers = buildTrustManagers();
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .sslSocketFactory(createSSLSocketFactory(trustManagers), (X509TrustManager) trustManagers[0])
                .hostnameVerifier((hostName, session) -> true)
                .retryOnConnectionFailure(true)
                .build();
        try {
            // serialize to json
            RequestBody requestBody = RequestBody.create(body,MediaType.parse("application/json; charset=utf-8"));
            Request.Builder request = new Request.Builder().post(requestBody).url(this.baseUrl + uri);
            if(needSign){
                String uuid= UUID.randomUUID().toString();
                long timestamp=System.currentTimeMillis();
                String sign=this.authentication.generateHashNutSign(uuid,timestamp,body);
                request.addHeader("hashnut-request-uuid",uuid);
                request.addHeader("hashnut-request-timestamp",Long.toString(timestamp,10));
                request.addHeader("hashnut-request-sign",sign);
            }
            Response response = httpClient.newCall(request.build()).execute();
            return new HashNutClientResponse(response.code(), Objects.requireNonNull(response.body()).string());
        } catch (Exception e) {
            throw new SystemErrorException("Error making API call to HashNut", e);
        }
    }

    private static SSLSocketFactory createSSLSocketFactory(TrustManager[] trustAllCerts) {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssfFactory;
    }

    private static TrustManager[] buildTrustManagers() {
        return new TrustManager[]{
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            }
        };
    }
}

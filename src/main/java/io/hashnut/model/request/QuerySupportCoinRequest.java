package io.hashnut.model.request;


import io.hashnut.model.response.QueryCoinsResponse;

import java.util.HashMap;
import java.util.Map;

public class QuerySupportCoinRequest extends GetRequest<QueryCoinsResponse>{
    private final String BASE_URL="/mch/querySupportCoinsByChainCode";
    private final String chainCode;

    public QuerySupportCoinRequest(Builder builder){
        this.chainCode=builder.chainCode;
    }

    @Override
    public String getUri() {
        Map<String, String> uriParams = new HashMap<>();
        this.addUriParam(uriParams, "chainCode", chainCode);
        return appendUriParams(BASE_URL, uriParams);
    }

    @Override
    public Class<QueryCoinsResponse> getResponseClass() {
        return QueryCoinsResponse.class;
    }

    public static class Builder{
        private String chainCode;

        public Builder(){

        }

        public Builder(String chainCode){
            this.chainCode=chainCode;
        }

        public Builder withChainCode(String chainCode){
            this.chainCode=chainCode;
            return this;
        }

        public QuerySupportCoinRequest build(){
            return new QuerySupportCoinRequest(this);
        }
    }
}

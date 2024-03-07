package io.hashnut.model.request;


import io.hashnut.model.response.QueryCoinsResponse;

import java.util.HashMap;
import java.util.Map;

public class QuerySupportCoinRequest extends PostRequest<QueryCoinsResponse>{
    private final String chainCode;

    public String getChainCode() {
        return chainCode;
    }

    public QuerySupportCoinRequest(Builder builder){
        this.chainCode=builder.chainCode;
    }

    @Override
    public String getUri() {
       //return "/mch/querySupportCoinsByChainCode";
        return "/config/querySupportCoinsByChainCode";
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

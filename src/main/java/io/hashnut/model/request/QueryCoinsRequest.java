package io.hashnut.model.request;

import io.hashnut.model.CoinInfo;
import io.hashnut.model.response.QueryCoinsResponse;

import java.util.List;

public class QueryCoinsRequest extends GetRequest<QueryCoinsResponse> {

    public QueryCoinsRequest(Builder builder){

    }

    @Override
    public String getUri() {
//        String uri = BASE_URI + this.orderId;
//
//        Map<String, String> uriParams = new HashMap<>();
//        this.addUriParam(uriParams, "fx_currency", fxCurrency);
        return "/mch/queryAllCoinInfo";
    }

    @Override
    public Class<QueryCoinsResponse> getResponseClass() {
        return QueryCoinsResponse.class;
    }

    public static class Builder{
        public Builder(){

        }

        public QueryCoinsRequest build(){
            return new QueryCoinsRequest(this);
        }
    }
}

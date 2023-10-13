package io.hashnut.model.request;

import io.hashnut.model.response.QueryFiatRateResponse;

import java.util.HashMap;
import java.util.Map;

public class QueryFiatRateRequest extends GetRequest<QueryFiatRateResponse>{
    private final String BASE_URL="/mch/queryFliatExchangeRate";
    private final String baseCoin;
    private final String quoteCoin;
    private final String chainCode;

    public QueryFiatRateRequest(Builder builder) {
        super();
        this.baseCoin=builder.baseCoin;
        this.quoteCoin=builder.quoteCoin;
        this.chainCode=builder.chainCode;
    }

    @Override
    public String getUri() {
        Map<String,String> param=new HashMap<>();
        param.put("baseCoin",baseCoin);
        param.put("quoteCoin",quoteCoin);
        param.put("chainCode",chainCode);

        return appendUriParams(BASE_URL,param);
    }

    @Override
    public Class<QueryFiatRateResponse> getResponseClass() {
        return QueryFiatRateResponse.class;
    }

    public static class Builder{
        private String baseCoin;
        private String quoteCoin;
        private String chainCode;

        public Builder(){

        }

        public Builder(String baseCoin,String quoteCoin,String chainCode){
            this.baseCoin=baseCoin;
            this.quoteCoin=quoteCoin;
            this.chainCode=chainCode;
        }

        public Builder withBaseCoin(String baseCoin){
            this.baseCoin=baseCoin;
            return this;
        }

        public Builder withQuoteCoin(String quoteCoin){
            this.quoteCoin=quoteCoin;
            return this;
        }

        public Builder withChainCode(String chainCode){
            this.chainCode=chainCode;
            return this;
        }

        public QueryFiatRateRequest build(){
            return new QueryFiatRateRequest(this);
        }
    }
}

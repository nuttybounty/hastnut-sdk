package io.hashnut.model.request;

import io.hashnut.model.response.QueryOrderResponse;

public class QueryOrderRequest extends PostRequest<QueryOrderResponse> {
    private final String platformId;
    private final String mchOrderNo;
    private final String accessSign;

    private QueryOrderRequest(Builder builder) {
        this.platformId = builder.platformId;
        this.mchOrderNo = builder.mchOrderNo;
        this.accessSign=builder.accessSign;
    }

    @Override
    public boolean needSign(){return true;}

    @Override
    public String getUri() {
        return "/pay/queryPayOrderWithAccessSign";
    }

    @Override
    public Class<QueryOrderResponse> getResponseClass() {
        return QueryOrderResponse.class;
    }

    public static class Builder {
        private String platformId;
        private String mchOrderNo;
        private String accessSign;

        public Builder(){

        }

        public Builder(String platformId,String mchOrderNo,String accessSign) {
            this.platformId = platformId;
            this.mchOrderNo = mchOrderNo;
            this.accessSign = accessSign;
        }

        public Builder withPlatformId(String platformId) {
            this.platformId = platformId;
            return this;
        }

        public Builder withMchOrderNo(String mchOrderNo) {
            this.mchOrderNo = mchOrderNo;
            return this;
        }

        public Builder withAccessSign(String accessSign) {
            this.accessSign = accessSign;
            return this;
        }

        public QueryOrderRequest build() {
            return new QueryOrderRequest(this);
        }
    }
}

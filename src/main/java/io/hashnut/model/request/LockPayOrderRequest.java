package io.hashnut.model.request;

import io.hashnut.model.response.CreateOrderResponse;
import io.hashnut.model.response.SingleResponse;

public class LockPayOrderRequest extends PostRequest<SingleResponse>{

    private final String platformId;
    private final String mchOrderNo;
    private final String payUUID;
    private final String accessSign;

    public LockPayOrderRequest(Builder builder){
        this.platformId=builder.platformId;
        this.mchOrderNo=builder.mchOrderNo;
        this.payUUID=builder.payUUID;
        this.accessSign=builder.accessSign;
    }

    @Override
    public String getUri() {
        return "/pay/lockPayOrder";
    }

    @Override
    public Class<SingleResponse> getResponseClass() {
        return SingleResponse.class;
    }

    public static class Builder{
        private String platformId;
        private String mchOrderNo;
        private String payUUID;
        private String accessSign;

        public Builder(){

        }

        public Builder(String platformId,String mchOrderNo,String payUUID,String accessSign){
            this.platformId=platformId;
            this.mchOrderNo=mchOrderNo;
            this.payUUID=payUUID;
            this.accessSign=accessSign;
        }

        public Builder withPlatformId(String platformId){
            this.platformId=platformId;
            return this;
        }

        public Builder withMchOrderNo(String mchOrderNo){
            this.mchOrderNo=mchOrderNo;
            return this;
        }

        public Builder withPayUUID(String payUUID){
            this.payUUID=payUUID;
            return this;
        }

        public Builder withAccessSign(String accessSign){
            this.accessSign=accessSign;
            return this;
        }

        public LockPayOrderRequest build(){
            return new LockPayOrderRequest(this);
        }
    }

}

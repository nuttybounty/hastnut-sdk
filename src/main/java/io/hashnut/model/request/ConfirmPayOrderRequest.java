package io.hashnut.model.request;

import io.hashnut.model.response.SingleResponse;

public class ConfirmPayOrderRequest extends PostRequest<SingleResponse>{
    private final String BASE_URL="/pay/confirmPayOrderPaid";
    private final String platformId;
    private final String mchOrderNo;
    private final String accessSign;
    private final String payTxId;
    private final String chainCode;
    private final String payUUID;
    private final int txChannel;

    public ConfirmPayOrderRequest(Builder builder){
        this.platformId=builder.platformId;
        this.mchOrderNo=builder.mchOrderNo;
        this.accessSign =builder.accessSign;
        this.payTxId=builder.payTxId;
        this.chainCode=builder.chainCode;
        this.payUUID=builder.payUUID;
        this.txChannel=builder.txChannel;
    }

    @Override
    public String getUri() {
        return "/pay/confirmPayOrderPaid";
    }

    @Override
    public Class<SingleResponse> getResponseClass() {
        return SingleResponse.class;
    }

    public static class Builder{
        private String platformId;
        private String mchOrderNo;
        private String accessSign;
        private String payTxId;
        private String chainCode;
        private String payUUID;
        private int txChannel;

        public Builder(){

        }

        public Builder(String platformId,String mchOrderNo,String accessSign,String payTxId,String chainCode,String payUUID,int txChannel){
            this.platformId=platformId;
            this.mchOrderNo=mchOrderNo;
            this.accessSign =accessSign;
            this.payTxId=payTxId;
            this.chainCode=chainCode;
            this.payUUID=payUUID;
            this.txChannel=txChannel;
        }

        public Builder withPlatformId(String platformId){
            this.platformId=platformId;
            return this;
        }

        public Builder withMchOrderNo(String mchOrderNo){
            this.mchOrderNo=mchOrderNo;
            return this;
        }

        public Builder withAccessSign(String accessSign){
            this.accessSign =accessSign;
            return this;
        }

        public Builder withPayTxId(String payTxId){
            this.payTxId=payTxId;
            return this;
        }

        public Builder withChainCode(String chainCode){
            this.chainCode=chainCode;
            return this;
        }

        public Builder withPayUUID(String payUUID){
            this.payUUID=payUUID;
            return this;
        }

        public Builder withTxChannel(int txChannel){
            this.txChannel=txChannel;
            return this;
        }

        public ConfirmPayOrderRequest build(){
            return new ConfirmPayOrderRequest(this);
        }
    }
}

package io.hashnut.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hashnut.model.HashNutOrder;
import io.hashnut.model.response.CreateOrderResponse;

public class CreateOrderRequest extends PostRequest<CreateOrderResponse> {
    private String chain;
    private String mchAddress;
    private String accessKeyId;
    private String mchOrderNo;
    private String chainCode;
    private String coinCode;
    private int accessChannel;
    private String amount;
    private int serviceType;
    private String serviceVersion;
    private int serviceId;
    private String receiptContractAddress;
    private String subject;
    private String remark;
    private String param1;
    private String param2;
    private Boolean customCallBackUrl;
    private String extra;

    public String getChain() {
        return chain;
    }

    public String getMchAddress() {
        return mchAddress;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public String getChainCode() {
        return chainCode;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public int getAccessChannel() {
        return accessChannel;
    }

    public String getAmount() {
        return amount;
    }

    public int getServiceType() {
        return serviceType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getReceiptContractAddress() {
        return receiptContractAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getRemark() {
        return remark;
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

    public Boolean getCustomCallBackUrl() {
        return customCallBackUrl;
    }

    public String getExtra() {
        return extra;
    }

    protected CreateOrderRequest(Builder builder) {
        this.chain = builder.chain;
        this.mchAddress = builder.mchAddress;
        this.accessKeyId = builder.accessKeyId;
        this.mchOrderNo = builder.mchOrderNo;
        this.chainCode = builder.chainCode;
        this.coinCode = builder.coinCode;
        this.accessChannel = builder.accessChannel;
        this.amount = builder.amount;
        this.serviceType = builder.serviceType;
        this.serviceVersion = builder.serviceVersion;
        this.serviceId = builder.serviceId;
        this.receiptContractAddress = builder.receiptContractAddress;
        this.subject = builder.subject;
        this.remark = builder.remark;
        this.param1 = builder.param1;
        this.param2 = builder.param2;
        this.customCallBackUrl = builder.customCallBackUrl;
        this.extra = builder.extra;
    }

    @Override
    public boolean needSign(){return true;}

    @Override
    @JsonIgnore
    public String getUri() {
        return "/pay/createPayOrderWithApiKey";
    }

    @Override
    public Class<CreateOrderResponse> getResponseClass() {
        return CreateOrderResponse.class;
    }

    public static class Builder {
        private String chain;
        private String mchAddress;
        private String accessKeyId;
        private String mchOrderNo;
        private String chainCode;
        private String coinCode;
        private int accessChannel;
        private String amount;
        private int serviceType;
        private String serviceVersion;
        private int serviceId;
        private String receiptContractAddress;
        private String subject;
        private String remark;
        private String param1;
        private String param2;
        private Boolean customCallBackUrl;
        private String extra;

        public Builder(){

        }

        public Builder(
                String chain,
                String mchAddress,
                String accessKeyId,
                String mchOrderNo,
                String chainCode,
                String coinCode,
                int accessChannel,
                String amount,
                int serviceType,
                String serviceVersion,
                int serviceId,
                String receiptContractAddress,
                String subject,
                String remark,
                String param1,
                String param2,
                Boolean customCallBackUrl,
                String extra) {
            this.chain = chain;
            this.mchAddress = mchAddress;
            this.accessKeyId = accessKeyId;
            this.mchOrderNo = mchOrderNo;
            this.chainCode = chainCode;
            this.coinCode = coinCode;
            this.accessChannel = accessChannel;
            this.amount = amount;
            this.serviceType = serviceType;
            this.serviceVersion = serviceVersion;
            this.serviceId = serviceId;
            this.receiptContractAddress = receiptContractAddress;
            this.subject = subject;
            this.remark = remark;
            this.param1 = param1;
            this.param2 = param2;
            this.customCallBackUrl = customCallBackUrl;
            this.extra = extra;
        }

        public Builder withChain(String chain) {
            this.chain = chain;
            return this;
        }

        public Builder withMchAddress(String mchAddress) {
            this.mchAddress = mchAddress;
            return this;
        }

        public Builder withAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public Builder withMchOrderNo(String mchOrderNo) {
            this.mchOrderNo = mchOrderNo;
            return this;
        }

        public Builder withChainCode(String chainCode) {
            this.chainCode = chainCode;
            return this;
        }

        public Builder withCoinCode(String coinCode) {
            this.coinCode = coinCode;
            return this;
        }

        public Builder withAccessChannel(int accessChannel) {
            this.accessChannel = accessChannel;
            return this;
        }

        public Builder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder withServiceType(int serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        public Builder withServiceVersion(String serviceVersion) {
            this.serviceVersion = serviceVersion;
            return this;
        }

        public Builder withServiceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder withReceiptContractAddress(String receiptContractAddress) {
            this.receiptContractAddress = receiptContractAddress;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder withRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public Builder withParam1(String param1) {
            this.param1 = param1;
            return this;
        }

        public Builder withParam2(String param2) {
            this.param2 = param2;
            return this;
        }

        public Builder withCustomCallBackUrl(Boolean customCallBackUrl) {
            this.customCallBackUrl = customCallBackUrl;
            return this;
        }

        public Builder withExtra(String extra) {
            this.extra = extra;
            return this;
        }

        public CreateOrderRequest build() {
            return new CreateOrderRequest(this);
        }
    }
}

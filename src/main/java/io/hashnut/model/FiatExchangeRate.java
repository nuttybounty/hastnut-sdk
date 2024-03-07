package io.hashnut.model;

import java.io.Serializable;
import java.util.Date;

public class FiatExchangeRate implements Serializable {
    private String baseCoin;
    private String quoteCoin;
    private String chainCode;
    private Float rate;
    private Date createTime;
    private Date updateTime;

    public FiatExchangeRate() {
    }

    public String getBaseCoin() {
        return this.baseCoin;
    }

    public void setBaseCoin(String baseCoin) {
        this.baseCoin = baseCoin;
    }

    public String getQuoteCoin() {
        return this.quoteCoin;
    }

    public void setQuoteCoin(String quoteCoin) {
        this.quoteCoin = quoteCoin;
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public Float getRate() {
        return this.rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}


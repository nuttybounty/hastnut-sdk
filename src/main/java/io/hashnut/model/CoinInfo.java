package io.hashnut.model;

import java.math.BigInteger;
import java.util.Date;

public class CoinInfo {
    private String coinCode;
    private String chainCode;
    private String contractAddr;
    private String coinDesc;
    private Date createTime;
    private Date updateTime;
    private Boolean isToken;
    private Boolean enable;
    private Boolean chainEnable;
    private Boolean l2Enable;
    private Boolean gateWayEnable;
    private Integer decimals;
    private byte[] maxWithDrawAmount;
    private byte[] minWithDrawAmount;
    private byte[] minObtainAmount;
    private static final long serialVersionUID = 1L;

    public CoinInfo() {
    }

    public String getCoinCode() {
        return this.coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getContractAddr() {
        return this.contractAddr;
    }

    public void setContractAddr(String contractAddr) {
        this.contractAddr = contractAddr;
    }

    public String getCoinDesc() {
        return this.coinDesc;
    }

    public void setCoinDesc(String coinDesc) {
        this.coinDesc = coinDesc;
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

    public Boolean getIsToken() {
        return this.isToken;
    }

    public void setIsToken(Boolean isToken) {
        this.isToken = isToken;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getChainEnable() {
        return this.chainEnable;
    }

    public void setChainEnable(Boolean chainEnable) {
        this.chainEnable = chainEnable;
    }

    public Boolean getL2Enable() {
        return this.l2Enable;
    }

    public void setL2Enable(Boolean l2Enable) {
        this.l2Enable = l2Enable;
    }

    public Boolean getGateWayEnable() {
        return this.gateWayEnable;
    }

    public void setGateWayEnable(Boolean gateWayEnable) {
        this.gateWayEnable = gateWayEnable;
    }

    public Integer getDecimals() {
        return this.decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public BigInteger getMaxWithDrawAmount() {
        return this.maxWithDrawAmount != null && this.maxWithDrawAmount.length != 0 ? new BigInteger(this.maxWithDrawAmount) : null;
    }

    public void setMaxWithDrawAmount(BigInteger maxWithDrawAmount) {
        this.maxWithDrawAmount = maxWithDrawAmount.toByteArray();
    }

    public BigInteger getMinWithDrawAmount() {
        return this.minWithDrawAmount != null && this.minWithDrawAmount.length != 0 ? new BigInteger(this.minWithDrawAmount) : null;
    }

    public void setMinWithDrawAmount(BigInteger minWithDrawAmount) {
        this.minWithDrawAmount = minWithDrawAmount.toByteArray();
    }

    public BigInteger getMinObtainAmount() {
        return this.minObtainAmount != null && this.minObtainAmount.length != 0 ? new BigInteger(this.minObtainAmount) : null;
    }

    public void setMinObtainAmount(BigInteger minObtainAmount) {
        this.minObtainAmount = minObtainAmount.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", coinCode=").append(this.coinCode);
        sb.append(", chainCode=").append(this.chainCode);
        sb.append(", contractAddr=").append(this.contractAddr);
        sb.append(", coinDesc=").append(this.coinDesc);
        sb.append(", createTime=").append(this.createTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", isToken=").append(this.isToken);
        sb.append(", enable=").append(this.enable);
        sb.append(", chainEnable=").append(this.chainEnable);
        sb.append(", l2Enable=").append(this.l2Enable);
        sb.append(", gateWayEnable=").append(this.gateWayEnable);
        sb.append(", decimals=").append(this.decimals);
        sb.append(", maxWithDrawAmount=").append(this.getMaxWithDrawAmount());
        sb.append(", minWithDrawAmount=").append(this.getMinWithDrawAmount());
        sb.append(", minObtainAmount=").append(this.getMinObtainAmount());
        sb.append("]");
        return sb.toString();
    }
}
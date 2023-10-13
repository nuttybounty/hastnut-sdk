package io.hashnut.model;

import java.util.Date;

public class ChainInfo {
    private String chainCode;
    private String chainDesc;
    private Date createTime;
    private Date updateTime;
    private Boolean enable;
    private String receiptAddress;
    private Long txConfirmCount;
    private Boolean walletConnectEnable;
    private String bridgeServerAddress;
    private String baseChainSymbol;
    private Integer decimals;
    private Byte env;
    private Long EIP712ChainId;
    private static final long serialVersionUID = 1L;

    public ChainInfo() {
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getChainDesc() {
        return this.chainDesc;
    }

    public void setChainDesc(String chainDesc) {
        this.chainDesc = chainDesc;
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

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getReceiptAddress() {
        return this.receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public Long getTxConfirmCount() {
        return this.txConfirmCount;
    }

    public void setTxConfirmCount(Long txConfirmCount) {
        this.txConfirmCount = txConfirmCount;
    }

    public Boolean getWalletConnectEnable() {
        return this.walletConnectEnable;
    }

    public void setWalletConnectEnable(Boolean walletConnectEnable) {
        this.walletConnectEnable = walletConnectEnable;
    }

    public String getBridgeServerAddress() {
        return this.bridgeServerAddress;
    }

    public void setBridgeServerAddress(String bridgeServerAddress) {
        this.bridgeServerAddress = bridgeServerAddress;
    }

    public String getBaseChainSymbol() {
        return this.baseChainSymbol;
    }

    public void setBaseChainSymbol(String baseChainSymbol) {
        this.baseChainSymbol = baseChainSymbol;
    }

    public Integer getDecimals() {
        return this.decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public Byte getEnv() {
        return this.env;
    }

    public void setEnv(Byte env) {
        this.env = env;
    }

    public Long getEIP712ChainId() {
        return this.EIP712ChainId;
    }

    public void setEIP712ChainId(Long EIP712ChainId) {
        this.EIP712ChainId = EIP712ChainId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", chainCode=").append(this.chainCode);
        sb.append(", chainDesc=").append(this.chainDesc);
        sb.append(", createTime=").append(this.createTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", enable=").append(this.enable);
        sb.append(", receiptAddress=").append(this.receiptAddress);
        sb.append(", txConfirmCount=").append(this.txConfirmCount);
        sb.append(", walletConnectEnable=").append(this.walletConnectEnable);
        sb.append(", bridgeServerAddress=").append(this.bridgeServerAddress);
        sb.append(", baseChainSymbol=").append(this.baseChainSymbol);
        sb.append(", decimals=").append(this.decimals);
        sb.append(", env=").append(this.env);
        sb.append(", EIP712ChainId=").append(this.EIP712ChainId);
        sb.append("]");
        return sb.toString();
    }
}


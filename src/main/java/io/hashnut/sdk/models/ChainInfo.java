package io.hashnut.sdk.models;


import java.io.Serializable;
import java.util.Date;

public class ChainInfo implements Serializable {
    private String chainCode;
    private String chainDesc;
    private Date createTime;
    private Date updateTime;
    private Boolean enable;
//    private String wssBindIp;
//    private String wssBindPort;
//    private String rpcUrl;
//    private String wssUrl;
    private String receiptAddress;
    private Long txConfirmCount;
    private Boolean walletConnectEnable;
    private String bridgeServerAddress;
    private String baseChainSymbol;
    private Integer decimals;
    private Byte env;
    private Long EIP712ChainId;
    private static final long serialVersionUID = 1L;
    public String getChainCode() {
        return chainCode;
    }
    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }
    public String getChainDesc() {
        return chainDesc;
    }
    public void setChainDesc(String chainDesc) {
        this.chainDesc = chainDesc;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Boolean getEnable() {
        return enable;
    }
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
//    public String getWssBindIp() {
//        return wssBindIp;
//    }
//    public void setWssBindIp(String wssBindIp) {
//        this.wssBindIp = wssBindIp;
//    }
//    public String getWssBindPort() {
//        return wssBindPort;
//    }
//    public void setWssBindPort(String wssBindPort) {
//        this.wssBindPort = wssBindPort;
//    }
//    public String getRpcUrl() {
//        return rpcUrl;
//    }
//    public void setRpcUrl(String rpcUrl) {
//        this.rpcUrl = rpcUrl;
//    }
//    public String getWssUrl() {
//        return wssUrl;
//    }
//    public void setWssUrl(String wssUrl) {
//        this.wssUrl = wssUrl;
//    }
    public String getReceiptAddress() {
        return receiptAddress;
    }
    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }
    public Long getTxConfirmCount() {
        return txConfirmCount;
    }
    public void setTxConfirmCount(Long txConfirmCount) {
        this.txConfirmCount = txConfirmCount;
    }
    public Boolean getWalletConnectEnable() {
        return walletConnectEnable;
    }
    public void setWalletConnectEnable(Boolean walletConnectEnable) {
        this.walletConnectEnable = walletConnectEnable;
    }
    public String getBridgeServerAddress() {
        return bridgeServerAddress;
    }
    public void setBridgeServerAddress(String bridgeServerAddress) {
        this.bridgeServerAddress = bridgeServerAddress;
    }
    public String getBaseChainSymbol() {
        return baseChainSymbol;
    }
    public void setBaseChainSymbol(String baseChainSymbol) {
        this.baseChainSymbol = baseChainSymbol;
    }
    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }
    public Byte getEnv() {
        return env;
    }
    public void setEnv(Byte env) {
        this.env = env;
    }
    public Long getEIP712ChainId() {
        return EIP712ChainId;
    }
    public void setEIP712ChainId(Long EIP712ChainId) {
        this.EIP712ChainId = EIP712ChainId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chainCode=").append(chainCode);
        sb.append(", chainDesc=").append(chainDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", enable=").append(enable);
        sb.append(", receiptAddress=").append(receiptAddress);
        sb.append(", txConfirmCount=").append(txConfirmCount);
        sb.append(", walletConnectEnable=").append(walletConnectEnable);
        sb.append(", bridgeServerAddress=").append(bridgeServerAddress);
        sb.append(", baseChainSymbol=").append(baseChainSymbol);
        sb.append(", decimals=").append(decimals);
        sb.append(", env=").append(env);
        sb.append(", EIP712ChainId=").append(EIP712ChainId);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChainInfo other = (ChainInfo) that;
        return (this.getChainCode() == null ? other.getChainCode() == null : this.getChainCode().equals(other.getChainCode()))
                && (this.getChainDesc() == null ? other.getChainDesc() == null : this.getChainDesc().equals(other.getChainDesc()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
                && (this.getReceiptAddress() == null ? other.getReceiptAddress() == null : this.getReceiptAddress().equals(other.getReceiptAddress()))
                && (this.getTxConfirmCount() == null ? other.getTxConfirmCount() == null : this.getTxConfirmCount().equals(other.getTxConfirmCount()))
                && (this.getWalletConnectEnable() == null ? other.getWalletConnectEnable() == null : this.getWalletConnectEnable().equals(other.getWalletConnectEnable()))
                && (this.getBridgeServerAddress() == null ? other.getBridgeServerAddress() == null : this.getBridgeServerAddress().equals(other.getBridgeServerAddress()))
                && (this.getBaseChainSymbol() == null ? other.getBaseChainSymbol() == null : this.getBaseChainSymbol().equals(other.getBaseChainSymbol()))
                && (this.getDecimals() == null ? other.getDecimals() == null : this.getDecimals().equals(other.getDecimals()))
                && (this.getEnv() == null ? other.getEnv() == null : this.getEnv().equals(other.getEnv()))
                && (this.getEIP712ChainId() == null ? other.getEIP712ChainId() == null : this.getEIP712ChainId().equals(other.getEIP712ChainId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChainCode() == null) ? 0 : getChainCode().hashCode());
        result = prime * result + ((getChainDesc() == null) ? 0 : getChainDesc().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getReceiptAddress() == null) ? 0 : getReceiptAddress().hashCode());
        result = prime * result + ((getTxConfirmCount() == null) ? 0 : getTxConfirmCount().hashCode());
        result = prime * result + ((getWalletConnectEnable() == null) ? 0 : getWalletConnectEnable().hashCode());
        result = prime * result + ((getBridgeServerAddress() == null) ? 0 : getBridgeServerAddress().hashCode());
        result = prime * result + ((getBaseChainSymbol() == null) ? 0 : getBaseChainSymbol().hashCode());
        result = prime * result + ((getDecimals() == null) ? 0 : getDecimals().hashCode());
        result = prime * result + ((getEnv() == null) ? 0 : getEnv().hashCode());
        result = prime * result + ((getEIP712ChainId() == null) ? 0 : getEIP712ChainId().hashCode());
        return result;
    }
}
package io.hashnut.model;

public class HashNutOrder {
    private String mchAddress;
    private String chain;
    private String chainCode;
    private String coinCode;
    private int createChannel;
    private int accessChannel;
    private String mchOrderId;
    private String platformId;
    private String contractAddress;
    private String receiptAddress;
    private long amount;
    private int state;
    private String accessSign;
    private int confirmCount;
    private int genNftState;
    private int genNftConfirmCount;
    private int mintNftState;
    private int mintNftConfirmCount;
    private boolean walletConnectEnable;
    private String bridgeServerAddress;
    private int eip712ChainId;
    private int chainId;
    private long createTime;
    private long expireDuration;

    public String getMchAddress() {
        return mchAddress;
    }

    public String getChain() {
        return chain;
    }

    public String getChainCode() {
        return chainCode;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public int getCreateChannel() {
        return createChannel;
    }

    public int getAccessChannel() {
        return accessChannel;
    }

    public String getMchOrderId() {
        return mchOrderId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public long getAmount() {
        return amount;
    }

    public int getState() {
        return state;
    }

    public String getAccessSign() {
        return accessSign;
    }

    public int getConfirmCount() {
        return confirmCount;
    }

    public int getGenNftState() {
        return genNftState;
    }

    public int getGenNftConfirmCount() {
        return genNftConfirmCount;
    }

    public int getMintNftState() {
        return mintNftState;
    }

    public int getMintNftConfirmCount() {
        return mintNftConfirmCount;
    }

    public boolean isWalletConnectEnable() {
        return walletConnectEnable;
    }

    public String getBridgeServerAddress() {
        return bridgeServerAddress;
    }

    public int getEip712ChainId() {
        return eip712ChainId;
    }

    public int getChainId() {
        return chainId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getExpireDuration() {
        return expireDuration;
    }

    // Getters and setters for all the fields

    @Override
    public String toString() {
        return "HashNutOrder{" +
                "mchAddress='" + mchAddress + '\'' +
                ", chain='" + chain + '\'' +
                ", chainCode='" + chainCode + '\'' +
                ", coinCode='" + coinCode + '\'' +
                ", createChannel=" + createChannel +
                ", accessChannel=" + accessChannel +
                ", mchOrderId='" + mchOrderId + '\'' +
                ", platformId='" + platformId + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", receiptAddress='" + receiptAddress + '\'' +
                ", amount=" + amount +
                ", state=" + state +
                ", accessSign='" + accessSign + '\'' +
                ", confirmCount=" + confirmCount +
                ", genNftState=" + genNftState +
                ", genNftConfirmCount=" + genNftConfirmCount +
                ", mintNftState=" + mintNftState +
                ", mintNftConfirmCount=" + mintNftConfirmCount +
                ", walletConnectEnable=" + walletConnectEnable +
                ", bridgeServerAddress='" + bridgeServerAddress + '\'' +
                ", eip712ChainId=" + eip712ChainId +
                ", chainId=" + chainId +
                ", createTime=" + createTime +
                ", expireDuration=" + expireDuration +
                '}';
    }
}


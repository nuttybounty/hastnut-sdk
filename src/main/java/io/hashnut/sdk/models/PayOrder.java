package io.hashnut.sdk.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class PayOrder implements Serializable {

    // platform id
    private String payOrderId;
    private String chain;
    private String mchAddress;
    private String mchOrderNo;
    private String chainCode;
    private String coinCode;
    private Byte createChannel;
    private Byte accessChannel;
    private String payTxId;
    private String accessKeyId;
    private Long confirmCount;
    private Byte state;
    private String subject;
    private String remarkInfo;
    private String extra;
    private String param1;
    private String param2;
    private Byte notifyCount;
    private Long expireTime;
    private String inputData;
    private String accessSign;
    private String version;
    private Long payTxHeight;
    private String payAddress;
    private String receiptAddress;
    private Byte nftPayType;
    private Byte payType;
    private String orderUUID;
    private String fiat;
    private String channelErrCode;
    private String channelErrMsg;
    private Long confirmPayTime;
    private Long lastNotifyTime;
    private Long finishTime;
    private Long paySuccTime;
    private Date createTime;
    private Date updateTime;
    private byte[] amount;
    private byte[] obtainAmount;
    private byte[] gasLimit;
    private byte[] gasPrice;
    private byte[] fee;
    private boolean customCallBackUrl;
    private static final long serialVersionUID = 1L;
    public String getPayOrderId() {
        return payOrderId;
    }
    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }
    public String getChain() {
        return chain;
    }
    public void setChain(String chain) {
        this.chain = chain;
    }
    public String getMchAddress() {
        return mchAddress;
    }
    public void setMchAddress(String mchAddress) {
        this.mchAddress = mchAddress;
    }
    public String getMchOrderNo() {
        return mchOrderNo;
    }
    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
    }
    public String getChainCode() {
        return chainCode;
    }
    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }
    public String getCoinCode() {
        return coinCode;
    }
    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }
    public Byte getCreateChannel() {
        return createChannel;
    }
    public void setCreateChannel(Byte createChannel) {
        this.createChannel = createChannel;
    }
    public Byte getAccessChannel() {
        return accessChannel;
    }
    public void setAccessChannel(Byte accessChannel) {
        this.accessChannel = accessChannel;
    }
    public String getPayTxId() {
        return payTxId;
    }
    public void setPayTxId(String payTxId) {
        this.payTxId = payTxId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }
    public Long getConfirmCount() {
        return confirmCount;
    }
    public void setConfirmCount(Long confirmCount) {
        this.confirmCount = confirmCount;
    }
    public Byte getState() {
        return state;
    }
    public void setState(Byte state) {
        this.state = state;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getRemarkInfo() {
        return remarkInfo;
    }
    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo;
    }
    public String getExtra() {
        return extra;
    }
    public void setExtra(String extra) {
        this.extra = extra;
    }
    public String getParam1() {
        return param1;
    }
    public void setParam1(String param1) {
        this.param1 = param1;
    }
    public String getParam2() {
        return param2;
    }
    public void setParam2(String param2) {
        this.param2 = param2;
    }
    public Byte getNotifyCount() {
        return notifyCount;
    }
    public void setNotifyCount(Byte notifyCount) {
        this.notifyCount = notifyCount;
    }
    public Long getExpireTime() {
        return expireTime;
    }
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
    public String getInputData() {
        return inputData;
    }
    public void setInputData(String inputData) {
        this.inputData = inputData;
    }
    public String getAccessSign() {
        return accessSign;
    }
    public void setAccessSign(String accessSign) {
        this.accessSign = accessSign;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public Long getPayTxHeight() {
        return payTxHeight;
    }
    public void setPayTxHeight(Long payTxHeight) {
        this.payTxHeight = payTxHeight;
    }
    public String getPayAddress() {
        return payAddress;
    }
    public void setPayAddress(String payAddress) {
        this.payAddress = payAddress;
    }
    public String getReceiptAddress() {
        return receiptAddress;
    }
    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }
    public Byte getNftPayType() {
        return nftPayType;
    }
    public void setNftPayType(Byte nftPayType) {
        this.nftPayType = nftPayType;
    }
    public Byte getPayType() {
        return payType;
    }
    public void setPayType(Byte payType) {
        this.payType = payType;
    }
    public String getOrderUUID() {
        return orderUUID;
    }
    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }
    public String getFiat() {
        return fiat;
    }
    public void setFiat(String fiat) {
        this.fiat = fiat;
    }
    public String getChannelErrCode() {
        return channelErrCode;
    }
    public void setChannelErrCode(String channelErrCode) {
        this.channelErrCode = channelErrCode;
    }
    public String getChannelErrMsg() {
        return channelErrMsg;
    }
    public void setChannelErrMsg(String channelErrMsg) {
        this.channelErrMsg = channelErrMsg;
    }
    public Long getConfirmPayTime() {
        return confirmPayTime;
    }
    public void setConfirmPayTime(Long confirmPayTime) {
        this.confirmPayTime = confirmPayTime;
    }
    public Long getLastNotifyTime() {
        return lastNotifyTime;
    }
    public void setLastNotifyTime(Long lastNotifyTime) {
        this.lastNotifyTime = lastNotifyTime;
    }
    public Long getFinishTime() {
        return finishTime;
    }
    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }
    public Long getPaySuccTime() {
        return paySuccTime;
    }
    public void setPaySuccTime(Long paySuccTime) {
        this.paySuccTime = paySuccTime;
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
    public BigInteger getGasLimit(){
        if(gasLimit==null || gasLimit.length==0)
            return BigInteger.ZERO;
        return new BigInteger(gasLimit);
    }
    public void setGasLimit(BigInteger gasLimit){
        this.gasLimit=gasLimit.toByteArray();
    }
    public BigInteger getGasPrice(){
        if(gasPrice==null || gasPrice.length==0)
            return BigInteger.ZERO;
        return new BigInteger(gasPrice);
    }
    public void setGasPrice(BigInteger gasPrice){
        this.gasPrice=gasPrice.toByteArray();
    }

    public BigInteger getFee(){
        if(fee==null || fee.length==0)
            return BigInteger.ZERO;
        return new BigInteger(fee);
    }

    public void setFee(BigInteger fee){
        this.fee=fee.toByteArray();
    }

    public BigInteger getAmount(){
        if(amount==null || amount.length==0)
            return BigInteger.ZERO;
        return new BigInteger(amount);
    }

    public void setAmount(BigInteger amount){
        this.amount=amount.toByteArray();
    }

    public BigInteger getObtainAmount(){
        if(obtainAmount==null || obtainAmount.length==0)
            return BigInteger.ZERO;
        return new BigInteger(obtainAmount);
    }

    public void setObtainAmount(BigInteger obtainAmount){
        this.obtainAmount=obtainAmount.toByteArray();
    }

    public boolean isCustomCallBackUrl() {
        return customCallBackUrl;
    }

    public void setCustomCallBackUrl(boolean customCallBackUrl) {
        this.customCallBackUrl = customCallBackUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", payOrderId=").append(payOrderId);
        sb.append(", chain=").append(chain);
        sb.append(", mchAddress=").append(mchAddress);
        sb.append(", mchOrderNo=").append(mchOrderNo);
        sb.append(", chainCode=").append(chainCode);
        sb.append(", coinCode=").append(coinCode);
        sb.append(", createChannel=").append(createChannel);
        sb.append(", accessChannel=").append(accessChannel);
        sb.append(", payTxId=").append(payTxId);
        sb.append(", accessKeyId=").append(accessKeyId);
        sb.append(", confirmCount=").append(confirmCount);
        sb.append(", state=").append(state);
        sb.append(", subject=").append(subject);
        sb.append(", remarkInfo=").append(remarkInfo);
        sb.append(", extra=").append(extra);
        sb.append(", param1=").append(param1);
        sb.append(", param2=").append(param2);
        sb.append(", notifyCount=").append(notifyCount);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", inputData=").append(inputData);
        sb.append(", accessSign=").append(accessSign);
        sb.append(", version=").append(version);
        sb.append(", payTxHeight=").append(payTxHeight);
        sb.append(", payAddress=").append(payAddress);
        sb.append(", receiptAddress=").append(receiptAddress);
        sb.append(", nftPayType=").append(nftPayType);
        sb.append(", payType=").append(payType);
        sb.append(", orderUUID=").append(orderUUID);
        sb.append(", fiat=").append(fiat);
        sb.append(", channelErrCode=").append(channelErrCode);
        sb.append(", channelErrMsg=").append(channelErrMsg);
        sb.append(", confirmPayTime=").append(confirmPayTime);
        sb.append(", lastNotifyTime=").append(lastNotifyTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", paySuccTime=").append(paySuccTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", amount=").append(getAmount());
        sb.append(", obtainAmount=").append(getObtainAmount());
        sb.append(", gasLimit=").append(getGasLimit());
        sb.append(", gasPrice=").append(getGasPrice());
        sb.append(", fee=").append(getFee());
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
        PayOrder other = (PayOrder) that;
        return (this.getPayOrderId() == null ? other.getPayOrderId() == null : this.getPayOrderId().equals(other.getPayOrderId()))
                && (this.getChain() == null ? other.getChain() == null : this.getChain().equals(other.getChain()))
                && (this.getMchAddress() == null ? other.getMchAddress() == null : this.getMchAddress().equals(other.getMchAddress()))
                && (this.getMchOrderNo() == null ? other.getMchOrderNo() == null : this.getMchOrderNo().equals(other.getMchOrderNo()))
                && (this.getChainCode() == null ? other.getChainCode() == null : this.getChainCode().equals(other.getChainCode()))
                && (this.getCoinCode() == null ? other.getCoinCode() == null : this.getCoinCode().equals(other.getCoinCode()))
                && (this.getCreateChannel() == null ? other.getCreateChannel() == null : this.getCreateChannel().equals(other.getCreateChannel()))
                && (this.getAccessChannel() == null ? other.getAccessChannel() == null : this.getAccessChannel().equals(other.getAccessChannel()))
                && (this.getPayTxId() == null ? other.getPayTxId() == null : this.getPayTxId().equals(other.getPayTxId()))
                && (this.getAccessKeyId() == null ? other.getAccessKeyId() == null : this.getAccessKeyId().equals(other.getAccessKeyId()))
                && (this.getConfirmCount() == null ? other.getConfirmCount() == null : this.getConfirmCount().equals(other.getConfirmCount()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
                && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
                && (this.getRemarkInfo() == null ? other.getRemarkInfo() == null : this.getRemarkInfo().equals(other.getRemarkInfo()))
                && (this.getExtra() == null ? other.getExtra() == null : this.getExtra().equals(other.getExtra()))
                && (this.getParam1() == null ? other.getParam1() == null : this.getParam1().equals(other.getParam1()))
                && (this.getParam2() == null ? other.getParam2() == null : this.getParam2().equals(other.getParam2()))
                && (this.getNotifyCount() == null ? other.getNotifyCount() == null : this.getNotifyCount().equals(other.getNotifyCount()))
                && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()))
                && (this.getInputData() == null ? other.getInputData() == null : this.getInputData().equals(other.getInputData()))
                && (this.getAccessSign() == null ? other.getAccessSign() == null : this.getAccessSign().equals(other.getAccessSign()))
                && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
                && (this.getPayTxHeight() == null ? other.getPayTxHeight() == null : this.getPayTxHeight().equals(other.getPayTxHeight()))
                && (this.getPayAddress() == null ? other.getPayAddress() == null : this.getPayAddress().equals(other.getPayAddress()))
                && (this.getReceiptAddress() == null ? other.getReceiptAddress() == null : this.getReceiptAddress().equals(other.getReceiptAddress()))
                && (this.getNftPayType() == null ? other.getNftPayType() == null : this.getNftPayType().equals(other.getNftPayType()))
                && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
                && (this.getOrderUUID() == null ? other.getOrderUUID() == null : this.getOrderUUID().equals(other.getOrderUUID()))
                && (this.getFiat() == null ? other.getFiat() == null : this.getFiat().equals(other.getFiat()))
                && (this.getChannelErrCode() == null ? other.getChannelErrCode() == null : this.getChannelErrCode().equals(other.getChannelErrCode()))
                && (this.getChannelErrMsg() == null ? other.getChannelErrMsg() == null : this.getChannelErrMsg().equals(other.getChannelErrMsg()))
                && (this.getConfirmPayTime() == null ? other.getConfirmPayTime() == null : this.getConfirmPayTime().equals(other.getConfirmPayTime()))
                && (this.getLastNotifyTime() == null ? other.getLastNotifyTime() == null : this.getLastNotifyTime().equals(other.getLastNotifyTime()))
                && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
                && (this.getPaySuccTime() == null ? other.getPaySuccTime() == null : this.getPaySuccTime().equals(other.getPaySuccTime()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
                && (this.getObtainAmount() == null ? other.getObtainAmount() == null : this.getObtainAmount().equals(other.getObtainAmount()))
                && (this.getGasLimit() == null ? other.getGasLimit() == null : this.getGasLimit().equals(other.getGasLimit()))
                && (this.getGasPrice() == null ? other.getGasPrice() == null : this.getGasPrice().equals(other.getGasPrice()))
                && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPayOrderId() == null) ? 0 : getPayOrderId().hashCode());
        result = prime * result + ((getChain() == null) ? 0 : getChain().hashCode());
        result = prime * result + ((getMchAddress() == null) ? 0 : getMchAddress().hashCode());
        result = prime * result + ((getMchOrderNo() == null) ? 0 : getMchOrderNo().hashCode());
        result = prime * result + ((getChainCode() == null) ? 0 : getChainCode().hashCode());
        result = prime * result + ((getCoinCode() == null) ? 0 : getCoinCode().hashCode());
        result = prime * result + ((getCreateChannel() == null) ? 0 : getCreateChannel().hashCode());
        result = prime * result + ((getAccessChannel() == null) ? 0 : getAccessChannel().hashCode());
        result = prime * result + ((getPayTxId() == null) ? 0 : getPayTxId().hashCode());
        result = prime * result + ((getAccessKeyId() == null) ? 0 : getAccessKeyId().hashCode());
        result = prime * result + ((getConfirmCount() == null) ? 0 : getConfirmCount().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getRemarkInfo() == null) ? 0 : getRemarkInfo().hashCode());
        result = prime * result + ((getExtra() == null) ? 0 : getExtra().hashCode());
        result = prime * result + ((getParam1() == null) ? 0 : getParam1().hashCode());
        result = prime * result + ((getParam2() == null) ? 0 : getParam2().hashCode());
        result = prime * result + ((getNotifyCount() == null) ? 0 : getNotifyCount().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        result = prime * result + ((getInputData() == null) ? 0 : getInputData().hashCode());
        result = prime * result + ((getAccessSign() == null) ? 0 : getAccessSign().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getPayTxHeight() == null) ? 0 : getPayTxHeight().hashCode());
        result = prime * result + ((getPayAddress() == null) ? 0 : getPayAddress().hashCode());
        result = prime * result + ((getReceiptAddress() == null) ? 0 : getReceiptAddress().hashCode());
        result = prime * result + ((getNftPayType() == null) ? 0 : getNftPayType().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getOrderUUID() == null) ? 0 : getOrderUUID().hashCode());
        result = prime * result + ((getFiat() == null) ? 0 : getFiat().hashCode());
        result = prime * result + ((getChannelErrCode() == null) ? 0 : getChannelErrCode().hashCode());
        result = prime * result + ((getChannelErrMsg() == null) ? 0 : getChannelErrMsg().hashCode());
        result = prime * result + ((getConfirmPayTime() == null) ? 0 : getConfirmPayTime().hashCode());
        result = prime * result + ((getLastNotifyTime() == null) ? 0 : getLastNotifyTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getPaySuccTime() == null) ? 0 : getPaySuccTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getObtainAmount() == null) ? 0 : getObtainAmount().hashCode());
        result = prime * result + ((getGasLimit() == null) ? 0 : getGasLimit().hashCode());
        result = prime * result + ((getGasPrice() == null) ? 0 : getGasPrice().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        return result;
    }
}
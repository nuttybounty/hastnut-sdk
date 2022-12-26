package io.hashnut.sdk.models;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Order {
    private static final long serialVersionUID = 1L;
    // kampay的平台订单号
    private String orderId;
    // 商户ID
    private String mchId;
    // 商户订单号
    private String mchOrderNo;
    // 链代号
    private String chainCode;
    // 币种代号
    private String coinCode;
    // 支付该订单的交易Id(实际长度可能小于128)
    private String payTxId;
    // 生成该订单时使用到的accessKeyId
    private String accessKeyId;
    // 支付该订单所需要的金额
    private BigInteger amount;
    // 商户实际能收到的金额"
    private BigInteger obtainAmount;
    // 支付该订单所需要的gasLimit
    private BigInteger gasLimit;
    // 支付该订单所需要的gasPrice
    private BigInteger gasPrice;
    // 支付该订单所需要的手续费
    private BigInteger fee;
    // 支付该订单的交易被确认的次数
    private BigInteger confirmCount;
    // 支付状态,0-待付款,1-待确认,2-待区块链确认,3-已经付款,-1-业务失败
    private Byte state;
    // 客户端IP
    private String clientIp;
    // 设备 (WAP,WEB,APP)
    private String device;
    // 商品标题
    private String subject;
    // 备注信息
    private String remarkInfo;
    // 链支付错误码
    private String channelErrCode;
    // 链支付错误描述
    private String channelErrMsg;
    // 特定渠道发起时额外参数
    private String extra;
    // 扩展参数1
    private String param1;
    // 扩展参数2
    private String param2;
    // 通知商户的次数
    private Byte notifyCount;
    // 通知商户的次数
    private Long lastNotifyTime;
    // 订单超时时间
    private Long expireTime;
    // 通知商户的次数
    private Long paySuccTime;
    // 创建时间",example = "2018-10-01 12:18:48"
    private Date createTime;
    // 更新时间",example = "2018-10-01 12:18:48"
    private Date updateTime;
}
package io.hashnut.sdk.models;

import lombok.Data;

@Data
public class OrderOutputParam {
    //商户Id
    public String mchId;
    //链代号，创建订单时时不返回该值
    public String chainCode;
    //币种代码
    public String coinCode;
    //商户订单号
    public String mchOrderId;
    //平台订单号
    public String platformId;
    //erc20的usdt合约地址
    public String erc20UsdtAddr;
    //trc20的usdt合约地址
    public String trc20UsdtAddr;
    //erc20收币地址
    public String erc20ReceiptAddr;
    //trc20收币地址
    public String trc20ReceiptAddr;
    //前端发送交易时要输入的input data，主要用于发送 erc20/trc20 token
    public String inputData;
    //生成订单时，给前端无需登录态的签名
    public String accessSign;
}

package io.hashnut.sdk.apis;

import io.hashnut.sdk.config.PayConstant;
import io.hashnut.sdk.exception.OrderException;
import io.hashnut.sdk.models.OrderOutputParam;
import io.hashnut.sdk.models.PayOrder;
import io.hashnut.sdk.util.OrderUtil;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.UUID;

public class TronOrderUtilTest {
    public static final int SERVICE_TYPE=0;
    public static final String SERVICE_VERSION="PaymentSplitterV2_1";
    public static final int SERVICE_ID=2;
    public static String MCH_ADDRESS ="TDFChZcLGd5yWT8dqvjdeCkbQRboyBxL27";
    public static String ACCESS_KEY_ID="ACC_1056926725960630272";
    public static String REQUEST_KEY="KIB17VDKhmVeYwNNnYQVIV8bLYAXaAgg";
    public static String RESPONSE_KEY="6Po8ExW6CgVKSaAAbStxJxYfnMrGBrff";
    public static String RECEIPT_CONTRACT_ADDRESS="TJxyba9jmJDpgY97gDs9syaY6AdjTtyJMJ";

    static {
        PayConstant.initEnv(PayConstant.ENV_TEST);
    }

    @Test
    public void createPayOrderWithTrc20Usdt(){
        try{
            PayOrder order=new PayOrder();
            order.setChain("TRON");
            order.setMchAddress(MCH_ADDRESS);
            order.setAccessKeyId(ACCESS_KEY_ID);
            order.setMchOrderNo(UUID.randomUUID().toString());
            order.setChainCode("trc20");
            order.setCoinCode("usdt");
            order.setAccessChannel(PayConstant.ACCESS_CHANNEL_CHAIN);
            // 1.15 usdt
            order.setAmount(BigInteger.valueOf(10_000_000L));
            order.setReceiptAddress(RECEIPT_CONTRACT_ADDRESS);

            OrderOutputParam outputParam= OrderUtil.createPayOrder(order,REQUEST_KEY,SERVICE_TYPE,SERVICE_VERSION,SERVICE_ID);
            System.out.println("get outputParam " + outputParam.toString());
        }catch (IOException | OrderException e){
            System.out.println("create pay order on chain exception " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

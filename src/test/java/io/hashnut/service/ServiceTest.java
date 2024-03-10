package io.hashnut.service;

import io.hashnut.client.HashNutClient;
import io.hashnut.client.HashNutClientImpl;
import io.hashnut.exception.HashNutException;
import io.hashnut.model.*;
import io.hashnut.model.request.*;
import io.hashnut.model.response.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class ServiceTest {

    private HashNutClient hashnutClient;
    private HashNutService hashNutService;
    private final String chainCode="polygon-erc20";
    private final String coinCode="usdt";
    private final String merchantAddress="0xe1fd94f8874d698567e03f671a8c62e4e2e4be90";
    private final String accessKeyId="01HRKDJ93KCNDPEPX9G87E0T33";
    private final String secretKey ="nPCY9Q477Cl3tVulk1kYCPPyY1y114yN";
    private final String receiptAddress="0xc7ac968908ed4c99538c8bed5371b94cbbe6d0c7".toLowerCase();

    @Before
    public void before(){
        hashnutClient = new HashNutClientImpl(secretKey, true);
        hashNutService = new HashNutServiceImpl(hashnutClient);
    }

    @Test
    public void queryChains() throws HashNutException {
        QueryChainsResponse response=hashNutService.queryAllChainInfo(new QueryChainsRequest.Builder().build());
        System.out.println("after build response " + System.currentTimeMillis());
        for(int i=0; i < response.getData().size();i ++){
            ChainInfo chainInfo=response.getData().get(i);
            System.out.println("chain info chain: " + chainInfo.getChain());
        }
    }

    @Test
    public void queryCoins() throws HashNutException {
        QueryCoinsResponse response=hashNutService.queryAllCoinInfo(new QueryCoinsRequest.Builder().build());
        System.out.println("after build response " + System.currentTimeMillis());
        for(int i=0; i < response.getData().size();i ++){
            CoinInfo coinInfo=response.getData().get(i);
            System.out.println("coin info chainCode: " + coinInfo.getChainCode());
            System.out.println("coin info coinCode: " + coinInfo.getCoinCode());
        }
    }

    @Test
    public void querySupportCoinsByChainCode() throws HashNutException {
        QueryCoinsResponse response=hashNutService.querySupportCoin(new QuerySupportCoinRequest.Builder()
                .withChainCode("erc20").build());
        for(CoinInfo coinInfo:response.getData()){
            System.out.println("coin info coinCode: " + coinInfo.getCoinCode());
        }
    }

    @Test
    public void createOrder() throws HashNutException {
        final String merchantOrderId = UUID.randomUUID().toString();
        BigDecimal amount=new BigDecimal("1.13");
        CreateOrderResponse response = hashNutService.createOrder(new CreateOrderRequest.Builder()
                .withAccessKeyId(accessKeyId)
                .withMerchantOrderId(merchantOrderId)
                .withChainCode(chainCode)
                .withCoinCode(coinCode)
                .withAmount(amount)
                .withReceiptAddress(receiptAddress)
                .build());
        HashNutOrder order=response.getData();
        System.out.println("create order : " + order);
        System.out.println("create order payOrderId: " + order.getPayOrderId());
        System.out.println("create order merchantOrderId: " + order.getMerchantOrderId());
        System.out.println("create order accessSign: " + order.getAccessSign());
        System.out.println("create order receiptAddress: " + order.getReceiptAddress());
    }

    @Test
    public void confirmPayOrderPaid() throws HashNutException {
        final String payOrderId="01HRKFC3H3BVZZAEEB1KM06SG0";
        final String merchantOrderId="3df2cd1d-5c2d-45a2-9ea7-fa47d6fec362";
        final String accessSign="F85EAB044144878CCA4C2C874A0E72042435D3D199AB44387D4F2559F40D7B88";
        final String payUUID = UUID.randomUUID().toString();
        final String payTxId="0xd4b2368ba89ba2072a9ed01109b79628266b6ffc09fcc7468139d8d1bd9186e2";
        SingleResponse response=hashNutService.confirmPayOrder(new ConfirmPayOrderRequest.Builder()
                .withPayOrderId(payOrderId)
                .withMerchantOrderId(merchantOrderId)
                .withAccessSign(accessSign)
                .withPayTxId(payTxId)
                .withPayUUID(payUUID)
                .withChainCode(chainCode)
                .withTxChannel(0)
                .build());
        System.out.println("resultCode " + response.code);
        System.out.println("resultMsg " + response.msg);
    }

    @Test
    public void queryOrder() throws HashNutException {
        final String payOrderId="01HRKFC3H3BVZZAEEB1KM06SG0";
        final String mchOrderNo="3df2cd1d-5c2d-45a2-9ea7-fa47d6fec362";
        final String accessSign="F85EAB044144878CCA4C2C874A0E72042435D3D199AB44387D4F2559F40D7B88";

        QueryOrderResponse response=hashNutService.queryOrder(new QueryOrderRequest.Builder()
                .withPayOrderId(payOrderId)
                .withMerchantOrderId(mchOrderNo)
                .withAccessSign(accessSign)
                .build());
        HashNutOrder order=response.getData();
        System.out.println("get order payOrderId: " + order.getPayOrderId());
        System.out.println("get order merchantOrderId: " + order.getMerchantOrderId());
        System.out.println("get order accessSign: " + order.getAccessSign());
        System.out.println("get order amount: " + order.getAmount());
        System.out.println("get order state: " + OrderState.toString(order.getState()));
    }
}

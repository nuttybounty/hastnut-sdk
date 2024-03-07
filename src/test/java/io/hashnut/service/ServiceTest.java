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
    private final String accessKeyId="ACC_1156690317534035968";
    private final String requestKey="JgsnNZqgtZttxHwzbLe4ZxstQwqLXHH4";
    private final String responseKey="CetlG87d3CPPTCQ48PgGoPCoR3tCx4R4";
    private final String receiptAddress="0xdb3cef8aeecc1b41827053279b5d19a82b77e94a".toLowerCase();

    @Before
    public void before(){
        hashnutClient = new HashNutClientImpl(requestKey, responseKey, true);
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
        BigDecimal amount=new BigDecimal("10.1");
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
        final String payOrderId="PAY_1215365061116166144";
        final String merchantOrderId="c6c9757b-6bd6-4151-ab91-e1ab9d7f0bb3";
        final String accessSign="9978F9ED005DC65B3DAF548726A1E9A6B09AAEB5C3390A45DE9BB3CA2914C4B6";
        final String payUUID = UUID.randomUUID().toString();
        final String payTxId="0x052708441397ae47186977ffab79d655e9a2feed920cd345e20049060f465192";
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
        final String payOrderId="PAY_1215365061116166144";
        final String mchOrderNo="c6c9757b-6bd6-4151-ab91-e1ab9d7f0bb3";
        final String accessSign="9978F9ED005DC65B3DAF548726A1E9A6B09AAEB5C3390A45DE9BB3CA2914C4B6";

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

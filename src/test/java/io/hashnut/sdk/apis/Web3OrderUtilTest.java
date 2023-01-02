package io.hashnut.sdk.apis;

import io.hashnut.sdk.exception.OrderException;
import io.hashnut.sdk.models.*;
import io.hashnut.sdk.config.PayConstant;
import io.hashnut.sdk.util.OrderUtil;
import io.hashnut.sdk.util.PayDigestUtil;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public class Web3OrderUtilTest {

    public static final String CHAIN="ETH";
    public static final int SERVICE_TYPE=0;
    public static final String SERVICE_VERSION="PaymentSplitterV2_1";
    public static final int SERVICE_ID=0;
    public static String MCH_ADDRESS ="0xEA997d01742B777F083A4529832450155B3623a6".toLowerCase();
    public static String ACCESS_KEY_ID="ACC_1057302383735865344";
    public static String REQUEST_KEY="MnDHAkknqSykfOCCHkud8CkcPS1LMuAA";
    public static String RESPONSE_KEY="bKANTFRvx9iKxjxA3fSsEKwREF59dSTA";
    public static String RECEIPT_CONTRACT_ADDRESS="0x0e0AB4350306e079399E58a6A98FCeeCB6c9A942".toLowerCase();

    static {
        PayConstant.initEnv(PayConstant.ENV_TEST);
    }

    @Test
    public void queryAllCoinInfo(){
        try {
            List<CoinInfo> coinInfoList=OrderUtil.queryAllCoinInfo();
            System.out.println("coin info " + coinInfoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryAllChainInfo(){
        try {
            List<ChainInfo> chainInfoList=OrderUtil.queryAllChainInfo();
            System.out.println("chain info " + chainInfoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryAllSupportLegalTender(){
        try {
            List<LegalTender> legalTenderList=OrderUtil.queryAllSupportLegalTender();
            System.out.println("legal tender " + legalTenderList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryAllFliatExchange(){
        try {
            List<FliatExchangeRate> fliatExchangeRateList=OrderUtil.queryFliatExchange("usdt","hkd","erc20");
            System.out.println("fliat exchange " + fliatExchangeRateList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void querySupportCoinsByChainCode(){
        try {
            List<CoinInfo> coinInfoList=OrderUtil.querySupportCoinsByChainCode("erc20");
            System.out.println("coin info " + coinInfoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPayOrderWithETHUsdt(){
        try{
            PayOrder order=new PayOrder();
            order.setChain("ETH");
            order.setMchAddress(MCH_ADDRESS);
            order.setAccessKeyId(ACCESS_KEY_ID);
            order.setMchOrderNo(UUID.randomUUID().toString());
            order.setChainCode("erc20");
            order.setCoinCode("usdt");
            order.setAccessChannel(PayConstant.ACCESS_CHANNEL_CHAIN);
            // 10 usdt
            order.setAmount(BigInteger.valueOf(1_000_000L));
            order.setReceiptAddress(RECEIPT_CONTRACT_ADDRESS);
            order.setCustomCallBackUrl(true);
            order.setExtra("https://goerli.etherscan.io/");

            OrderOutputParam outputParam=OrderUtil.createPayOrderWithCustomCallBackUrl(order,REQUEST_KEY,SERVICE_TYPE,SERVICE_VERSION,SERVICE_ID, order.getExtra());
            System.out.println("get outputParam " + outputParam.toString());
        }catch (IOException | OrderException e){
            System.out.println("create pay order on chain exception " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryPayOrder(){
        try {
            PayOrder order=OrderUtil.queryPayOrder("PAY_1056936679761248256","8861eacf-e290-4b00-bb9f-84e3e120f955","629CF39FD7A5FB03C2BC89933B87A950B8B5F5385D7F39FFB0C081307BA59DC5");
            System.out.println("query order " + order.toString());
            System.out.println("amount " + order.getAmount());
            System.out.println("state " + order.getState());
            System.out.println("confirmCount " + order.getConfirmCount());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void lockPayOrderAccessChain(){
        try{
            String payUUID=UUID.randomUUID().toString();
            boolean lockResult=OrderUtil.lockPayOrder("PAY_978051313956814848",
                    "MCHO_5000006",
                    "erc20",
                    payUUID,
                    "C87C822875BDEFCAC1F12D5F42F610CD823F822D5504F1D1D56DC1796ECA88F3");
            System.out.println("lock pay order result " +lockResult + " payUUID " + payUUID);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void confirmPayOrderAccessChain() {
        try{
            boolean result=OrderUtil.confirmPayOrderPaid("PAY_978051313956814848",
                    "MCHO_5000006",
                    "0xe99ebfed21a90e5964c5c978b75902a1de49f59c61a31f5ceb3ac0ac6abc2a9d",
                    "C87C822875BDEFCAC1F12D5F42F610CD823F822D5504F1D1D56DC1796ECA88F3",
                    "erc20",
                    "fd9af617-2a84-4b4b-b5d3-56a72f9e1b20");
            System.out.println("confirmPayOrderPaid Result " + result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifySign() throws Exception {
        final String data="accessChannel=0&accessKeyId=ACC_1052637124131553280&amount=10000000&chain=POLYGON&chainCode=polygon-erc20&coinCode=usdt&mchAddress=0xd331bffdb99d0d0460a2aab5d1b381385a3652f0&mchOrderNo=MCHO_500000121400&receiptContractAddress=0xd37e283C47728017a1a12A0b6316078009b1b647&serviceId=0&serviceType=0&serviceVersion=PaymentSplitterV1_1&";
        final String data1="accessChannel=0&accessKeyId=ACC_1052637124131553280&amount=10000000&chain=POLYGON&chainCode=polygon-erc20&coinCode=usdt&mchAddress=0xd331bffdb99d0d0460a2aab5d1b381385a3652f0&mchOrderNo=MCHO_500000121400&receiptContractAddress=0xd37e283c47728017a1a12a0b6316078009b1b647&serviceId=0&serviceType=0&serviceVersion=PaymentSplitterV1_1&";
        String sign= PayDigestUtil.HMACSHA256(REQUEST_KEY,data);
        String sign1=PayDigestUtil.HMACSHA256(REQUEST_KEY,data1);
        System.out.println("get sign " + sign);
        System.out.println("get sign 1" + sign1);

        System.out.println("different index " + data.compareTo(data1));
    }
}

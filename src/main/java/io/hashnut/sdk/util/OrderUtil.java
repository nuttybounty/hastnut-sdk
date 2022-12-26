package io.hashnut.sdk.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.hashnut.sdk.config.PayConstant;
import io.hashnut.sdk.exception.OrderException;
import io.hashnut.sdk.models.*;
import io.hashnut.sdk.models.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;

public class OrderUtil {

    public static List<CoinInfo> queryAllCoinInfo() throws IOException {

        String result=HttpOrderUtil.get(PayConstant.URL_QUERY_ALL_COININFO,null);
        System.out.println("query all coin info result" + result);
        Response<List<CoinInfo>> response= JSONObject.parseObject(result,new TypeReference<>(){});
        System.out.println("query all coin info " + response.data);
        if(response.resultCode!=0 || response.data==null){
            return null;
        }
        return response.data;
    }

    public static List<ChainInfo> queryAllChainInfo() throws IOException {
        String result=HttpOrderUtil.get(PayConstant.URL_QUERY_ALL_CHAININFO,null);
        System.out.println("query all chain info result" + result);
        Response<List<ChainInfo>> response= JSONObject.parseObject(result,new TypeReference<>(){});
        System.out.println("query all chain info " + response.data);
        if(response.resultCode!=0 || response.data==null){
            return null;
        }
        return response.data;
    }

    public static List<CoinInfo> querySupportCoinsByChainCode(@NotNull String chainCode) throws IOException {
        Map<String,String> paramMap=new HashMap<>();
        paramMap.put("chainCode",chainCode);
        String result=HttpOrderUtil.get(PayConstant.URL_QUERY_SUPPORT_COIN_BY_CHAIN_CODE,paramMap);
        System.out.println("query coin info by chain code result" + result);
        Response<List<CoinInfo>> response= JSONObject.parseObject(result,new TypeReference<>(){});
        System.out.println("query coin info by chain code " + response.data);
        if(response.resultCode!=0 || response.data==null){
            return null;
        }
        return response.data;
    }

    public static List<LegalTender> queryAllSupportLegalTender() throws IOException {
        String result=HttpOrderUtil.get(PayConstant.URL_QUERY_ALL_LEGAL_TENDER,null);
        System.out.println("query all legal tender result" + result);
        Response<List<LegalTender>> response= JSONObject.parseObject(result,new TypeReference<>(){});
        System.out.println("query all legal tender " + response.data);
        if(response.resultCode!=0 || response.data==null){
            return null;
        }
        return response.data;
    }

    public static List<FliatExchangeRate> queryFliatExchange(String baseCoin, String quoteCoin, String chainCode) throws IOException {
        Map<String,String> paramMap=new HashMap<>();
        paramMap.put("baseCoin",baseCoin);
        paramMap.put("quoteCoin",quoteCoin);
        paramMap.put("chainCode",chainCode);
        String result=HttpOrderUtil.get(PayConstant.URL_QUERY_ALL_FLIAT_EXCHANGE_RATE,paramMap);
        System.out.println("query all fliat exchange result" + result);
        Response<List<FliatExchangeRate>> response= JSONObject.parseObject(result,new TypeReference<>(){});
        System.out.println("query all fliat exchange " + response.data);
        if(response.resultCode!=0 || response.data==null){
            return null;
        }
        return response.data;
    }

    public static Map<String,Object> genPayOrderParams(PayOrder o, String requestKey){
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("mchAddress",o.getMchAddress());
        paramMap.put("accessKeyId",o.getAccessKeyId());
        paramMap.put("mchOrderNo",o.getMchOrderNo());
        paramMap.put("coinCode",o.getCoinCode());

        String sign= PayDigestUtil.getHmacSign256(requestKey,paramMap);
        paramMap.put("sign",sign);
        return paramMap;
    }

    public static OrderOutputParam createPayOrder(PayOrder input, String requestKey,int serviceType,String serviceVersion,int serviceId) throws OrderException, IOException {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("chain",input.getChain());
        paramMap.put("mchAddress",input.getMchAddress());
        paramMap.put("accessKeyId",input.getAccessKeyId());
        paramMap.put("mchOrderNo",input.getMchOrderNo());
        paramMap.put("coinCode",input.getCoinCode());
        paramMap.put("chainCode",input.getChainCode());
        paramMap.put("amount",input.getAmount());
        paramMap.put("serviceType",serviceType);
        paramMap.put("serviceVersion",serviceVersion);
        paramMap.put("serviceId",serviceId);
        paramMap.put("receiptContractAddress",input.getReceiptAddress());
        paramMap.put("accessChannel", input.getAccessChannel());

        String sign= PayDigestUtil.getHmacSign256(requestKey,paramMap);
        paramMap.put("sign",sign);
        System.out.println("sign " + sign);
        String result= HttpOrderUtil.sendPOST(PayConstant.URL_CREATE_PAY_ORDER,paramMap);
        System.out.println("get create pay order result" + result);
        Response<OrderOutputParam> response= JSONObject.parseObject(result,new TypeReference<Response<OrderOutputParam>>(){});
        System.out.println("create pay order " + response.data);

        if(response.resultCode!=0 || response.data==null){
            throw new OrderException(response.resultMsg);
        }

        return response.data;
    }

    public static boolean lockPayOrder(String orderId,String mchOrderNo,String chainCode,String payUUID,String accessSign) throws OrderException, IOException {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("platformId",orderId);
        paramMap.put("mchOrderNo",mchOrderNo);
        paramMap.put("chainCode",chainCode);
        paramMap.put("payUUID", payUUID);
        paramMap.put("accessSign",accessSign);

        String result= HttpOrderUtil.sendPOST(PayConstant.URL_LOCK_PAY_ORDER,paramMap);
        System.out.println("get lock pay order result" + result);
        Response<String> response= JSONObject.parseObject(result,new TypeReference<Response<String>>(){});
        System.out.println("lock pay order " + response.data);

        return response.resultCode==0;
    }


    public static PayOrder queryPayOrder(String platformId,String mchOrderNo,String accessSign) throws OrderException,IOException{
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("platformId",platformId);
        paramMap.put("mchOrderNo",mchOrderNo);
        paramMap.put("accessSign",accessSign);

        String result=HttpOrderUtil.sendPOST(PayConstant.URL_QUERY_PAY_ORDER,paramMap);
        System.out.println("query pay order result" + result);
        Response<PayOrder> response= JSONObject.parseObject(result,new TypeReference<Response<PayOrder>>(){});
        System.out.println("query pay order " + response.data);
        if(response.resultCode!=0 || response.data==null){
            throw new OrderException(response.resultMsg);
        }

        return response.data;
    }

    public static boolean confirmPayOrderPaid(String platformId,String mchOrderNo,String payTxIdString,String accessSign,String chainCode,String payUUID) throws IOException {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("platformId",platformId);
        paramMap.put("mchOrderNo",mchOrderNo);
        paramMap.put("payTxId",payTxIdString);
        paramMap.put("payUUID",payUUID);
        paramMap.put("accessSign",accessSign);
        paramMap.put("chainCode",chainCode);

        String result=HttpOrderUtil.sendPOST(PayConstant.URL_CONFIRM_PAY_ORDER,paramMap);
        System.out.println("confirm pay order result" + result);
        Response<String> response= JSONObject.parseObject(result,new TypeReference<Response<String>>(){});
        System.out.println("confirm pay order " + response.data);
        return response.resultCode==0;
    }
}

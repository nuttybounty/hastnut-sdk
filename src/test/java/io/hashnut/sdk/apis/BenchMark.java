package io.hashnut.sdk.apis;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.hashnut.sdk.models.OrderOutputParam;
import io.hashnut.sdk.models.PayOrder;
import io.hashnut.sdk.models.Response;
import io.hashnut.sdk.util.HttpOrderUtil;
import io.hashnut.sdk.util.PayDigestUtil;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static io.hashnut.sdk.config.PayConstant.*;


public class BenchMark {
    public static String MCH_ID="MCH_0020210930090342000001";
    public static String ACCESS_KEY_ID="ACC_977928828355608576";
    public static String REQUEST_KEY="aGSWLU2QDHux0GHGTuwakBkXLnn0QQL4";
    public static String RESPONSE_KEY="Xi9r8EFdws3Mko2iO3wXmJyF8gg7ddlW";

    @Test
    public void testCreatePayOrderOnChain() {
        try{
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("mchId",MCH_ID);
            paramMap.put("accessKeyId",ACCESS_KEY_ID);
            paramMap.put("mchOrderNo","test_apache_http6");
            paramMap.put("chainCode","erc20");
            paramMap.put("coinCode","usdt");
            paramMap.put("amount",10000L);
            paramMap.put("accessChannel",ACCESS_CHANNEL_CHAIN);

            String sign= PayDigestUtil.getHmacSign256(REQUEST_KEY,paramMap);
            paramMap.put("sign",sign);

            String result= HttpOrderUtil.sendPOST(URL_CREATE_PAY_ORDER,paramMap);
            System.out.println("get create pay order result" + result);
            Response<OrderOutputParam> response= JSONObject.parseObject(result,new TypeReference<Response<OrderOutputParam>>(){});
            System.out.println("create pay order " + response.data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryPayOrder() {
        try {
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("platformId","PAY_977930490688307200");
            paramMap.put("mchOrderNo","test_apache_http5");
            paramMap.put("accessSign","9CD5C893CC9526D1C3C0E4B626FFE30055C35901DBCA3CD2E92073E2F305FC87");

            String result=HttpOrderUtil.sendPOST(URL_QUERY_PAY_ORDER,paramMap);
            System.out.println("query pay order result" + result);
            Response<PayOrder> response= JSONObject.parseObject(result,new TypeReference<Response<PayOrder>>(){});
            System.out.println("query pay order " + response.data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testConfirmPayOrder(){
        try {
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("platformId","PAY_0020210714143915000003");
            paramMap.put("mchOrderNo","test_apache_http2");
            paramMap.put("payTxId","0x490f89b0c371341af5d84fe7def2c9350a4f6975514dc6dfa3d5a6157ce03b7g");
            paramMap.put("accessSign","EF6E69BCB6C5E39D6FE63C69C770E65129EB3CCD262F5BD14996D29C4A9598CC");
            paramMap.put("chainCode","erc20");

            String sign= PayDigestUtil.getHmacSign256(REQUEST_KEY,paramMap);
            paramMap.put("sign",sign);

            String result=HttpOrderUtil.sendPOST(URL_CONFIRM_PAY_ORDER,paramMap);
            System.out.println("confirm pay order result" + result);
            Response<String> response= JSONObject.parseObject(result,new TypeReference<Response<String>>(){});
            System.out.println("confirm pay order " + response.data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

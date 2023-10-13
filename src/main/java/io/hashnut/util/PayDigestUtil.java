package io.hashnut.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PayDigestUtil {

    public static String HMACSHA256(String key,String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    public static String getHmacSign256(String key, Map<String,Object> map){
        try{
            ArrayList<String> list = new ArrayList<>();
            for(Map.Entry<String,Object> entry:map.entrySet()){
                if(!"".equals(entry.getValue()) && null != entry.getValue()){
                    list.add(entry.getKey() + "=" + entry.getValue() + "&");
                }
            }
            int size = list.size();
            String [] arrayToSort = list.toArray(new String[size]);
            Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < size; i ++) {
                sb.append(arrayToSort[i]);
            }
            String data = sb.toString();
            return PayDigestUtil.HMACSHA256(key,data);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

package io.hashnut.authentication;

import io.hashnut.util.PayDigestUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class Authentication {
    private final String requestKey;
    private final String responseKey;

    public Authentication(String requestKey, String responseKey) {
        this.requestKey = requestKey;
        this.responseKey = responseKey;
    }

    public String generateSignedPayload(Map<String,Object> map){
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
            String sign=PayDigestUtil.HMACSHA256(requestKey,sb.toString());
            sb.append("sign=");
            sb.append(sign);
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String generatePayload(Map<String,Object> map){
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringJoiner joiner = new StringJoiner("&");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                try {
                    String encodedKey = URLEncoder.encode(key, "UTF-8");
                    String encodedValue = URLEncoder.encode(value.toString(), "UTF-8");
                    joiner.add(encodedKey + "=" + encodedValue);
                } catch (UnsupportedEncodingException e) {
                    return null;
                }
            }
        }
        return joiner.toString();
    }

}

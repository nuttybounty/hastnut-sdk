package io.hashnut.sdk.util;

import io.hashnut.sdk.config.PayConstant;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HttpOrderUtil {

    public static String sendPOST(String url, Map<String,Object> paramMap) throws IOException {
        String result = "";
        HttpPost post = new HttpPost(url);
        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        for(Map.Entry<String,Object> entry:paramMap.entrySet()){
            if(!"".equals(entry.getValue()) && null != entry.getValue()){
                urlParameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }
        post.setHeader("version", PayConstant.getApiVersion());
        post.setHeader("locale", PayConstant.getApiLocale());
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){
            result = EntityUtils.toString(response.getEntity());
        }
        return result;
    }

    public static String get(String url,Map<String,String> paramMap) throws IOException {
        String result = "";

        // add request parameters or form parameters
        String urlParams=null;
        if(paramMap != null && paramMap.size() > 0){
            ArrayList<String> list = new ArrayList<>();
            for(Map.Entry<String,String> entry:paramMap.entrySet()){
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
            urlParams = sb.toString();
        }

        if(urlParams!=null)
            url = url + "?" + urlParams;

        HttpGet get = new HttpGet(url);
        get.setHeader("version", PayConstant.getApiVersion());
        get.setHeader("locale", PayConstant.getApiLocale());
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)){
            result = EntityUtils.toString(response.getEntity());
        }
        return result;
    }
}

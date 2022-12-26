package io.hashnut.sdk.util;

import io.hashnut.sdk.config.PayConstant;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PayDigestUtil {

	/**
	 * 生成 HMACSHA256
	 *
	 * @param key  密钥
	 * @param data 待处理数据
	 * @return 加密结果
	 * @throws Exception
	 */
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

	/**
	 * 生成 HMACSHA512
	 *
	 * @param key  密钥
	 * @param data 待处理数据
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String HMACSHA512(String key,String data) throws Exception {
		Mac sha512_HMAC = Mac.getInstance("HmacSHA512");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
		sha512_HMAC.init(secret_key);
		byte[] array = sha512_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 将多个字符串按照ASC升序进行排列并拼接，然后生成 HMACSHA256签名
	 *
	 * @param key  密钥
	 * @param strings 多个字符串
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String getHmacSign256(String key, String...strings){
		try{
			ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
			String [] arrayToSort = list.toArray(new String[0]);
			Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < list.size(); i ++) {
				sb.append(arrayToSort[i]);
			}
			return PayDigestUtil.HMACSHA256(key,sb.toString());
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将map当中的字符串按照asc升序排列，按照url的方式进行拼接，然后生成HMACSHA256签名
	 *
	 * @param key  密钥
	 * @param map  多个字符串
	 * @return 加密结果
	 * @throws Exception
	 */
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
			System.out.println("get data to sign " + data);
			return PayDigestUtil.HMACSHA256(key,data);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将map当中的字符串按照asc升序排列，按照url的方式进行拼接，然后生成HMACSHA256签名
	 *
	 * @param key  密钥
	 * @param map  多个字符串
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String getHmacSign512(String key, Map<String,Object> map){
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
			return PayDigestUtil.HMACSHA512(key,data);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	// notContains 不包含的签名字段
	public static String getHmacSign256(String key, Map<String,Object> map, String... notContains){
		Map<String,Object> newMap = new HashMap<String,Object>();
		for(Map.Entry<String,Object> entry:map.entrySet()){
			boolean isContain = false;
			for(int i=0; i<notContains.length; i++) {
				if(entry.getKey().equals(notContains[i])) {
					isContain = true;
					break;
				}
			}
			if(!isContain) {
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		return getHmacSign256(key,newMap);
	}

	public static boolean verifyHmacSign256(String key, String sign, String...strings){
		String vSign=PayDigestUtil.getHmacSign256(key,strings);
		return vSign != null && vSign.equals(sign);
	}

	public static boolean verifyHmacSign256(String key, String sign, Map<String,Object> map){
		String vSign=PayDigestUtil.getHmacSign256(key,map);
		return vSign != null && vSign.equals(sign);
	}

	public static boolean verifyHmacSign256(String key, String sign, Map<String,Object> map, String...notContains){
		String vSign=PayDigestUtil.getHmacSign256(key,map,notContains);
		return vSign != null && vSign.equals(sign);
	}

	public static String toHex(byte input[]) {
		if (input == null)
			return null;
		StringBuffer output = new StringBuffer(input.length * 2);
		for (int i = 0; i < input.length; i++) {
			int current = input[i] & 0xff;
			if (current < 16)
				output.append("0");
			output.append(Integer.toString(current, 16));
		}

		return output.toString();
	}

	public static String md5(String value, String charset) {
		MessageDigest md = null;
		try {
			byte[] data = value.getBytes(charset);
			md = MessageDigest.getInstance("MD5");
			byte[] digestData = md.digest(data);
			return toHex(digestData);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getMd5Sign(Map<String,Object> map, String key){
		ArrayList<String> list = new ArrayList<String>();
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
		String result = sb.toString();
		result += "key=" + key;
		result = md5(result, "UTF-8").toUpperCase();
		return result;
	}

	// notContains 不包含的签名字段
	public static String getMd5Sign(Map<String,Object> map, String key, String... notContains){
		Map<String,Object> newMap = new HashMap<String,Object>();
		for(Map.Entry<String,Object> entry:map.entrySet()){
			boolean isContain = false;
			for(int i=0; i<notContains.length; i++) {
				if(entry.getKey().equals(notContains[i])) {
					isContain = true;
					break;
				}
			}
			if(!isContain) {
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		return getMd5Sign(newMap, key);
	}

	// 将strings当中的字符串按照asc排序，然后和key拼接，再做md5签名，再验签
	public static boolean verifyMd5Sign(String sign, String key, String...strings){
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i < strings.length;i++){
			list.add(strings[i]);
		}
		int size = list.size();
		String [] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i ++) {
			sb.append(arrayToSort[i]);
		}
		return sign.equals(PayDigestUtil.md5(sb.toString()+key,"UTF-8"));
	}

	// 将strings当中的字符串按照asc排序，然后签名
	public static String getMd5Sign(String key, String...strings){
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i < strings.length;i++){
			list.add(strings[i]);
		}
		int size = list.size();
		String [] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i ++) {
			sb.append(arrayToSort[i]);
		}
		return PayDigestUtil.md5(sb.toString()+key,"UTF-8");
	}

	public static void main(String[] args) throws Exception {
		String requestKey = "IsYtkkBW7YBIPlkYknWt0eZee8rnrIo7";

		Map<String,Object> paramMap=new HashMap<>();
		paramMap.put("mchId","MCH_0020210924084113000000");
		paramMap.put("accessKeyId","ACC_0020211203070350000000");
		paramMap.put("mchOrderNo","MCHO_100121");
		paramMap.put("chainCode","erc20");
		paramMap.put("coinCode","usdt");
		paramMap.put("amount", BigInteger.valueOf(10000000L));
		paramMap.put("createChannel",PayConstant.CREATE_CHANNEL_API_KEY);
		paramMap.put("accessChannel", PayConstant.ACCESS_CHANNEL_CHAIN);


		String sign = PayDigestUtil.getHmacSign256(requestKey,paramMap);
		System.out.println("sign is " + sign);

		boolean result=PayDigestUtil.verifyHmacSign256(requestKey,sign,paramMap,"sign");
		System.out.println("verify sign result is " + result);
	}
}

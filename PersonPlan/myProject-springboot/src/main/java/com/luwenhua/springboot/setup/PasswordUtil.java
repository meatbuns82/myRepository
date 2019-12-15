package com.luwenhua.springboot.setup;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;

public class PasswordUtil {

    /**
     * java支持 以下任意一种算法
     *
     * PBEWithMD5ANDDES
     * PBEWithMD5ANDTRIPLEDES
     * PBEWithMD5ANDDESEDE
     * ………………
     */
    //定义使用的算法为   PBEWithMD5AndDES
    public static final String ALGORITHM = "PBEWithMD5AndDES"; //加密算法

    public static final String Salt = "63293188"; //密钥

    /*
        定义迭代次数为 1000次
    */

    private static final int ITERATIONCOUNT = 1000;

    /**
     * 获取加密算法中使用的盐值，解密中使用的盐值 必须与加密中使用的相同才能完成操作。盐长度必须为8字节
     *
     *
     * @return byte[] 盐值
     */
    public static byte[] getSalt() {
        //实例化安全随机数
        SecureRandom random = new SecureRandom();
        //产出盐
        return random.generateSeed(8);
    }

    public static  byte[] getStaticSalt(){
        //产出盐
        return Salt.getBytes();
    }
    /**
     * 根据PBE密码生成一把密钥
     *
     * @param password
     *          生成密钥时所用的密码
     *
     * @return Key PBE算法密钥，
     */

    private static Key getPBEKey(String password){

        //实例化使用算法
        SecretKeyFactory keyFactory;
        SecretKey secretKey = null;

        try {
            keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            //设置PBE密钥参数
            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
            //生成密钥
            secretKey = keyFactory.generateSecret(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return secretKey;
    }

    /**
     * 加密明文字符串
     *
     * @param plainText  待加密明文字符串
     *
     *@param useracount   生成密钥所使用的账户
     *
     *@param salt  盐值
     *
     *@return 加密后的密文字符串
     */

    public static String entrcy(String plainText,String useracount,String salt){
        Key key = getPBEKey(useracount);               //得到传入的密码的密钥
        byte[] enciphereData = null;
        PBEParameterSpec parameterSpec = new PBEParameterSpec(salt.getBytes(),ITERATIONCOUNT);

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,key,parameterSpec);
            enciphereData = cipher.doFinal(plainText.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytesToHexString(enciphereData);
    }

    /**
     * 解密密文字符串
     *
     * @oaram ciphertext  解密的密文字符串
     *
     * @param useracount 生成密钥时所使用的密码 (如需解密，该参数需要与加密时使用的一直)
     *
     * @param salt 盐值 (如需解密，该参数需要与加密时使用的一致
     *
     * @return 解密后的明文字符串
     */
    public static  String decrypt(String ciphertext,String useracount,String salt){
        Key key = getPBEKey(useracount);          //得到传入的密码的密钥

        byte[] passDec = null;

        PBEParameterSpec parameterSpec = new PBEParameterSpec(salt.getBytes(),ITERATIONCOUNT);

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,key,parameterSpec);
            passDec = cipher.doFinal(hexStringToBytes(ciphertext));
        }  catch (Exception e) {
            System.out.println("解密时抛出异常"+ciphertext+":"+useracount+":"+salt);
        }
        if(passDec == null){
            return null;
        }
        return  new String(passDec);
    }

    /**
     *将字节数组转换为十六进制字符串
     * @param src 字节数组
     * @return
     */


    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");

        if(src == null || src.length<=0){
            return null;
        }
        for (int i =0;i<src.length;i++){
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if(hv.length()<2){
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 将16进制字符串转换为字节数组
     * @param hexString 16进制字符串
     * @return
     */

    public static byte[] hexStringToBytes(String hexString){
        if(hexString == null || hexString.equals("")){
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length()/2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for(int i =0;i<length;i++){
            int pos = i*2;
            d[i] = (byte)(charToByte(hexChars[pos]) <<4 | charToByte(hexChars[pos + 1]));
        }
        return  d;
    }

    private static byte charToByte(char c){
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}

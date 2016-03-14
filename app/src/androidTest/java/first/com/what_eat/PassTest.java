package first.com.what_eat;


import android.test.AndroidTestCase;

import first.com.what_eat.global.Constant;
import first.com.what_eat.util.EncryptUtil;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class PassTest extends AndroidTestCase {
    public void testRegister()throws Exception{
        String sendText="{\"phone\":\"18817772486\",\"password\":\"12345678\",\"telverify\":\"8463\",\"group_id\":\"4\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("注册加密结果为: " + encryptData);
    }
//    public void testMakeRunner()throws Exception{
//        String sendText="{\"phone\":\"18817772486\",\"new_password\":\"12345678\",\"telverify\":\"3413\"}";
//        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
//        System.out.println("成为跑推加密结果为: " + encryptData);
//
//    }
    public void testMakeRunner()throws Exception{
        String sendText="{\"phone\":\"15083620505\",\"password\":\"111111\",\"telverify\":\"5892\",\"nickname\":\"du\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("成为跑推加密结果为: " + encryptData);

    }
    public void testLoadRunner()throws Exception{
        String sendText="{\"username\":\"15083620505\",\"password\":\"111111\",\"group_id\":\"4\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("跑推端登录加密结果为: " + encryptData);

    }
    public void testDecrypt()throws Exception{
        String receiveText ="fxUvAO5uG0rp3NM683chhR1wqh8cVE7xF8k4uGSv1SJBW39r0CF2t" +
                "JlEKW9BP0Nrs5AZ8KM1mIbkWI0AnrGpYyHTT/7t0K2aZCFjfBxZ/8qOMnU54g3tC8V2hpMxlZvacO1B+lmvmFk5Xrxc7O32hBuA9c92cnH5Xfve5PHKlz+" +
                "pGwRZIitx+9fntGUbIgcLFYrHFt8tNFIuDmFkiNJiSdgUJSQT23F4hrvFVUfcUq492vS6OFL0pGiE7L0tkWdCkMHGupybMLZj1E5HiiIPZHcRfOYh2adP8g0WjX1qQAgkxXPn1l" +
                "HboMHxZC7mzJjIA6zakZImblHGBJBARlzsVBUXkhfbpwfOMEOo7WHMc/xQucspsdITRxkV3DA2WF3aS3zSZOLoGKT/fbTl2hZyWkoC3zDgSwBYVbndD8mBFue2TLsYBwRz42AtjfyfsoAteEg/" +
                "pVCrs/Qol+9mjkQy4ZCxCPR+gVlsEyHxLRJvH88uY4zD6W4VnR4CJni7YJrjp99A3WXBc3NzFEHqWAO7fXqFvgMsKXN5q/p3+uToVS6nik5oif1xC/" +
                "oU2uEqefCvGHSjJjDq7mnUh9gkDSdqRcG7xR1Ti25lW8YTtvq88VjsiJmI76SrromvXlV74ydtQ2ODNriGSxycQO6JTuQKHPWV8ZcQzQhRE6myKxVlQX+bZHKDv4sDmMqFA4PvEUZA";
        String jsonStr = EncryptUtil.decrypt(Constant.KEY, receiveText);
        System.out.println("解密结果: " + jsonStr);
    }


    public void testPerfectData()throws Exception{
        String sendText="{\"uid\":\"20\",\"filed\":\"head\",\"value\":\"20\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("完善资料加密结果："+encryptData);

    }
}
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
        String sendText="{\"phone\":\"18817773658\",\"password\":\"12345678\",\"telverify\":\"9286\",\"nickname\":\"du\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("成为跑推加密结果为: " + encryptData);

    }
    public void testLoadRunner()throws Exception{
        String sendText="{\"username\":\"15083620505\",\"password\":\"111111\",\"group_id\":\"4\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("跑推端登录加密结果为: " + encryptData);

    }
    public void testDecrypt()throws Exception{
        String receiveText ="yqdXc8UDk1Uc8eDJtYh38ziJeA7fAxG4zqc7F5dsyA6orAQR2m4mtvJam/dADdsZ";
        String jsonStr = EncryptUtil.decrypt(Constant.KEY, receiveText);
        System.out.println("解密结果: " + jsonStr);
    }
//      public void testDecrypt()throws Exception{
//        String receiveText ="fxUvAO5uG0rp3NM683chhR1wqh8cVE7xF8k4uGSv1SJBW39r0CF2t" +
//                "JlEKW9BP0Nrs5AZ8KM1mIbkWI0AnrGpYyHTT/7t0K2aZCFjfBxZ/8qOMnU54g3tC8V2hpMxlZvacO1B+lmvmFk5Xrxc7O32hBuA9c92cnH5Xfve5PHKlz+" +
//                "pGwRZIitx+9fntGUbIgcLFYrHFt8tNFIuDmFkiNJiSdgUJSQT23F4hrvFVUfcUq492vS6OFL0pGiE7L0tkWdCkMHGupybMLZj1E5HiiIPZHcRfOYh2adP8g0WjX1qQAgkxXPn1l" +
//                "HboMHxZC7mzJjIA6zakZImblHGBJBARlzsVBUXkhfbpwfOMEOo7WHMc/xQucspsdITRxkV3DA2WF3aS3zSZOLoGKT/fbTl2hZyWkoC3zDgSwBYVbndD8mBFue2TLsYBwRz42AtjfyfsoAteEg/" +
//                "pVCrs/Qol+9mjkQy4ZCxCPR+gVlsEyHxLRJvH88uY4zD6W4VnR4CJni7YJrjp99A3WXBc3NzFEHqWAO7fXqFvgMsKXN5q/p3+uToVS6nik5oif1xC/" +
//                "oU2uEqefCvGHSjJjDq7mnUh9gkDSdqRcG7xR1Ti25lW8YTtvq88VjsiJmI76SrromvXlV74ydtQ2ODNriGSxycQO6JTuQKHPWV8ZcQzQhRE6myKxVlQX+bZHKDv4sDmMqFA4PvEUZA";
//        String jsonStr = EncryptUtil.decrypt(Constant.KEY, receiveText);
//        System.out.println("解密结果: " + jsonStr);
//    }

    public void testPerfectData()throws Exception{
        String sendText="{\"uid\":\"20\",\"filed\":\"head\",\"value\":\"20\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("完善资料加密结果："+encryptData);

    }
    public void testSetWorkStatus()throws Exception{
        String sendText="{\"uid\":\"20\",\"workstatus\":\"1\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("设置工作状态加密结果："+encryptData);
    }
    public void testSetCurrentAddress()throws Exception{
        String sendText="{\"uid\":\"20\",\"address\":\"shanghai\",\"lat\":\"20\",\"lng\":\"20\"}";
        final String encryptData = EncryptUtil.encrypt(Constant.KEY, sendText); // 加密数据
        System.out.println("设置现在详细地址加密结果："+encryptData);
    }
    public void testReceiveOrder()throws Exception{
        String sendText="{\"uid\":\"20\",\"orderid\":\"10\",\"lat\":\"20\",\"lng\":\"20\" }";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置接单加密结果:"+encryptData);
    }
    //绑定银行卡
    public void testBindBank()throws Exception{
        String sendText="{\n" +
                "   \"uid\":\"20\",\"certificatetype\":\"1\",\"certificatenumber\":\"12345678910\",\"banktype\":\"1\",\"banknumber\":\"1234567898585\"," +
                "\"bankname\":\"changbai\",\"name\":\"du\",\"phone\":\"18817773658\",\"telverify\":\"5743\" }";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置绑定银行卡加密结果:"+encryptData);
    }
    //解除绑定银行卡
    public void testUnbindBank()throws Exception{
        String sendText="{\"uid\":\"20\",\"banknumber\":\"1234567898585\",\"paypassword\":\"123456\"}";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置解除绑定银行卡加密结果:"+encryptData);
    }
    //"data":"KTV6Tcg/DWIgnjStjQJ/0Gu+BJrzNAW0k3JFM+WMZ0Vm4uyqDDkadafOzUJYXlGCoiRLfhfUbp4s\nPDjVfDDZSR2NpgNbbBeYO6yn3T+gTPY="
    //设置提现密码
    public void testWithdrawPassword()throws Exception{
        String sendText="{\"uid\":\"20\",\"paypassword\":\"123456\"}";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置银行卡密码加密结果:"+encryptData);
    }
//验证提现密码
public void testVerifyWithdrawPassword()throws Exception{
    String sendText="{\"uid\":\"20\",\"paypassword\":\"123456\"}";
    final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
    System.out.println("设置修改提现密码加密结果:"+encryptData);
}
    //修改提现密码
    public void testModifyWithdrawPassword()throws Exception{
        String sendText="{\"uid\":20,\"old_paypassword\":\"123456\",\"new_paypassword\":\"12345678\"}";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置银行卡密码加密结果:"+encryptData);
    }
    //申请提现
    public void testApplyWithdrawal()throws Exception{
        String sendText="{\"uid\":20,\"banknumber\":\"1234567898585\",\"money\":\"20\"}";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置提现申请加密结果:"+encryptData);
    }
    //邀请兄弟
    public void testInviteBrother()throws Exception{
        String sendText="{\"uid\":20,\"tuijiancode\":\"2323\"\n}";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置邀请兄弟加密结果:"+encryptData);
    }
    //处理邀请
    public void testHandleInvite()throws Exception{
        String sendText="{\"uid\":20,\"fuid\":2,\"status\":2}";
        final  String encryptData=EncryptUtil.encrypt(Constant.KEY,sendText);
        System.out.println("设置处理邀请加密结果:"+encryptData);
    }

}
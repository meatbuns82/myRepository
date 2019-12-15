package com.luwenhua.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.luwenhua.springboot.enty.LoginEnty;
import com.luwenhua.springboot.enty.RegisterEnty;
import com.luwenhua.springboot.model.LoginModel;
import com.luwenhua.springboot.model.RegisterModel;
import com.luwenhua.springboot.service.CheckExistService;
import com.luwenhua.springboot.service.LoginService;
import com.luwenhua.springboot.service.RegisterService;
import com.luwenhua.springboot.setup.PasswordUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*@ResponseBody // 该注释加在类上，表明该类的所有方法返回的数据直接写给浏览器（若是对象，可以专程json数据
@Controller*/

//项目加密 使用的 是用户账户  用户密码 以及随机产出的 安全盐

@RestController//相当于 @ResponseBody和 @Controller两个注释
@RequestMapping("/login")
public class LoginController {



    @Autowired
    private LoginService loginService;

    @Autowired
    private CheckExistService checkExistService;

    private static List rTip = new ArrayList();//list存储返回的信息 0 代表登陆失败--统一提示为用户名或密码从无，1代表登陆成功 -1代表用户不存在

    @RequestMapping(value = "/hello" ,method = RequestMethod.POST)
    public JSONObject hello(@RequestBody LoginModel loginModel) {

       // System.out.println("跨域请求成功" + loginModel.getUseracount()+"---"+loginModel.getPassword());
        LoginEnty loginEnty = new LoginEnty();
        JSONObject jsonObject = new JSONObject();
            //本次加密，使用用户账户 和 密码盐 对密码同时进行加密

            String useracount = loginModel.getUseracount(); //加密时的密文zffdsf
            String password = loginModel.getPassword(); //加密时的明文

            loginEnty.setUsercount(useracount); //获取到的用户账户，给用户实体类赋值

            LoginEnty login =  loginService.loginQuery(loginEnty);

             rTip  = checkExistService.checkUserIsEffective(login); //检查用户是否有效
             if(rTip == null){
                 String getPassword = PasswordUtil.decrypt(loginEnty.getPassword(),loginEnty.getUsercount(), loginEnty.getSalt()); //解密出的密码
                 if(getPassword.equals(password)){
                     rTip.add(0,"1");
                 }
             }

        jsonObject.put("data",rTip); //如果rTip 的0 位 为0 或 null 则为用户密码或用账户错误
        return jsonObject;
    }

    @Autowired
    private RegisterService registerService;


    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public JSONObject Register(@RequestBody RegisterModel registerModel){
        JSONObject jsonObject = new JSONObject();
        //获取随机的加密盐值
        byte[] salts = PasswordUtil.getStaticSalt();

        String salt = new String(salts);
        //调用加密方法 返回加密后的密文
        String ciphertext = PasswordUtil.entrcy(registerModel.getPassword(),registerModel.getUsercount(),salt);


        RegisterEnty registerEnty = new RegisterEnty();
        BeanUtils.copyProperties(registerModel,registerEnty);
        registerEnty.setSalt(salt);
        registerEnty.setPassword(ciphertext);
        registerService.Register(registerEnty);
//        Boolean aBoolean = checkExistService.queryExist(registerEnty);
//        if (aBoolean == true){
//            rTip.add(0,"-1"); //返回1代表该账号已经注册不可以注册
//            jsonObject.put("data",rTip);
//            return jsonObject;
//        }
//        registerService.Register(registerEnty);
//        rTip.add(0,"1");
//        jsonObject.put("data",rTip);
        return jsonObject;
    }
}

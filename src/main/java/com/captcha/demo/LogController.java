package com.captcha.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller

public class LogController {
@Autowired
ServiceCaptcha servicecaptcha;


    @RequestMapping(value="/captchaspring",method = RequestMethod.POST)
    public String afficher(@RequestParam("g-recaptcha-response") String captcha){
        Boolean x=servicecaptcha.verifiercaptcha(captcha);
        if(x==true) {
            System.out.println("reussi");
        }else {
            System.out.println("erreur");
        }
        return "index";
    }
}

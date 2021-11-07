package com.captcha.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCaptcha {
    @Autowired
    RestTemplate restT;

    public boolean verifiercaptcha(String captcha){
        String url= "https://www.google.com/recaptcha/api/siteverify";
        String params="?secret=key2&response="+captcha;
        String completeUrl=url+params;
        CaptchaResponse resp= restT.postForObject(completeUrl, null, CaptchaResponse.class);
        return resp.isSuccess();
    }
}

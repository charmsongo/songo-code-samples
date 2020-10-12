package cn.songo.strategydemo.impl;

import org.springframework.stereotype.Component;

/**
 * @Author SonGo
 * @Create 2020/8/6 17:22
 * @Description
 */
@Component
public class Cat implements Animal /*, InitializingBean*/ {


    @Override
    public void eat(String str) {
        System.out.println("cat eat yu, " + str);
    }

    @Override
    public void run(String str) {
        System.out.println("cat run, " + str);
    }

    //@Override
    //public void afterPropertiesSet() throws Exception {
    //    AnimalContext.registerService("cat",this);
    //}
}

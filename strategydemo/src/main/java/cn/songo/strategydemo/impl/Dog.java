package cn.songo.strategydemo.impl;

import org.springframework.stereotype.Component;

/**
 * @Author SonGo
 * @Create 2020/8/6 17:24
 * @Description
 */
@Component
public class Dog implements Animal /*, InitializingBean*/ {
    @Override
    public void eat(String str) {
        System.out.println("dog eat gutou, " + str);
    }

    @Override
    public void run(String str) {
        System.out.println("dog run," + str);
    }

    //@Override
    //public void afterPropertiesSet() throws Exception {
    //    AnimalContext.registerService("dog",this);
    //}
}

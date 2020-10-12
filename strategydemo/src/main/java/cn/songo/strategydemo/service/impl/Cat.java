package cn.songo.strategydemo.service.impl;

import cn.songo.strategydemo.context.AnimalContext;
import cn.songo.strategydemo.context.AnimalEnum;
import cn.songo.strategydemo.service.Animal;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author SonGo
 * @Create 2020/8/6 17:22
 * @Description 实现 InitializingBean ，便于 spring 容器时，初始化一次 afterPropertiesSet
 */
@Component
public class Cat implements Animal, InitializingBean {


    @Override
    public void eat(String str) {
        System.out.println("cat eat yu, " + str);
    }

    @Override
    public void run(String str) {
        System.out.println("cat run, " + str);
    }

    /**
     * 注册到策略模式维护的集合中
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        AnimalContext.registerService(AnimalEnum.CAT.getCode(),this);
    }
}

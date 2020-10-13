package cn.songo.strategydemo.service.impl;

import cn.songo.strategydemo.context.AnimalContext;
import cn.songo.strategydemo.context.AnimalEnum;
import cn.songo.strategydemo.service.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author SonGo
 * @Create 2020/8/6 17:22
 * @Description 实现 InitializingBean ，便于 spring 容器时，初始化一次 afterPropertiesSet
 *              在 afterPropertiesSet 方法中把当前策略具体实现类注册到策略中维护的 map 中
 */
@Component
public class Cat implements Animal, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(Cat.class);

    @Override
    public void eat(String str) {
        logger.info("cat eat yu, {}", str);
    }

    @Override
    public void run(String str) {
        logger.info("cat run, {}", str);
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

package cn.songo.strategydemo;

import cn.songo.strategydemo.context.AnimalEnum;
import cn.songo.strategydemo.context.AnimalRequest;
import cn.songo.strategydemo.controller.StrategyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StrategydemoApplicationTests {

    @Autowired
    StrategyController strategyController;

    @Test
    void contextLoads() {
        AnimalRequest animalRequest = new AnimalRequest();
        animalRequest.setCode(AnimalEnum.CAT.getCode());
        strategyController.hello(animalRequest);
    }

}

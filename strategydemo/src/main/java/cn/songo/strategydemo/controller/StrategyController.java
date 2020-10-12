package cn.songo.strategydemo.controller;

import cn.songo.strategydemo.context.AnimalContext;
import cn.songo.strategydemo.context.AnimalRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SonGo
 * @Create 2020/10/12 20:53
 * @Description
 */
@RestController
public class StrategyController {

    /**
     * http://localhost:8080/hello?code=01
     * @param animalRequest
     */
    @GetMapping("/hello")
    public void hello(AnimalRequest animalRequest) {
        AnimalContext animalContext = new AnimalContext(animalRequest.getCode());
        animalContext.eat("哈哈");
        animalContext.run("喜喜");
    }
}

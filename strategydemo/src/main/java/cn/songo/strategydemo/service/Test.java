package cn.songo.strategydemo.service;

import cn.songo.strategydemo.biz.AnimalContext;
import cn.songo.strategydemo.biz.AnimalEnum;

/**
 * @Author SonGo
 * @Create 2020/8/6 17:42
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        AnimalContext animalContext = new AnimalContext(AnimalEnum.DOG.getCode());
        animalContext.eat("哈哈");
        animalContext.run("喜喜");
    }
}

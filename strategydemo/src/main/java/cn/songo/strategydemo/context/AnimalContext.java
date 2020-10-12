package cn.songo.strategydemo.context;

import cn.songo.strategydemo.impl.Animal;
import cn.songo.strategydemo.impl.Cat;
import cn.songo.strategydemo.impl.Dog;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author SonGo
 * @Create 2020/8/6 17:28
 * @Description 策略+工厂
 */
//@Component
public class AnimalContext {

    private static Map<String, Animal> animalMap = new HashMap<String, Animal>();

    private Animal animal;
    //private ApplicationContext applicationContext;

    public AnimalContext(String type) {
        if (animalMap.size() == 0) {
            initMap();
        }

        if (StringUtils.isEmpty(type) || !animalMap.containsKey(type)) {
            System.out.println("type is error.");
        }

        animal = animalMap.get(type);
    }

    public void eat(String str) {
        animal.eat(str);
    }

    public void run(String string) {
        animal.run(string);
    }

    public static void registerService(String type, Animal animal) {
        animalMap.put(type, animal);
    }

    private void initMap() {
        animalMap.put(AnimalEnum.CAT.getCode(), new Cat());
        animalMap.put(AnimalEnum.DOG.getCode(), new Dog());
    }
}

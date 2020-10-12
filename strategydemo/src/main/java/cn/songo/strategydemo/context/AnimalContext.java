package cn.songo.strategydemo.context;

import cn.songo.strategydemo.service.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(AnimalContext.class);
    private static Map<String, Animal> animalMap = new HashMap<String, Animal>();

    private Animal animal;

    public AnimalContext(String type) {

        //此处判空，可以抛异常
        if (StringUtils.isEmpty(type) || !animalMap.containsKey(type)) {
            System.out.println("type is error.");
            return;
        }
        animal = animalMap.get(type);
    }

    /**
     * 策略 eat 方法
     * @param str
     */
    public void eat(String str) {
        animal.eat(str);
    }

    /**
     * 策略 run 方法
     * @param string
     */
    public void run(String string) {
        animal.run(string);
    }

    /**
     * 策略注册方法
     * @param type
     * @param animal
     */
    public static void registerService(String type, Animal animal) {
        animalMap.put(type, animal);
    }

}

package cn.songo.strategydemo.context;

import cn.songo.strategydemo.service.Animal;
import cn.songo.strategydemo.service.impl.Cat;
import cn.songo.strategydemo.service.impl.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author SonGo
 * @Create 2020/8/6 17:28
 * @Description 策略+工厂 (带 animalMap 自初始化注册 bean 版本)
 */
//@Component
public class AnimalContext {

    private static final Logger logger = LoggerFactory.getLogger(AnimalContext.class);
    private static Map<String, Animal> animalMap = new HashMap<String, Animal>();

    private Animal animal;

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        AnimalContext.applicationContext = applicationContext;
    }

    public AnimalContext(String type) {
        //正常启动 spring 容器，这里应该不会进行初始化，此处为了便于理解代码含义
        if (animalMap.size() == 0) {
            initMap();
            logger.info("策略模式维护集合初始化");
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

    /**
     * 在各自的实现类里面维护注册到策略模式维护的集合后，这里也要维护，含义相同
     */
    private void initMap() {
        //animalMap.put(AnimalEnum.CAT.getCode(), new Cat());
        //animalMap.put(AnimalEnum.DOG.getCode(), new Dog());

        animalMap.put(AnimalEnum.CAT.getCode(), applicationContext.getBean("cat", Cat.class));
        animalMap.put(AnimalEnum.CAT.getCode(),applicationContext.getBean("dog", Dog.class));

    }
}

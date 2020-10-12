package cn.songo.strategydemo;

import cn.songo.strategydemo.context.AnimalContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Strategydemo2Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Strategydemo2Application.class, args);
        //初始化时赋值
        AnimalContext.setApplicationContext(applicationContext);
    }

}

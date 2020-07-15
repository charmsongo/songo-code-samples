package com.songo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JavaCoreApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JavaCoreApplication.class, args);
        //如掉banner
        SpringApplicationBuilder builder = new SpringApplicationBuilder(JavaCoreApplication.class);
        SpringApplication build = builder.build();
        build.setBannerMode(Banner.Mode.OFF);
        build.run(args);
    }

}

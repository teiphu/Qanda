package com.teiphu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@EnableSwagger2
@MapperScan(basePackages = "com.teiphu.mapper")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class QandaApplication {

    private static ApplicationContext context;

    public static Map<Integer, NoticeTask> map = new HashMap<>();

    public static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(QandaApplication.class, args);
        /*context = SpringApplication.run(QandaApplication.class, args);
        displayAllBeans();*/
    }

    public static void displayAllBeans() {
        String[] allBeanNames = context.getBeanDefinitionNames();
        System.out.println("开始打印所有的对象————————————————————————————————");
        for (String beanName : allBeanNames) {
            //System.out.println(beanName);
            if ("redisConnectionFactory".equals(beanName)) {
                System.out.println(beanName);
            }
            /*if (beanName.equals("getDatabaseIdProvider")) {
                System.out.println(beanName);
                Object o = context.getBean(beanName);
                System.out.println(o.toString());
            }*/
        }
        System.out.println("结束打印所有的对象————————————————————————————————");
    }

}

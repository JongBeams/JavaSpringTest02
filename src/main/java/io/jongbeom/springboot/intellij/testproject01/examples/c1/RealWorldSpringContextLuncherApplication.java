package io.jongbeom.springboot.intellij.testproject01.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


//비즈니스 로직을 수행하는 서비스 클래스 예제 만들기

@Configuration
@ComponentScan
public class RealWorldSpringContextLuncherApplication {


    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(RealWorldSpringContextLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출


            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());

        }




    }
}

package io.jongbeom.springboot.intellij.testproject01.examples.h1;

import io.jongbeom.springboot.intellij.testproject01.game.gameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

//
//사전 작업 : src\main\resources\contextConfiguration.xml 파일 추가 및 코드 삽입

//contextConfiguration.xml에 bean 직접 추가(name, age)
//xml 파일에 io.jongbeom.springboot.intellij.testproject01.game 컴포넌트 스캔 직접 추가

public class XmlConfigurationContextLuncherApplication {


    public static void main(String[] args) {

        try(var context =
                    new ClassPathXmlApplicationContext("contextConfiguration.xml")){ 
            //스프링이 아닌 ClassPathXmlApplicationContext를 사용한 contextConfiguration.xml 파일로 컨텍스트 실행


            //Bean 목록 읽기
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            //Bean의 값 읽기
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            //xml로 Bean에 생성자 추가하여 실행
            context.getBean(gameRunner.class).run();

        }




    }
}

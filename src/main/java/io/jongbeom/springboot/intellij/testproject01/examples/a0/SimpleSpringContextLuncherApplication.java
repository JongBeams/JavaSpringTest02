package io.jongbeom.springboot.intellij.testproject01.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


//Configuration 클래스 파일 결합
@Configuration
//컴포넌트를 어떤 패키지에서 읽어야 할지 알려주는 어노테이션
@ComponentScan //("io.jongbeom.springboot.intellij.testproject01.examples.a1")
public class SimpleSpringContextLuncherApplication {


    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(SimpleSpringContextLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출


            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }




    }
}

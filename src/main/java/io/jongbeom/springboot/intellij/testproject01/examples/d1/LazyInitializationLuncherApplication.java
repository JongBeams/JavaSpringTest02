package io.jongbeom.springboot.intellij.testproject01.examples.d1;

import org.hibernate.sql.results.graph.Initializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

//Spring Bean은 즉시 초기화가 기본값이다.
@Component
@Lazy   //지연 초기화
class ClassB{

    ClassA classA;

    public ClassB(ClassA classA){

        // 로직
        System.out.println("Some Initailaization Logic");
        this.classA = classA;
    }

    public void  doSometing(){
        System.out.println("Do Something");
    }

}

@Configuration
@ComponentScan
public class LazyInitializationLuncherApplication {


    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(LazyInitializationLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출


            System.out.println("Initialization of context is completed ");

            //@Lazy 사용 시 사용하려 할때 로드됨 - Some Initailaization Logic 이시점에 출력됨
            //장점으로 실행 될 때 로드 하기때문에 오류의 위치를 확인하기 쉽다
            //자주 사용되지는 않는다.
            context.getBean(ClassB.class).doSometing();

            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }




    }
}

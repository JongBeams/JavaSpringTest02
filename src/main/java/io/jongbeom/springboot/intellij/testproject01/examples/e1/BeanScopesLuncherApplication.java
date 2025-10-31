package io.jongbeom.springboot.intellij.testproject01.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//기본적으로 Spring Framework에서 생성되는 모든 Bean은 싱글톤
//Spring 싱글톤은 스프링 IoC 컨테이너 당 객체 인스턴스 하나로 정의 (디자인 패턴 싱글톤과는 약간 다름)
@Component
class  NormalClass{

}

//스코프 타입은 프로토타입과 싱글턴 존재
//스코프 타입 프로토타입으로 설정 시 인스턴스로 생성
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{

}

//web-aware Application Context에서는 다른 타입 존재
// Request - https 요청당 객체 인스턴스 하나 생성
// Session - 사용자 https 세션당 객체 인스턴스 하나 생성
// Application - 웹 어플리케이션 전체에 객체 인스턴스 하나 생성
// Websocket - 웹 소켓 인스턴스 당 객체 인스턴스 하나 생성

@Configuration
@ComponentScan
public class BeanScopesLuncherApplication {

    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(BeanScopesLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출

            //특정 개체가 출력
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            //io.jongbeom.springboot.intellij.testproject01.examples.e1.NormalClass@47eaca72
            //io.jongbeom.springboot.intellij.testproject01.examples.e1.NormalClass@47eaca72

            //인스턴스 개체가 출력
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
//            io.jongbeom.springboot.intellij.testproject01.examples.e1.PrototypeClass@24313fcc
//            io.jongbeom.springboot.intellij.testproject01.examples.e1.PrototypeClass@7d20d0b
//            io.jongbeom.springboot.intellij.testproject01.examples.e1.PrototypeClass@77f1baf5


        }


    }
}

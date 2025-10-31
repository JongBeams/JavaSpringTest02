package io.jongbeom.springboot.intellij.testproject01.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("superContraGameQualifier")  //우선도 키워드를 지정해주지 않을 시 @Component 어노테이션에 의해 클래스 네임(superContraGame)으로 저장된다.
public class superContraGame implements GamingConsole {

    public  void up(){
        System.out.println("up");
    }

    public  void down(){
        System.out.println("Sit down");
    }

    public  void left(){
        System.out.println("Go Back");
    }

    public  void right(){
        System.out.println("Shoot a bullet!");
    }
}

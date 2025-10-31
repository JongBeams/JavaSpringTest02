package io.jongbeom.springboot.intellij.testproject01.game;

import org.springframework.stereotype.Component;

//@Component 어노테이션을 이용하면 Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다.
@Component
public class PacManGame implements GamingConsole {

    public  void up(){
        System.out.println("go up!");
    }

    public  void down(){
        System.out.println("go down!");
    }

    public  void left(){
        System.out.println("go left!");
    }

    public  void right(){
        System.out.println("go right!");
    }
}

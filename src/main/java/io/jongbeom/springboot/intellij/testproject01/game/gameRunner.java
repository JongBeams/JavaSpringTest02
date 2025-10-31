package io.jongbeom.springboot.intellij.testproject01.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//컴포넌트를 등록함으로써 메인 클래스에 따로 생성할 필요없음
@Component
public class gameRunner {

    //MarioGame game;
    GamingConsole game;

    public gameRunner(@Qualifier("superContraGameQualifier") GamingConsole game) {
        this.game =game;
    }

    public void run() {

        System.out.println("Running game : "+ game);
        game.up();
        game.down();
        game.left();
        game.right();

    }
}

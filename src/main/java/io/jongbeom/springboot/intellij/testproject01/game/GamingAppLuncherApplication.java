package io.jongbeom.springboot.intellij.testproject01.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


//Configuration 클래스 파일 결합
@Configuration
//컴포넌트를 어떤 패키지에서 읽어야 할지 알려주는 어노테이션
@ComponentScan("io.jongbeom.springboot.intellij.testproject01.game")
public class GamingAppLuncherApplication {

    //gamerunner 클래스에 @Component 어노테이션 생성으로 호출 필요 없어짐
    /*
    @Bean
    public gameRunner gamerunner(GamingConsole game){ //컴포넌트를 통해 bean으로 와이어링(객체간 연결)
        System.out.println("Parameter" + game);
        var gameRunner = new gameRunner(game);
        return gameRunner;
        //return new gameRunner(game);
    }
    */

    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(GamingAppLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출


            // @Component 어노테이션으로 자동 Bean으로 만들 때 첫글자는 소문자로 저장된다. MarioGame => marioGame
            System.out.println("Game List");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("------------");

            context.getBean(GamingConsole.class).up();

            context.getBean(gameRunner.class).run();
        }




    }
}

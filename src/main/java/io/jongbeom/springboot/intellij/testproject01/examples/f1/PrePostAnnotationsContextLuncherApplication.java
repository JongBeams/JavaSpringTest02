package io.jongbeom.springboot.intellij.testproject01.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//해당 클래스의 인스턴스에 모든 의존성을 연결하는대로 초기화 하기
@Component
class someClass{

    private SomeDependency someDependency;

    public someClass(SomeDependency someDependency){
        super();
        this.someDependency= someDependency;
        System.out.println("All dependencies are ready. 모든 의존성 완료");
    }


    //@PostConstruct 어노테이션 선언 시 해당 함수는 의존성을 연결하는대로 실행
    //의존성을 연결하는대로 초기화를 실행
    @PostConstruct
    public void  initialize(){
        //DB에서 데이터를 가져와 초기화 할 때 사용
        someDependency.getReady();  //초기화 코드
    }

    //@PreDestroy 어노테이션 선언 시 해당 함수는 어플리케이션 종료 전, 컨텍스트에서 Bean이 삭제되기 전 실행
    //보유하고 있던 리소스를 해제하는데 일반적으로 사용됨
    @PreDestroy
    public  void cleanup(){
        System.out.println("Cleanup");
    }

}

@Component
class SomeDependency{

    public void getReady() {

        System.out.println("Some logic using SomeDependency");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLuncherApplication {

    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(PrePostAnnotationsContextLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출


            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }




    }
}

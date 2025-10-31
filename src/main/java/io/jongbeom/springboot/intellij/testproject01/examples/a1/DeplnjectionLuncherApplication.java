package io.jongbeom.springboot.intellij.testproject01.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


//YourBusinessClass - 생성자 주입, 수정자 주입, 필드 주입
@Component
class YourBusinessClass{

    //필드 인젝션(주입)
    //@Autowired
    Dependency1 dependency1;

    //@Autowired
    Dependency2 dependency2;

    //컨스트럭쳐 인젝션
    //@Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor Injection -YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    /*
    //Setter 인젝션
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection -setDependency2");
        this.dependency2 = dependency2;
    }

    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection -setDependency1");
        this.dependency1 = dependency1;
    }
    */

    public String toString(){
        return "Using "+ dependency1+" and "+ dependency2;
    }
}

//Dependency1
@Component
class Dependency1{

}

//Dependency2
@Component
class Dependency2{

}



@Configuration
@ComponentScan //경로 미지정시 현재 패키지 스캔
public class DeplnjectionLuncherApplication {






    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(DeplnjectionLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출


            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));


        }




    }
}

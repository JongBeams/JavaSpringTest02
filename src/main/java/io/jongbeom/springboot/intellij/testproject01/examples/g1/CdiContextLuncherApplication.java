package io.jongbeom.springboot.intellij.testproject01.examples.g1;

import io.jongbeom.springboot.intellij.testproject01.examples.c1.DataService;
import jakarta.inject.Inject;
import jdk.jfr.Name;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Arrays;

//pom.xml에 해당 dependency 추가, 추가 시 jakarta 설치 진행
/*
        <dependency>
            <groupId>jakarta.inject</groupId>
            <artifactId>jakarta.inject-api</artifactId>
            <version>2.0.1</version>
        </dependency>
*/

@Component
// 자카르타 인젝트 기능 사용시 @Autowired 대신 @Inject사용 가능
// 이는 CDI 어노테이션으로 Spring 어노테이션을 대체하는 어노테이션
// 필요하진 않지만 알아는 두면 좋음
@Named
class  BusinessService{
    private DataService02 dataService;


    public DataService02 getDataService() {
        System.out.println("Setter Injection");
        return dataService;
    }

    //@Autowired
    @Inject
    public void setDataService(DataService02 dataService) {
        this.dataService = dataService;
    }
}


//@Component
@Named
class DataService02{

}


@Configuration
@ComponentScan
public class CdiContextLuncherApplication {


    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext(CdiContextLuncherApplication.class)){ //App03GamingSpringBeans로 Configuration 호출


            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }




    }
}

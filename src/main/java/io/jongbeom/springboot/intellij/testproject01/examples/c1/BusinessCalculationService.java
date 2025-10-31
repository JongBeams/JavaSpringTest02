package io.jongbeom.springboot.intellij.testproject01.examples.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service    //비즈니스 로직 정의에 사용
public class BusinessCalculationService {

    private DataService dataService;

    public BusinessCalculationService(DataService dataService){
        super();
        this.dataService =dataService;

    }


    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }


}

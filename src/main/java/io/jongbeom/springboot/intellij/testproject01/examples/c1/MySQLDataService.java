package io.jongbeom.springboot.intellij.testproject01.examples.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository //저장소로 DB와 상호 작용에 사용, MySQL과 통신하는 것이 목표
public class MySQLDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{1,2,3,4,5};
    }
}

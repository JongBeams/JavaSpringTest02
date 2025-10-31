package io.jongbeom.springboot.intellij.testproject01.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository //저장소로 DB와 상호 작용에 사용, mongoDB 와 통신하는 것이 목표
@Primary
public class MongodbDataService  implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[]{11,22,33,44,55};
    }
}

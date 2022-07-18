package springIOC.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QualifierService {
    @Autowired
    @RoundRobin
    private LoadBalance loadBalance;
    public void test() {
        System.out.println(loadBalance);
    }
}

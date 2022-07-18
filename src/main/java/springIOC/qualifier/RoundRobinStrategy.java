package springIOC.qualifier;

import org.springframework.stereotype.Component;

@Component
@RoundRobin
public class RoundRobinStrategy implements LoadBalance{
    @Override
    public String select() {
        return null;
    }
}

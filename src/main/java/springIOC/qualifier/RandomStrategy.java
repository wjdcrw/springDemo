package springIOC.qualifier;

import org.springframework.stereotype.Component;

@Component
@Random
public class RandomStrategy implements LoadBalance{
    @Override
    public String select() {
        return null;
    }
}

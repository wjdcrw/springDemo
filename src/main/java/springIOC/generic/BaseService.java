package springIOC.generic;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<O,S> {
    @Autowired
    protected O o;
    @Autowired
    protected S s;
}

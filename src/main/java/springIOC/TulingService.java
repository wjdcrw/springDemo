package springIOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName TulingService
 * @Description TODO
 * @Author duanc
 * @Date 2019/9/20 13:52
 * @Version 1.0
 **/
@Service
public class TulingService {
//    @Autowired
//    @Lazy
    private TulingDao tulingDao;

    public TulingDao getTulingDao() {
        return tulingDao;
    }
    @Autowired
    public void setTulingDao(TulingDao tulingDao) {
        this.tulingDao = tulingDao;
    }

    public void display(){
        tulingDao.a();
    }
}

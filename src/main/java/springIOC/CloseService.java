package springIOC;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Service;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/7/13 16:37
 */
@Service
public class CloseService implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("close AutoCloseable");
    }
}

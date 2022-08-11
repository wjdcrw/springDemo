package springIOC;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author duanc
 * @version 1.0
 * @description:
 * @date 2022/8/11 14:49
 */
@Component
public class DCRLifecycle implements SmartLifecycle {
    private boolean isRunning;
    @Override
    public void start() {
        System.out.println("启动");
        this.isRunning = true;
    }

    /**
     * // 要触发stop()，要调用context.close()，或者注册关闭钩子 context.registerShutdownHook();）
     */
    @Override
    public void stop() {
        System.out.println("停止");
        this.isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}

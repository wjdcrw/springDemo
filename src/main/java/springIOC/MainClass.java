package springIOC;

import factoryBean.Car;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MainAopClass
 * @Description
 * @Author duanc
 * @Date 2019/9/19 16:02
 * @Version 1.0
 **/
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        //手动发布一个事件
//        ctx.publishEvent(new ApplicationEvent("我手动发布了一个事件") {
//            @Override
//            public Object getSource() {
//                return super.getSource();
//            }
//        });

       // 容器关闭也发布事件
     //   ctx.close();
        System.out.println(ctx.getBean(TulingService.class));


    }
}

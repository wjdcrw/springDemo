package springIOC;

import factoryBean.Car;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springIOC.construct.ConstructA;
import springIOC.generic.OrderService;
import springIOC.generic.UserService;

/**
 * @ClassName MainAopClass
 * @Description
 * @Author duanc
 * @Date 2019/9/19 16:02
 * @Version 1.0
 **/
public class MainClass {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1(){
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
//        TulingService bean = ctx.getBean(TulingService.class);
        TulingService bean = (TulingService) ctx.getBean("tulingService");
//        TulingDao bean1 = ctx.getBean(TulingDao.class);
//        TulingDao bean2 = ctx.getBean(TulingDao.class);
        bean.display();
        System.out.println(bean);
        ctx.close();
    }

    public static void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        //ClassPathXmlApplicationContext context new ClassPathXmlApplicationContext("spring.xml");
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(ConstructA.class);
//        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(1,new OrderService());
        beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
        context.registerBeanDefinition("constructA",beanDefinition);
//        UserService userService = (UserService)context.getBean("userService",new OrderService(),new OrderService());
//        userService.test();

        ConstructA constructA = (ConstructA) context.getBean("constructA");
        System.out.println(constructA);
    }
}

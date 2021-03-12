package springAOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MainAopClass
 * @Description
 * @Author duanc
 * @Date 2019/9/19 16:02
 * @Version 1.0
 **/
public class MainAopClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        Calculate calculate=ctx.getBean(Calculate.class);
        System.out.println(calculate.add(2,3));
    }
}

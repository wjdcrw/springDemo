package springIOC;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author duanc
 * @version 1.0
 * @description: TODO
 * @date 2022/7/17 12:06
 */
public class Test {
    public void a(String abc){

    }
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test.class.getMethod("a", new Class[]{String.class});
        for(Parameter parameter:method.getParameters()){
            System.out.println(parameter.getName());
        }
    }
}

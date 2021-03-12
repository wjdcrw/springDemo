package spring_mybatis.factorybean;

import org.springframework.beans.factory.FactoryBean;
import spring_mybatis.anno.TulingSelect;
import spring_mybatis.dao.AccountMapper;
import spring_mybatis.entity.AccountInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TulingMapperFactoryBean<T> implements FactoryBean<T> {
    private Class<T> targetClass;

    public TulingMapperFactoryBean(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T getObject() throws Exception {
        return (T)Proxy.newProxyInstance(targetClass.getClassLoader(),new Class[]{targetClass},new TulingMapperProxy());
    }

    @Override
    public Class<?> getObjectType() {
        return targetClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

class TulingMapperProxy implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //处理Object原生的方法
        if(method.getDeclaringClass().equals(Object.class)){
            return method.invoke(this,args);
        }
        TulingSelect tulingSelect=method.getAnnotation(TulingSelect.class);
        String parseSql=tulingSelect.value();
        System.out.println("解析业务sql："+parseSql+"入参："+ Arrays.asList(args));
        Class<?> clazz=method.getReturnType();
        if(clazz.equals(AccountInfo.class)){
            return new AccountInfo();
        }
        return null;
    }
}

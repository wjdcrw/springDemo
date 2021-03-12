package spring_mybatis;

import org.springframework.context.annotation.Import;
import spring_mybatis.config.TulingClassPathMapperScanner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(value = TulingClassPathMapperScanner.class)
public @interface EnableMapperScanner {
}

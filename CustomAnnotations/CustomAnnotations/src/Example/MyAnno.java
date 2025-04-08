package Example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {        // if there are no parameters, we say it marker interface
    String name() default "default value";
    String city() default "default city";
    int age() default 18;

}

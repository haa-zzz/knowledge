package 注解Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//测试元注解
public class text01 {

    public static void main(String[] args) {

    }
}
@Target(value = {ElementType.METHOD,ElementType.ANNOTATION_TYPE})     //作用位置约束
@Retention(value = RetentionPolicy.RUNTIME)
@interface myAnnotation{

}

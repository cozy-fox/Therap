package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotateName {
    int maxLength() default 25;
    int minLength() default 5;
    String namePattern() default "[a-zA-z\\s]+[a-zA-z\\s]+";
}

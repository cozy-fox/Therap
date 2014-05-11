package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotateEmail {
    String emailPattern() default "[a-zA-z]+[a-zA-Z0-9]*@[a-zA-Z]+.[a-zA-Z]+";
}

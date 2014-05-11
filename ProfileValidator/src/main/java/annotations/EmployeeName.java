package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 7/24/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeName {
    int minLengthOfName() default 2;

    int maxLengthOfName() default 128;
}

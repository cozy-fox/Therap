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
public @interface WebAddress {
    String webAddressStartsWith() default "www.";

    String webAddressEndsWith() default "\\.(com|org|net|edu)";
}

package com.test;

import com.email.EmailBean;
import com.email.NameAnnotation;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmailTest extends TestCase {

    String name;

    @Before
    public void setUp() throws Exception {
        this.name = "sanjay";
    }

    @After
    public void tearDown() throws Exception {
        this.name = null;
    }

    @Test
    public void testName() throws Exception {
        EmailBean emailBean = new EmailBean(this.name);
        emailBean.setName("Nazrul");

        //Validator.validate(emailBean);


        Class classRef = emailBean.getClass();

        Field name = null;

        try {
            name = classRef.getDeclaredField("name");
            name.setAccessible(true);

            System.out.println(name);
            int minLength  = name.getAnnotation(NameAnnotation.class).minValue();
            int maxLength  = name.getAnnotation(NameAnnotation.class).maxValue();
            int nameLength = name.getName().length();

            if (nameLength > maxLength){
                System.out.println("\t More than the max value!");
            } else if (nameLength < minLength){
                System.out.println("\t Less than the min value!");
            } else {
                System.out.println("\t Okay value!");
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
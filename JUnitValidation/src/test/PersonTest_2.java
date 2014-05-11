package test;

import beans.Person;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonTest_2 extends TestCase {
    private String name;
    private int age;
    private String email;
    private String phone;
    private Person person;

    @Before
    public void setUp() throws Exception {
        this.name   = "Hasan Evan Sajid";
        this.age    = 18;
        this.email  = "11sanjaysaha@yahoo.com";
        this.phone  = "+88a01712758358";
        this.person = new Person(this.name, this.age, this.phone, this.email);
    }

    @After
    public void tearDown() throws Exception {
        this.name   = null;
        this.age    = 0;
        this.email  = null;
        this.phone  = null;
    }

    @Test
    public void testName() throws Exception {
        int returnValue = Validator.validateName(this.person, this.person.getClass());
        assertEquals("Name Checking Failed!", 1, returnValue);
    }

    @Test
    public void testAge() throws Exception {
        int returnValue = Validator.validateAge(this.person, this.person.getClass());
        assertEquals("Age Checking Failed!", -1, returnValue);
    }

    @Test
    public void testPhone() throws Exception {
        int returnValue = Validator.validatePhone(this.person, this.person.getClass());
        assertEquals("Phone Checking Failed!", -1, returnValue);
    }

    @Test
    public void testEmail() throws Exception {
        int returnValue = Validator.validateEmail(this.person, this.person.getClass());
        assertEquals("Email Check Failed!", -1, returnValue);
    }
}

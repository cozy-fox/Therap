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
public class PersonTest extends TestCase {
    private String name;
    private int age;
    private String email;
    private String phone;
    private Person person;

/*    PersonTest(String nameIn, int ageIn, String emailIn, String phoneIn){
        this.name   = nameIn;
        this.age    = ageIn;
        this.email  = emailIn;
        this.phone  = phoneIn;
    }*/


    @Before
    public void setUp() throws Exception {
        this.name   = null;
        this.age    = -1;
        this.email  = "sanjaysaha@yahoo.com";
        this.phone  = "";
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
        assertEquals("Name Checking Failed!", -1, returnValue);
    }

    @Test
    public void testNameIsNull() throws Exception {
        int returnValue = Validator.validateNull(this.person.getPersonName(), this.person.getClass());
        assertEquals("Name NULL Checking Failed!", 0, returnValue);
    }


    @Test
    public void testAge() throws Exception {
        int returnValue = Validator.validateAge(this.person, this.person.getClass());
        assertEquals("Age Checking Failed!", -1, returnValue);
    }

    @Test
    public void testAgeIsPositive() throws Exception {
        int returnValue = Validator.validatePositive(this.person.getAge(), this.person.getClass());
        assertEquals("Age POSITIVE Checking Failed!", 0, returnValue);
    }


    @Test
    public void testPhone() throws Exception {
        int returnValue = Validator.validatePhone(this.person, this.person.getClass());
        assertEquals("Phone Checking Failed!", -1, returnValue);
    }
    @Test
    public void testPhoneIsNull() throws Exception {
        int returnValue = Validator.validateNull(this.person.getPhone(), this.person.getClass());
        assertEquals("Phone NULL Checking Failed!", 0, returnValue);
    }

    @Test
    public void testEmail() throws Exception {
        int returnValue = Validator.validateEmail(this.person, this.person.getClass());
        assertEquals("Email Check Failed!", 1, returnValue);
    }
}

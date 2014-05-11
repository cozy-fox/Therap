package beans;

import annotations.*;
import com.sun.istack.internal.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    @NotNull
    @AnnotateName
    private String name  = null;

    @NotNull
    @AnnotateEmail
    private String email = null;

    @AllPositive
    @AnnotateAge
    private int age      = 0;

    @NotNull
    @AnnotatePhone
    private String phone = null;


    public Person(String nameIn, int ageIn, String phoneIn, String emailIn){
        this.name   = nameIn;
        this.age    = ageIn;
        this.phone  = phoneIn;
        this.email  = emailIn;
    }


    public String getPersonName(){
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
}

package test;

import annotations.AnnotateAge;
import annotations.AnnotateEmail;
import annotations.AnnotateName;
import annotations.AnnotatePhone;
import beans.Person;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Validator {

    public static int validateName(Person p, Class classRef) throws Exception {

        Field name = null;
        int retValue = 0;
        try {
            name = classRef.getDeclaredField("name");
            name.setAccessible(true);

            String personName = p.getPersonName();

            int minLength = name.getAnnotation(AnnotateName.class).minLength();
            int maxLength = name.getAnnotation(AnnotateName.class).maxLength();
            String namePattern = name.getAnnotation(AnnotateName.class).namePattern();

            if (personName == null) {
                retValue = -1;
            } else if (personName.length() < minLength || personName.length() > maxLength) {
                retValue = -1;
            } else if (!personName.matches(namePattern)) {
                retValue = -2;
            } else {
                retValue = 1;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retValue;
    }

    public static int validateNull(Object obj, Class classRef) {
        if (obj == null) {
            return 0;
        } else if (obj.toString() == "") {
            return 0;
        }
        return 1;
    }

    public static int validatePositive(Object obj, Class classRef) {
        if ((Integer) obj <= 0) return 0;
        return 1;
    }

    public static int validateAge(Person p, Class classRef) {
        int retVal = 0;
        try {
            classRef = p.getClass();
            Field age = null;
            age = classRef.getDeclaredField("age");
            age.setAccessible(true);

            int minAge = age.getAnnotation(AnnotateAge.class).minAge();
            int maxAge = age.getAnnotation(AnnotateAge.class).maxAge();

            int personAge = p.getAge();
            if (personAge < minAge || personAge > maxAge) {
                retVal = -1;
            } else {
                retVal = 1;
            }
        } catch (Exception e) {
            System.out.println(p);
        }
        return retVal;
    }

    public static int validateEmail(Person p, Class classRef) {
        int retVal = 0;
        try {
            classRef = p.getClass();
            Field email = null;
            email = classRef.getDeclaredField("email");
            email.setAccessible(true);

            String emailPattern = email.getAnnotation(AnnotateEmail.class).emailPattern();
            String personEmail = p.getEmail();


            if (personEmail == null) {
                retVal = 0;
            } else if (!personEmail.matches(emailPattern)) {
                retVal = -1;
            } else {
                retVal = 1;
            }
        } catch (Exception e) {
            System.out.println(p);
        }
        return retVal;
    }

    public static int validatePhone(Person p, Class classRef) {
        int retValue = 0;
        try {
            classRef = p.getClass();
            Field phone = null;
            phone = classRef.getDeclaredField("phone");
            phone.setAccessible(true);

            String phonePattern = phone.getAnnotation(AnnotatePhone.class).phonePattern();
            String personPhone = p.getPhone();

            if (!personPhone.matches(phonePattern)) {
                retValue = -1;
            } else {
                retValue = 1;
            }
        } catch (Exception e) {
            System.out.println(p);
        }
        return retValue;
    }
}

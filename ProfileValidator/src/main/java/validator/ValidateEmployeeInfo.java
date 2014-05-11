package validator;

/*
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 7/24/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */

import annotations.*;
import beans.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ValidateEmployeeInfo {
    private boolean isDebugOn;
    private ArrayList<Employee> employees;

    public ValidateEmployeeInfo(boolean isDebugOn, ArrayList<Employee> employees) {
        this.isDebugOn = isDebugOn;
        this.employees = employees;
    }

    /* class member validation */
    public void validateFields() {
        //if ( isDebugOn ) { listClassInfo(); }

        if (isDebugOn) {
            System.out.println("Validation Process Starts...");
        }

        for (Employee emp : employees) {
            Class refClass = emp.getClass();
            String refClassName = emp.getName();
            System.out.println("Name: " + refClassName);

            /* validate employee name */
            validateName(emp, refClass);

            /* validate employee age */
            validateAge(emp, refClass);

            /* validate phone number */
            validatePhoneNo(emp, refClass);

            /* validate email address */
            validateEmailAddress(emp, refClass);

            /* validate website address */
            validateWebAddress(emp, refClass);

            System.out.println();
        }
    }

    private void validateName(Employee emp, Class refClass) {
        Field employeeName = null;

        try {
            employeeName = refClass.getDeclaredField("name");
            employeeName.setAccessible(true);
            int minLengthOfName = employeeName.getAnnotation(EmployeeName.class).minLengthOfName();
            int maxLengthOfName = employeeName.getAnnotation(EmployeeName.class).maxLengthOfName();
            String empName = (String) employeeName.get(emp);

            String namePattern = "[a-zA-Z\\-'.\\s]+";
            if (!empName.matches(namePattern)) {
                System.out.println("\tInvalid name: " + empName);
            } else if (empName.length() < minLengthOfName) {
                System.out.println("\tName too short: " + empName);
            } else if (empName.length() > maxLengthOfName) {
                System.out.println("\tName too large: " + empName);
            } else {
                System.out.println("\tName is in correct format: " + empName);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateAge(Employee emp, Class refClass) {
        Field employeeAge = null;

        try {
            employeeAge = refClass.getDeclaredField("age");
            employeeAge.setAccessible(true);
            int minAge = employeeAge.getAnnotation(EmployeeAge.class).minAgeLimit();
            int maxAge = employeeAge.getAnnotation(EmployeeAge.class).maxAgeLimit();
            int empAge = employeeAge.getInt(emp);

            if (empAge < minAge) {
                System.out.println("\tUnder aged employee: " + empAge);
            } else if (empAge > maxAge) {
                System.out.println("\tOver aged employee: " + empAge);
            } else {
                System.out.println("\tAge Ok: " + empAge);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validatePhoneNo(Employee emp, Class refClass) {
        Field employeePhoneNo = null;

        try {
            employeePhoneNo = refClass.getDeclaredField("phoneNo");
            employeePhoneNo.setAccessible(true);
            String phoneNo = (String) employeePhoneNo.get(emp);
            int phoneNoLength = employeePhoneNo.getAnnotation(PhoneNumber.class).phoneNumberLength();
            String phoneNoPrefix = employeePhoneNo.getAnnotation(PhoneNumber.class).phoneNumberStartsWith();

            String phoneNoPattern = "\\" + phoneNoPrefix + "\\d{" + (phoneNoLength - phoneNoPrefix.length()) + "}";
            if (!phoneNo.matches(phoneNoPattern) || (phoneNo.length() != phoneNoLength)) {
                System.out.println("\tInvalid phone number: " + phoneNo);
            } else {
                System.out.println("\tPhone number is in correct format: " + phoneNo);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateEmailAddress(Employee emp, Class refClass) {
        Field employeeEmail = null;

        try {
            employeeEmail = refClass.getDeclaredField("emailID");
            employeeEmail.setAccessible(true);
            String emailAddress = (String) employeeEmail.get(emp);
            String emailEndsWith = employeeEmail.getAnnotation(EmailID.class).emailIDEndsWith();

            String emailPattern = "[0-9a-zA-Z]+[\\-_.]+[0-9a-zA-Z]+" + emailEndsWith;
            if (!emailAddress.matches(emailPattern)) {
                System.out.println("\tInvalid email address: " + emailAddress);
            } else {
                System.out.println("\tEmail address is valid: " + emailAddress);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateWebAddress(Employee emp, Class refClass) {
        Field employeeWeb = null;

        try {
            employeeWeb = refClass.getDeclaredField("webAddress");
            employeeWeb.setAccessible(true);
            String webAddress = (String) employeeWeb.get(emp);
            String webStartsWith = employeeWeb.getAnnotation(WebAddress.class).webAddressStartsWith();
            String webEndsWith = employeeWeb.getAnnotation(WebAddress.class).webAddressEndsWith();

            String webURLPattern = webStartsWith + "[0-9a-zA-Z]+" + "[0-9a-zA-Z\\-_.]+" + "[0-9a-zA-Z]+" + webEndsWith;
            if (!webAddress.matches(webURLPattern)) {
                System.out.println("\tInvalid website address: " + webAddress);
            } else {
                System.out.println("\tWebsite address is valid: " + webAddress);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* listing class information (testing reflection) */
    private void listClassInfo() {
        if (isDebugOn) {
            System.out.println("Listing Class Information...");
        }

        for (Employee emp : employees) {
            Class refClass = emp.getClass();
            String refClassName = emp.getName();
            System.out.println("Name: " + refClassName);

            /* listing declared method names */
            if (isDebugOn) {
                Method[] methods = refClass.getDeclaredMethods();
                for (Method m : methods) {
                    String methodName = m.getName();
                    System.out.println("\t" + methodName + "()");

                    /*listing individual method information */
                    System.out.println("\t\t" + "Return Type: " + m.getReturnType());
                    Class[] parameterTypes = m.getParameterTypes();
                    System.out.print("\t\t" + "Parameter List: ");
                    int paramCounter = 0;
                    for (Class p : parameterTypes) {
                        if (paramCounter == 0) {
                            System.out.print(p.getName());
                            ++paramCounter;
                        } else {
                            System.out.print(" ," + p.getName());
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}


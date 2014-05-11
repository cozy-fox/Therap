package beans;

import annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 7/24/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */

public class Employee {
    @EmployeeName
    private String name;
    @EmployeeAge
    private int age;
    @PhoneNumber
    private String phoneNo;
    @EmailID
    private String emailID;
    @WebAddress
    private String webAddress;


    public Employee(String name, int age, String phoneNo, String emailID, String webAddress) {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.emailID = emailID;
        this.webAddress = webAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

}

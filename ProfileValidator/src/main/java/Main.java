/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 7/25/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */

import beans.Employee;
import validator.ValidateEmployeeInfo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean flag = false;
        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Md. Mushfek-ur Rahman", 21, "+8801672428880", "mushfekur@therapservices.net", "www.demowebsite.com"));
        employees.add(new Employee("Saad", 15, "+8801676874415", "sk.saad@therapservices.net", "www.saadswebsite.net"));
        employees.add(new Employee("Raqib", 21, "+8801824695382", "_raqibul@therapservices.net", "www.iraqibul.com"));
        employees.add(new Employee("Rony", 21, "+880676763997", "manuel.@therapservices.net", "www.manuel.com"));
        employees.add(new Employee("Bibhash", 21, "+8801871658439", "bibhash_kar@therapservices.net", "www.bibhash.com"));
        employees.add(new Employee("Adam D'Angeleo", 35, "+8801546954439", "d-angeleo@therapservices.net", "www.quora.com"));
        employees.add(new Employee("Diptopol", 21, "+8801798746652", "dipto.pol@therapservices.net", "www.sust.edu"));

        ValidateEmployeeInfo validateInfo = new ValidateEmployeeInfo(flag, employees);
        validateInfo.validateFields();
    }
}

package datatypes;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/8/14
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class Developer implements Person, Comparable<Developer> {
    private String firstName    = "";
    private String lastName     = "";
    private String address      = "";
    private Integer experience  = 0;
    private Integer age         = 0;

    public Developer (String fName, String lName, String addr, Integer exp, Integer ageInput){
        this.firstName  = fName;
        this.lastName   = lName;
        this.address    = addr;
        this.experience = exp;
        this.age        = ageInput;
    }
    @Override
    public String getFirstName() {
        return firstName;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getLastName() {
        return lastName;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getAddress() {
        return address;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer getExperience() {
        return experience;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer getAge() {
        return age;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int compareTo(Developer o) {
        int compValue = 0;
        if ( (compValue = o.experience.compareTo(this.experience)) != 0){
            return compValue;
        }
        if ( (compValue = o.age.compareTo(this.age)) != 0){
            return compValue;
        }
        if ( (compValue = this.firstName.compareTo(o.firstName)) != 0){
            return compValue;
        }
        if ( (compValue = this.lastName.compareTo(o.lastName)) != 0){
            return compValue;
        }
        if ( (compValue = this.address.compareTo(o.address)) != 0){
            return compValue;
        }
        return compValue;
    }
}

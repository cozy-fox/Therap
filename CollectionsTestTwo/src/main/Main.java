package main;

import datatypes.Developer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Developer> developerList = new ArrayList<Developer>();

        developerList.add( new Developer("Sanjay", "Saha", "Kalabagan", 5, 22));
        developerList.add( new Developer("Sakhawat", "Hossain", "Shahbagh", 4, 23));
        developerList.add( new Developer("Imran", "Azad", "Shantinagar", 4, 23));
        developerList.add( new Developer("Imran", "Azad", "Adabor", 4, 23));
        developerList.add( new Developer("Rashedul", "Hasan", "Malibagh", 5, 23));


        Collections.sort(developerList);
        for (Developer developer: developerList){
            System.out.println(developer.getFirstName()+".."+developer.getLastName()+".."+developer.getAge()+".."+developer.getExperience()+".."+developer.getAddress());
        }


        int retValue = Collections.binarySearch(developerList, new Developer("Sakhawat", "Hossain", "Shahbagh", 4, 23));
        System.out.println(retValue);
    }
}

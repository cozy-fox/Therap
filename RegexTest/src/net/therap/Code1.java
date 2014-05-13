package net.therap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code1 {

    public static void main(String[] args) {
	    Pattern pattern = Pattern.compile("sanjay\\b");
        Matcher matcher = pattern.matcher("abcsanjay d sanjay +88 sanjay01712758358 abcdtusanjay8801711123456jty jyuj ");
        while(true) {
            System.out.println("abcd");
        }
    }
}

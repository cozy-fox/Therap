package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/6/14
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuessANumber implements Runnable
{
    private int number;
    public GuessANumber(int number)
    {
        this.number = number;
    }
    public void run()
    {
        int counter = 0;
        int guess = 0;
        do
        {
            guess = (int) (Math.random() * 100 + 1);
            System.out.println("This thread guesses " + guess);
            counter++;
        }while(guess != number);
        System.out.println("** Correct! " + "This thread" + " in " + counter + " guesses.**");
        while(true){
            System.out.println("abcd");}
    }


}
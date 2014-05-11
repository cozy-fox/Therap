package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 5/6/14
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayMessage implements Runnable
{
    private String message;
    public DisplayMessage(String message)
    {
        this.message = message;
    }
    public void run()
    {
        while(true)
        {
            System.out.println(message);
        }
    }
}
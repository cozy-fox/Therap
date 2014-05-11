package com.email;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/13/14
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmailBean {
    @NameAnnotation
    private String name;



    public EmailBean(String nm){
        this.name = nm;
    }

    public void setName(String nm){
        this.name = nm;
    }

    public String getMyName(){
        return this.name;
    }

}

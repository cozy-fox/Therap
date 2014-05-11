package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/10/14
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */


abstract class Button{
    public abstract void buttonOperation_1();
    public abstract void buttonOperation_2();
}
class WindowsButton extends Button{

    WindowsButton(String arg){
        System.out.println("WindowsButton created .. "+arg);
    }

    @Override
    public void buttonOperation_1() {
    }

    @Override
    public void buttonOperation_2() {
    }
}
class MotifButton extends Button{

    MotifButton(String arg){
        System.out.println("MotifButton created .. "+arg);
    }
    @Override
    public void buttonOperation_1() {
    }

    @Override
    public void buttonOperation_2() {
    }
}

abstract class TextField{
    public abstract void textFieldOperation_1();
    public abstract void textFieldnOperation_2();
}
class WindowsTextField extends TextField{

    WindowsTextField(String arg){
        System.out.println("WindowsTextField created .. "+arg);
    }

    @Override
    public void textFieldOperation_1() {
    }

    @Override
    public void textFieldnOperation_2() {
    }

}
class MotifTextField extends TextField{

    MotifTextField(String arg){
        System.out.println("MotifTextField created .. "+arg);
    }

    @Override
    public void textFieldOperation_1() {
    }

    @Override
    public void textFieldnOperation_2() {
    }

}

abstract class LookAndFeel{
    public abstract Button createButton();
    public abstract TextField createTextField();
}
class WindowsLookAndFeel extends LookAndFeel{
    @Override
    public Button createButton() {
        return new WindowsButton("from WindowsLookAndFeel");
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField("from WindowsLookAndFeel");
    }

}
class MotifLookAndFeel extends LookAndFeel{
    @Override
    public Button createButton() {
        return new MotifButton("from MotifLookAndFeel");
    }

    @Override
    public TextField createTextField() {
        return new MotifTextField("from MotifLookAndFeel");
    }

}

class FactoryCreator{
    private static LookAndFeel lookAndFeel = null;

    public static LookAndFeel getLookAndFeel(String arg){
        if (arg.equals("w")){
            lookAndFeel =  new WindowsLookAndFeel();
        } else if (arg.equals("m")){
            lookAndFeel = new MotifLookAndFeel();
        }
        return lookAndFeel;
    }
}

public class UIFactory {
    public static void main(String args[]){
        LookAndFeel lookAndFeelMain = FactoryCreator.getLookAndFeel("w");
        Button button = lookAndFeelMain.createButton();
    }

}

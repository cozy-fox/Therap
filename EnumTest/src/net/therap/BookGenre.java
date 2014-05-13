package net.therap;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/30/14
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
enum BookGenre{
    LITERATURE(11), THRILLER(13),  HISTORY(91);


    private int number;

    BookGenre(int num) {
        this.number = num;
    }

    public int getNumber() {
        return this.number;
    }
}
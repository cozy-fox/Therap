package com.collection;

/**
 * Created with IntelliJ IDEA.
 * User: sanjoy.saha
 * Date: 4/8/14
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Pair<L, R> implements Comparable<Pair<L, R>> {

    private final L left;
    private final R right;

    Pair(L l, R r){
        this.left  = l;
        this.right = r;
    }

    public R getRight() {
        return right;
    }

    public L getLeft() {
        return left;
    }


    @Override
    public int compareTo(Pair<L, R> o) {
        int cmpValue = compare(this.left, o.left);
        if (cmpValue == 0) return compare(this.right, o.right);
        else return cmpValue;
    }

    private int compare(Object o1, Object o2) {
        return  ((Comparable) o1).compareTo(o2);
    }
}

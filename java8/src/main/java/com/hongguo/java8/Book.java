package com.hongguo.java8;

/**
 * Book
 *
 * @author: chenghongguo
 * @date: 2019-07-23
 * @since 1.0.0
 */
public class Book {

    private boolean checkedOut = false;

    public Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        this.checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
    }

    public static void main(String[] args) {
        Book book = new Book(true);
        book.checkIn();

        new Book(true);
        System.gc();
    }
}

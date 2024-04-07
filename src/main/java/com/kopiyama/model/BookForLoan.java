package com.kopiyama.model;

public abstract class BookForLoan {
    protected String bookID;
    protected String title;
    protected Person author;
    protected double bookPrice;
    protected double bookLoanPrice;
    protected int stok;

    public BookForLoan() {
    }

    public BookForLoan(String bookID, String title, Person author, double bookPrice, double bookLoanPrice, int stok) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.bookPrice = bookPrice;
        this.bookLoanPrice = bookLoanPrice;
        this.stok = stok;
    }

    public abstract double calculateBookLoanPrice();


    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getBookLoanPrice() {
        return bookLoanPrice;
    }

    public void setBookLoanPrice(double bookLoanPrice) {
        this.bookLoanPrice = bookLoanPrice;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "BookForLoan{" +
                "bookID='" + getBookID() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author=" + getAuthor() +
                ", bookPrice=" + getBookPrice() +
                ", bookLoanPrice=" + bookLoanPrice +
                ", stok=" + getStok() +
                '}';
    }
}

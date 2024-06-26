package com.kopiyama.model;

public class Comic extends BookForLoan{
    private String genre;


    public Comic() {
    }

    public Comic(String bookID, String title, Person author, double bookPrice, double bookLoanPrice, int stok, String genre) {
        super(bookID, title, author, bookPrice, bookLoanPrice, stok);
        this.genre = genre;
        calculateBookLoanPrice();
    }

    @Override
    public double calculateBookLoanPrice() {
        double rateStockPercentage = getStok() < 10 ? 0.05 : 0.03;
        double rateBookType = 0.10;
        return (rateStockPercentage + rateBookType) * getBookPrice();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Comic :" + '\n' +
                "Book ID = " + getBookID() + '\n' +
                "Title = " + getTitle() + '\n' +
                "Author = " + getAuthor().getName() + '\n' +
                "Price = " + getBookPrice() + '\n' +
                "Loan Price = " + getBookLoanPrice() + '\n' +
                "Stok = " + getStok() + '\n' +
                "Genre = " + getGenre() + '\n';
    }
}

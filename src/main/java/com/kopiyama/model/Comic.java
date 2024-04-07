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
    public void calculateBookLoanPrice() {
        double rateStockPercentage;
        if (getStok() < 10) {
            rateStockPercentage = 0.05; // Persentase Harga Pinjam jika Stock < 10
        } else {
            rateStockPercentage = 0.03; // Persentase Harga Pinjam jika Stock >= 10
        }

        double rateBookType;
        if (this instanceof Comic) {
            rateBookType = 0.10; // Persentase Harga Pinjam untuk Comic
        } else {
            rateBookType = 0.0; // Default jika bukan Comic atau Novel
        }

        // Kalkulasi Harga Pinjam
        double loanPrice = (rateStockPercentage + rateBookType) * getBookPrice();
        setBookLoanPrice(loanPrice);

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

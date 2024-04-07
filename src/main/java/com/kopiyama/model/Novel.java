package com.kopiyama.model;

public class Novel extends BookForLoan{
    private boolean series;

    public Novel() {
    }

    public Novel(String bookID, String title, Person author, double bookPrice, double bookLoanPrice, int stok, boolean series) {
        super(bookID, title, author, bookPrice, bookLoanPrice, stok);
        this.series = series;
        calculateBookLoanPrice();
    }

    @Override
    public void calculateBookLoanPrice() {
        double rateStockPercentage;
        if (getStok() < 10) {
            rateStockPercentage = 0.05;
        } else {
            rateStockPercentage = 0.03;
        }

        double rateBookType;
        if (this instanceof Novel) {
            rateBookType = 0.05;
        } else {
            // Default rate jika jenis buku tidak diketahui
            rateBookType = 0.0;
        }

        double hargaPinjam = (rateStockPercentage + rateBookType) * getBookPrice();
        setBookLoanPrice(hargaPinjam);
    }

    public boolean isSeries() {
        return series;
    }

    public void setSeries(boolean series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Novel : " + '\n' +
                "Book ID = " + getBookID() + '\n' +
                "Title = " + getTitle() + '\n' +
                "Author = " + getAuthor().getName() + '\n' +
                "Price = " + getBookPrice() + '\n' +
                "Loan Price = " + getBookLoanPrice() + '\n' +
                "Stok = " + getStok() + '\n' +
                "Series = " + isSeries() + '\n';
    }
}

package com.kopiyama.model;

public class LoanBookOrder implements Loanable {
    private String loanID;
    private String bookID;
    private Member member;
    private BookForLoan loanBook;
    private int loanDuration;
    private double loanFee;

    public LoanBookOrder(String loanID, String bookID, Member member, BookForLoan loanBook, int loanDuration, double loanFee) {
        this.loanID = loanID;
        this.bookID = bookID;
        this.member = member;
        this.loanBook = loanBook;
        this.loanDuration = loanDuration;
        this.loanFee = loanFee;
    }

    @Override
    public void calculateLoanFee() {
        double bookLoanPrice = loanBook.getBookLoanPrice();
        this.loanFee = bookLoanPrice * loanDuration;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookForLoan getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(BookForLoan loanBook) {
        this.loanBook = loanBook;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public double getLoanFee() {
        return loanFee;
    }

    public void setLoanFee(double loanFee) {
        this.loanFee = loanFee;
    }

    // Getter dan setter lainnya sesuai kebutuhan

    @Override
    public String toString() {
        return "LoanBookOrder : " + '\n' +
                "loan ID = " + getLoanID() + '\n' +
                "Member = " + member.getName() + '\n' +
                "Book ID = " + getBookID() + '\n' +
                "Title = " + loanBook.getTitle() + '\n' +
                "Loan Book Price = " + loanBook.getBookLoanPrice() + '\n' +
                "Loan Duration = " + getLoanDuration() + '\n' +
                "Loan Fee = " + getLoanFee() + '\n';
    }
}

package com.kopiyama.model;

public class LoanBookOrder implements Loanable {
    private String loanID;
    private Member member;
    private BookForLoan loanBook;
    private int loanDuration;
    private double loanFee;

    public LoanBookOrder() {
    }

    public LoanBookOrder(String loanID, Member member, BookForLoan loanBook, int loanDuration) {
        this.loanID = loanID;
        this.member = member;
        this.loanBook = loanBook;
        this.loanDuration = loanDuration;
        this.loanFee = 0.0; // Awalnya set ke 0, akan dihitung nanti
        calculateLoanFee();
    }

    @Override
    public void calculateLoanFee() {
        double bookLoanPrice = loanBook.getBookLoanPrice();
        this.loanFee = bookLoanPrice * loanDuration;
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
                "loan ID = " + loanID + '\n' +
                "Member = " + member.getMemberID() + '\n' +
                "Loan Book = " + loanBook.getBookID() + '\n' +
                "Loan Duration = " + loanDuration + '\n' +
                "Loan Fee = " + loanFee + '\n';
    }
}

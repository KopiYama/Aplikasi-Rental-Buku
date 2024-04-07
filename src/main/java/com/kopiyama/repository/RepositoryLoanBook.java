package com.kopiyama.repository;

import com.kopiyama.model.*;

import java.util.ArrayList;
import java.util.List;

public class RepositoryLoanBook {
    private List<BookForLoan> loanBooks;

    public RepositoryLoanBook() {
        loanBooks = new ArrayList<>();

        initializeData();
    }

    public List<BookForLoan> getLoanBooks() {
        return loanBooks;
    }

    public void setLoanBooks(List<BookForLoan> loanBooks) {
        this.loanBooks = loanBooks;
    }

    private void initializeData() {
        //Member
        Member member1 = new Member("M-001", "Risman", "Bandung");
        Member member2 = new Member("M-002", "Budi", "Bandung");
        Member member3 = new Member("M-003", "Resti", "Kab. Bandung");

        //Mangaka
        Mangaka mangaka1 = new Mangaka("Masashi Kisimoto");
        Mangaka mangaka2 = new Mangaka("Yoshihiro Togashi");

        //Novelis
        Novelis novelis1 = new Novelis("J.K Rowling");
        Novelis novelis2 = new Novelis("Tere Liye");
        Novelis novelis3 = new Novelis("Dee Lestari");

        //Comic
        loanBooks.add(new Comic("Comic-001", "Uzumaki Naruto", mangaka1, 55000.0, 0.0, 10, "Shounen"));
        loanBooks.add(new Comic("Comic-002", "The Worst Client", mangaka1, 35000.0, 0.0, 20, "Shounen"));
        loanBooks.add(new Comic("Comic-003", "For the Sake of Dreams...!!", mangaka1, 35000.0, 0.0, 15, "Shounen"));
        loanBooks.add(new Comic("Comic-004", "Hunter X Hunter : The Day of Departure", mangaka2, 50000.0, 0.0, 15, "Fantasy"));
        loanBooks.add(new Comic("Comic-005", "Hunter X Hunter : A Struggle in the Mist", mangaka2, 80000.0, 0.0, 25, "Fantasy"));

        //Novel
        loanBooks.add(new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", novelis1, 150000.0, 0.0, 10, true));
        loanBooks.add(new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", novelis1, 150000.0, 0.0, 10, true));
        loanBooks.add(new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", novelis1, 200000.0, 0.0, 15, true));
        loanBooks.add(new Novel("Novel-004", "Ayah Aku Berbeda", novelis2, 35000.0, 0.0, 15, false));
        loanBooks.add(new Novel("Novel-005", "Madre", novelis3, 80000.0, 0.0, 10, false));
    }

    public List<BookForLoan> getAllLoanBooks() {
        return loanBooks;
    }
}

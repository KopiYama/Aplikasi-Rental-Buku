package com.kopiyama.repository;

import com.kopiyama.model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository {
    protected List<BookForLoan> loanBooks;

    public Repository() {
        loanBooks = new ArrayList<>();
        initializeData();
    }

    public List<BookForLoan> getAllLoanBooks() {
        return loanBooks;
    }

    protected abstract void initializeData();
}

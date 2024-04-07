package com.kopiyama.service;

import com.kopiyama.model.BookForLoan;

import java.util.List;

public interface DataAllBookService {
    public List<BookForLoan> findAllLoanBook();
}

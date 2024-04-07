package com.kopiyama.service.impl;

import com.kopiyama.model.BookForLoan;
import com.kopiyama.repository.RepositoryLoanBook;
import com.kopiyama.service.DataAllBookService;

import java.util.List;
import java.util.stream.Collectors;

public class DataAllBookServiceImpl implements DataAllBookService {

    private RepositoryLoanBook repositoryLoanBook;

    public DataAllBookServiceImpl(RepositoryLoanBook repositoryLoanBook) {
        this.repositoryLoanBook = repositoryLoanBook;
    }

    @Override
    public List<BookForLoan> findAllLoanBook() {
        return repositoryLoanBook.getAllLoanBooks().stream()
                .filter(book -> book.getStok() > 0)
                .collect(Collectors.toList());
    }
}

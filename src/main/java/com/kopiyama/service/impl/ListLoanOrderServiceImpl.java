package com.kopiyama.service.impl;

import com.kopiyama.model.LoanBookOrder;
import com.kopiyama.repository.RepositoryLoanBookOrder;
import com.kopiyama.service.ListLoanOrderService;
import com.kopiyama.view.print.PrintDisplay;

import java.util.List;

public class ListLoanOrderServiceImpl implements ListLoanOrderService {
    private RepositoryLoanBookOrder repositoryLoanBookOrder;
    private PrintDisplay printDisplay;

    public ListLoanOrderServiceImpl(RepositoryLoanBookOrder repositoryLoanBookOrder, PrintDisplay printDisplay) {
        this.repositoryLoanBookOrder = repositoryLoanBookOrder;
        this.printDisplay = printDisplay;
    }

    @Override
    public void listAllLoanOrders() {
        List<LoanBookOrder> loanBookOrders = repositoryLoanBookOrder.getAllLoanBookOrders();
        printDisplay.printAllLoanBookOrders(loanBookOrders);
    }
}

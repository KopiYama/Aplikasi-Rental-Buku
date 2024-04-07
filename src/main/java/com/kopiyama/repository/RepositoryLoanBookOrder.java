package com.kopiyama.repository;

import com.kopiyama.model.LoanBookOrder;

import java.util.ArrayList;
import java.util.List;

public class RepositoryLoanBookOrder {
    private List<LoanBookOrder> loanBookOrders;

    public RepositoryLoanBookOrder() {
        loanBookOrders = new ArrayList<>();
    }

    public void addLoanBookOrder(LoanBookOrder loanBookOrder) {
        loanBookOrders.add(loanBookOrder);
    }

    public List<LoanBookOrder> getAllLoanBookOrders() {
        return loanBookOrders;
    }
}

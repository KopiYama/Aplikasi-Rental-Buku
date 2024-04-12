package com.kopiyama.repository;

import com.kopiyama.model.LoanBookOrder;
import com.kopiyama.model.Member;

import java.util.ArrayList;
import java.util.List;

public class RepositoryLoanBookOrder {

    private List<Member> members;
    private List<LoanBookOrder> loanBookOrders;

    public RepositoryLoanBookOrder() {
        loanBookOrders = new ArrayList<>();
        members = new ArrayList<>();
        initializeMembers();
    }

    public void addLoanBookOrder(LoanBookOrder loanBookOrder) {
        loanBookOrders.add(loanBookOrder);
    }

    public List<LoanBookOrder> getAllLoanBookOrders() {
        return loanBookOrders;
    }

    private void initializeMembers() {
        members.add(new Member("M-001", "Risman", "Bandung"));
        members.add(new Member("M-002", "Budi", "Bandung"));
        members.add(new Member("M-003", "Resti", "Kab. Bandung"));
        members.add(new Member("M-004", "M.Rizky Andika", "Garut"));
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberID().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}

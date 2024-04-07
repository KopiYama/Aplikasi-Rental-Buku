package com.kopiyama.model;

public class Member extends Person{
    private String memberID;
    private String address;
    public Member() {
    }

    public Member(String memberID, String name, String address) {
        super(name);
        this.memberID = memberID;
        this.address = address;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return "Member : " + '\n' +
                "ID Member = " + getMemberID() + '\n' +
                "Name = " + getName() + '\n' +
                "Address = " + getAddress() + '\n';
    }
}

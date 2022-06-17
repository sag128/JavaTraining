package entity;


import net.bytebuddy.utility.RandomString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tbl_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isEmp() {
        return isEmp;
    }

    public void setEmp(boolean emp) {
        isEmp = emp;
    }

    public long getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(long membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    @Column(name = "membership_number")
    private long membershipNumber;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "is_emp")
    private boolean isEmp;




}

package com.example.JPAApplication.EmployeeEntity;

import javax.persistence.Embeddable;

@Embeddable
public class Salary {
    private int basicsalary;
    private int bonoussalary;
    private int taxamount;
    private int specialallowencesalary;

    public int getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(int basicsalary) {
        this.basicsalary = basicsalary;
    }

    public int getBonoussalary() {
        return bonoussalary;
    }

    public void setBonoussalary(int bonoussalary) {
        this.bonoussalary = bonoussalary;
    }

    public int getTaxamount() {
        return taxamount;
    }

    public void setTaxamount(int taxamount) {
        this.taxamount = taxamount;
    }

    public int getSpecialallowencesalary() {
        return specialallowencesalary;
    }

    public void setSpecialallowencesalary(int specialallowencesalary) {
        this.specialallowencesalary = specialallowencesalary;
    }
}

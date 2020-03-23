package net.proselyte.streamapi.model;

import java.math.BigDecimal;

public class Specialist {
    private String name;
    private BigDecimal salary;
    private Specialty specialty;

    public Specialist(String name, BigDecimal salary, Specialty specialty) {
        this.name = name;
        this.salary = salary;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", specialty=" + specialty +
                '}';
    }
}

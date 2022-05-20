package com.developer.thales.models;

public class Employee {
    private int id;
    private String name;
    private long salary;
    private int age;
    private String profileImage;

    private long annualSalary;

    public Employee() {
    }

    public Employee(int id, String name, long salary, int age, String profileImage, long annualSalary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.profileImage = profileImage;
        this.annualSalary = annualSalary;
    }

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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public long getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(long annualSalary) {
        this.annualSalary = annualSalary;
    }
}

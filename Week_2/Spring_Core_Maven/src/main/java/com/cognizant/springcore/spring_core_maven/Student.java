package com.cognizant.springcore.spring_core_maven;

public class Student {

    private Address address;

    public Student(Address address) {
        this.address = address;
        System.out.println("Student Bean Created");
    }

    public void display() {

        System.out.println("City : " + address.getCity());

    }

}
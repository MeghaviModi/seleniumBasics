package com.envision.openbrowsers.polymorphismConcept.ConstructorOverLoading;

import java.util.PrimitiveIterator;

public class Person {
    private String name="meghavi";
    private String LastName="Modi";
    private int age=24;
    public Person(String name,String LastName){
        this.name=name;
        this.LastName=LastName;

    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

}

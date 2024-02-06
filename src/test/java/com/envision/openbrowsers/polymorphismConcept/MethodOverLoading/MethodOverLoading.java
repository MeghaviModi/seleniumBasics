package com.envision.openbrowsers.polymorphismConcept.MethodOverLoading;

public class MethodOverLoading extends CompilTimePolymorphism {

    public void animal(){
        System.out.println("local animal");
    }
    public void animal(String... name){

    }

    public static void main(String[] args) {
        MethodOverLoading mo=new MethodOverLoading();
        mo.animal();
        System.out.println(mo);

    }
}

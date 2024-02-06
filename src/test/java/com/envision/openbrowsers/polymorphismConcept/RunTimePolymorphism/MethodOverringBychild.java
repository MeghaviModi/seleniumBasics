package com.envision.openbrowsers.polymorphismConcept.RunTimePolymorphism;

public class MethodOverringBychild extends MethodOverring {
    public String cookingClass(){
        System.out.println("List of cooking by child");
        return "";
    }
    public String indianFood(){
        System.out.println("Gujarati Food by child");
        return "";
    }

    public static void main(String[] args) {
        MethodOverring mo=new MethodOverringBychild();
        mo.cookingClass();
        mo.recipe();
        MethodOverringBychild mo2=new MethodOverringBychild();
        mo2.indianFood();
    }

}

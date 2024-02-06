package com.envision.openbrowsers.polymorphismConcept.MethodOverLoading;

public class CompilTimePolymorphism {



    //MethodOverLoading With same class
    public void animal(){
        System.out.println("wild animal ");
    }
    public void animal(String name){
        System.out.println("bird");
    }
    public static boolean animal(String name, String location){

        return false;
    }


}


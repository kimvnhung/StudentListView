package com.kimvan.hung.studentlistview;

import java.io.Serializable;

/**
 * Created by h on 09/08/2017.
 */

public class RowItem implements Serializable{
    private String name;
    private int age;
    private String adress;

    public RowItem(String name,int age,String adress){
        this.name = name;
        this.age = age;
        this.adress=adress;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }


    public String getName(){
        return this.name;
    }

    public String getAdress(){
        return this.adress;
    }
    public int getAge(){
        return this.age;
    }
}

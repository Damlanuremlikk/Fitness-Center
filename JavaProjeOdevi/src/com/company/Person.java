package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class Person {
    private String name,surname,password,birthDate,startDate;
    private int id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int createId(File file,int userID){
        try {
            Scanner reader=new Scanner(file);
            String line;
            String[] linesp;
            int id=userID;
            while (reader.hasNext()) {
                line=reader.nextLine();
                linesp=line.split("   ");
                if(Integer.parseInt(linesp[0])<(userID+999998)){
                    if(id<=Integer.parseInt(linesp[0])){                //buraya kucuktur yazmadığım için biraz sıkıntı olmuştu
                        id=(Integer.parseInt(linesp[0])+1);
                    }
                }
            }
            reader.close();
            return id;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return -1;
        }
    }

    public abstract boolean screen(Person user);
}

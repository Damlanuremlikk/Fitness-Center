package com.company;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Customer extends Person{
    private String customerType,finishDate;
    private int duration;
    private Double lenght,weight,bodyMassIndex;

    public String getCustomerType() {
        return customerType;
    }
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(String startDate,int duration) {          //degistirildi Date Class kullanıldı
        int dd,mm,yy;
        String[] str;
        str=startDate.split(",");
        Date date=new Date(Integer.parseInt(str[2]),Integer.parseInt(str[1])+duration,Integer.parseInt(str[0]));
        dd=date.getDay();
        mm=date.getMonth();
        yy=date.getYear();;
        this.finishDate=dd+","+mm+","+yy;
    }       //degistirildi (dogru bir hesaplama için Date Class kullanıldı)
    public Double getLenght() {
        return lenght;
    }
    public void setLenght(Double lenght) {
        this.lenght = lenght;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getBodyMassIndex() {
        return bodyMassIndex;
    }
    public void setBodyMassIndex() {
        this.bodyMassIndex = (this.weight)/(this.lenght*this.lenght);
    }

    public void printCustomerInformations(Customer user){
        System.out.println("Name:"+user.getName()+"  Surname:"+user.getSurname()+"  UserID:"+user.getId());
        System.out.println("Birth Date:"+user.getBirthDate()+"  Start Date:"+user.getStartDate()+"  password:"+user.getPassword());
        System.out.println("Member Type:"+user.getCustomerType()+"  Finish Date:"+user.getFinishDate());
        System.out.println("Lenght:"+user.getLenght()+"  Weight:"+user.getWeight()+"  Body Mass Index:"+user.getBodyMassIndex());
    }

    public void updateCustomerInformations(Customer user){
        System.out.println("Name:");
        String name=IntroScreen.scan.nextLine();
        System.out.println("Surname:");
        String surname = IntroScreen.scan.nextLine();
        System.out.println("Passworupd:");
        String password = IntroScreen.scan.nextLine();
        System.out.println("Birth Date");
        String birthDate = IntroScreen.scan.nextLine();
        System.out.println("Lenght:");
        double lenght = IntroScreen.scan.nextDouble();
        System.out.println("Weight:");
        double weight = IntroScreen.scan.nextDouble();
        String id=user.getId()+"";
        String line;
        String[] linesp;
        ArrayList<String> lines=new ArrayList<String>();
        try (Scanner reader = new Scanner(IntroScreen.customerstxt)) {
            while (reader.hasNext()) {
                line=reader.nextLine();
                linesp=line.split("   ");
                if(!id.equals(linesp[0])){
                    lines.add(line);
                }
            }
            reader.close();
            try {
                FileWriter usersWriter=new FileWriter(IntroScreen.customerstxt);
                for(String str:lines){
                    usersWriter.write(str+"\n");
                }
                usersWriter.close();
                lines.clear();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
            FileWriter fileWriter=new FileWriter(IntroScreen.customerstxt,true);
            fileWriter.write(user.getId()+"   "+password+"   "+name+"   "+surname+"   "+birthDate+"   "+user.getBirthDate()+"   "+user.getCustomerType()+"   "+user.getDuration()+"   "+lenght+"   "+weight+"   "+"\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setBirthDate(birthDate);
        user.setWeight(weight);
        user.setLenght(lenght);
        user.setBodyMassIndex();
    }
}

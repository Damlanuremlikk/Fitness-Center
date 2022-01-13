package com.company;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public abstract class Workers extends Person{
    private double salary;
    private String[] offDays;
    private int workOfficeCode;


    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String[] getOffDays() {
        return offDays;
    }
    public void setOffDays(String[] offDays) {
        this.offDays = offDays;
    }
    public int getWorkOfficeCode() {
        return workOfficeCode;
    }
    public void setWorkOfficeCode(int workOfficeCode) {
        this.workOfficeCode = workOfficeCode;
    }


    public void printWorkerInformations(Workers user){
        System.out.println("Name:"+user.getName()+"  Surname:"+user.getSurname()+"  UserID:"+user.getId());
        System.out.println("Birth Date:"+user.getBirthDate()+"  Start Date:"+user.getStartDate()+"  password:"+user.getPassword());
        System.out.print("Off Days:");
        for(String s:user.getOffDays()){
            System.out.print(s+"  ");
        }
        System.out.println();
        System.out.println("Working Code:"+user.getWorkOfficeCode()+"  Salary:"+user.getSalary());
    }

    public void updateWorkerInformations(Workers user){
        System.out.println("Name:");
        String name=IntroScreen.scan.nextLine();
        System.out.println("Surname:");
        String surname = IntroScreen.scan.nextLine();
        System.out.println("Password:");
        String password = IntroScreen.scan.nextLine();
        System.out.println("Birth Date");
        String birthDate = IntroScreen.scan.nextLine();
        String id=user.getId()+"";
        String line;
        String[] linesp;
        ArrayList<String> lines=new ArrayList<String>();
        try (Scanner reader = new Scanner(IntroScreen.workerstxt)) {
            while (reader.hasNext()) {
                line=reader.nextLine();
                linesp=line.split("   ");
                if(!id.equals(linesp[0])){
                    lines.add(line);
                }
            }
            reader.close();
            try {
                FileWriter usersWriter=new FileWriter(IntroScreen.workerstxt);
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

        StringJoiner offDaysJ=new StringJoiner(",");
        for(String s:user.getOffDays()){
            offDaysJ.add(s);
        }
        try {
            FileWriter fileWriter=new FileWriter(IntroScreen.workerstxt,true);
            fileWriter.write(user.getId()+"   "+password+"   "+name+"   "+surname+"   "+birthDate+"   "+user.getStartDate()+"   "+offDaysJ+"   "+user.getSalary()+"   "+user.getWorkOfficeCode()+"\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setBirthDate(birthDate);
    }
}

package com.company;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Director extends Registerer{

    public Director(String name, String surname, String password, String birthDate, String startDate, String[] offDays, Double salary,int workOfficeCode) {
        super(name, surname, password, birthDate, startDate, offDays, salary,workOfficeCode);

        for(String s:offDays) {
            if (!s.equalsIgnoreCase("sunday") && !s.equalsIgnoreCase("monday") && !s.equalsIgnoreCase("tuesday") &&
                    !s.equalsIgnoreCase("wednesday") && !s.equalsIgnoreCase("thursday") && !s.equalsIgnoreCase("friday") && !s.equalsIgnoreCase("saturday")) {
                System.out.println(s + " bir gun degildir..!");
                return;
            }
        }

        super.setName(name);
        super.setSurname(surname);
        super.setPassword(password);
        super.setBirthDate(birthDate);
        super.setStartDate(startDate);
        super.setOffDays(offDays);
        super.setSalary(salary);
        super.setWorkOfficeCode(workOfficeCode);
    }

    public boolean screen(Person user) {
        System.out.println("Choose an action:");
        IntroScreen.scan.hasNext();                                                     //bug önlemek için
        String action=IntroScreen.scan.nextLine();
        if(action.equalsIgnoreCase("exit")){
            System.out.println("Exiting...");
            return false;
        }else if(action.equalsIgnoreCase("Add Registerer")){
            addWorker(13000001);
            IntroScreen.takeLog(user.getId()+" Added Registerer");
        }else if(action.equalsIgnoreCase("Delete Registerer")){
            deleteWorker(13000001);
            IntroScreen.takeLog(user.getId()+" Deleted Registerer");
        }else if(action.equalsIgnoreCase("Add Trainer")){
            addWorker(14000001);
            IntroScreen.takeLog(user.getId()+" Added Trainer");
        }else if(action.equalsIgnoreCase("Delete Trainer")){
            deleteWorker(14000001);
            IntroScreen.takeLog(user.getId()+" Deleted Trainer");
        }else if(action.equalsIgnoreCase( "Add Cleaner")){
            addWorker(15000001);
            IntroScreen.takeLog(user.getId()+" Added Cleaner");
        }else if(action.equalsIgnoreCase("Delete Cleaner")){
            deleteWorker(15000001);
            IntroScreen.takeLog(user.getId()+" Deleted Cleaner");
        }else if(action.equalsIgnoreCase("Print my informations")){
            printWorkerInformations((Workers) user);
        }else if(action.equalsIgnoreCase("Update my informations")){
            updateWorkerInformations((Workers) user);
            IntroScreen.takeLog(user.getId()+" Updated Informations");
        }else if(action.equalsIgnoreCase("Print my actions")){
            printMyActions();
        }
        return true;
    }

    public void printMyActions(){                    //method override
        System.out.println("Exit");
        System.out.println("Add Register");
        System.out.println("Delete Registerer");
        System.out.println("Add Trainer");
        System.out.println("Delete Trainer");
        System.out.println("Add Cleaner");
        System.out.println("Delete Cleaner");
        System.out.println("Print my informations");
        System.out.println("Update my informations");
        System.out.println("Print my actions");
    }

    public void addWorker(int userID){
        System.out.println("Name:");
        String name=IntroScreen.scan.nextLine();
        System.out.println("Surname:");
        String surname=IntroScreen.scan.nextLine();
        System.out.println("Password:");
        String password=IntroScreen.scan.nextLine();
        System.out.println("Birth Date");
        String birthDate=IntroScreen.scan.nextLine();
        System.out.println("Start Date:");
        String startDate=IntroScreen.scan.nextLine();
        System.out.println("Off Days:");
        String offDaysLine;
        offDaysLine=IntroScreen.scan.nextLine();
        String[] offDays=offDaysLine.split(" ");
        System.out.println("Salary:");
        Double salary=IntroScreen.scan.nextDouble();
        System.out.println("Working Office Code:");
        int workOfficeCode=IntroScreen.scan.nextInt();
        Person worker;
        StringJoiner offDaysJ=new StringJoiner(",");
        for(String s:offDays){
            offDaysJ.add(s);
        }
        int id=userID/1000000;
        if (id==11){
            worker=new DirectorGeneral(name,surname,password,birthDate,startDate,offDays,salary,workOfficeCode);
        }else if(id==12){
            worker=new Director(name,surname,password,birthDate,startDate,offDays,salary,workOfficeCode);
        }else if(id==13){
            worker=new Registerer(name,surname,password,birthDate,startDate,offDays,salary,workOfficeCode);
        }else if(id==14){
            worker=new Trainer(name,surname,password,birthDate,startDate,offDays,salary,workOfficeCode);
        }else{
            worker=new Cleaner(name,surname,password,birthDate,startDate,offDays,salary,workOfficeCode);
        }
        worker.setId(worker.createId(IntroScreen.workerstxt,userID));
        try {
            FileWriter fileWriter=new FileWriter(IntroScreen.workerstxt,true);
            fileWriter.write(worker.getId()+"   "+password+"   "+name+"   "+surname+"   "+birthDate+"   "+startDate+"   "+offDaysJ+"   "+salary+"   "+workOfficeCode+"\n");
            fileWriter.close();
            System.out.println("worker added");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void deleteWorker(int userID){
        System.out.println("Enter id of worker:");
        String id=IntroScreen.scan.nextLine();
        if(Integer.parseInt(id)<userID||Integer.parseInt(id)>userID+999998){
            System.out.println("you cant delete this id from this menu");
            return;
        }

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
            try {
                FileWriter usersWriter=new FileWriter(IntroScreen.workerstxt);
                for(String str:lines){
                    usersWriter.write(str+"\n");
                }
                usersWriter.close();
                lines.clear();
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}

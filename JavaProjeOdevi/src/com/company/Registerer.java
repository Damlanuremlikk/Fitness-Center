package com.company;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Registerer extends Workers{

    public Registerer(String name,String surname,String password, String birthDate,String startDate,String[] offDays,Double salary,int workOfficeCode) {

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
        setWorkOfficeCode(workOfficeCode);
    }

    public boolean screen(Person user) {
        System.out.println("Choose an action:");
        IntroScreen.scan.hasNext();                                                     //bug önlemek için
        String action=IntroScreen.scan.nextLine();
        if(action.equalsIgnoreCase("exit")){
            System.out.println("Exiting...");
            return false;
        }else if(action.equalsIgnoreCase("Add Customer")){
            addCustomer();
            IntroScreen.takeLog(user.getId()+" Added Customer");
        }else if(action.equalsIgnoreCase("Delete Customer")){
            deleteCustomer();
            IntroScreen.takeLog(user.getId()+" Deleted Customer");
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

    public void printMyActions(){
        System.out.println("Exit");
        System.out.println("Add Customer");
        System.out.println("Delete Customer");
        System.out.println("Print my informations");
        System.out.println("Update my informations");
        System.out.println("Print my actions");
    }

    public void addCustomer() {
        System.out.println("Name:");
        String name = IntroScreen.scan.nextLine();
        System.out.println("Surname:");
        String surname = IntroScreen.scan.nextLine();
        System.out.println("Password:");
        String password = IntroScreen.scan.nextLine();
        System.out.println("Birth Date");
        String birthDate = IntroScreen.scan.nextLine();
        System.out.println("Start Date:");
        String startDate = IntroScreen.scan.nextLine();
        String customerType;
        do {
            System.out.println("Suctomer Type: (Gold/Standart/Economic)");
            customerType = IntroScreen.scan.nextLine();
        } while (!customerType.equalsIgnoreCase("gold") && !customerType.equalsIgnoreCase("standart") && !customerType.equalsIgnoreCase("economic"));
        System.out.println("Duration: (Mounth)");
        int duration = IntroScreen.scan.nextInt();
        System.out.println("Lenght:");
        double lenght = IntroScreen.scan.nextDouble();
        System.out.println("Weight:");
        double weight = IntroScreen.scan.nextDouble();
        Person customer;

        if (customerType.equalsIgnoreCase("gold")){
            customer =new CustomerGold(name,surname,password,birthDate,startDate,customerType,duration,lenght,weight);
            customer.setId(customer.createId(IntroScreen.customerstxt,21000001));
        }else if(customerType.equalsIgnoreCase("standart")){
            customer =new CustomerStandart(name,surname,password,birthDate,startDate,customerType,duration,lenght,weight);
            customer.setId(customer.createId(IntroScreen.customerstxt,22000001));
        }else{
            customer = new CustomerEconimoc(name,surname,password,birthDate,startDate,customerType,duration,lenght,weight);
            customer.setId(customer.createId(IntroScreen.customerstxt,23000001));
        }

        try {
            FileWriter fileWriter=new FileWriter(IntroScreen.customerstxt,true);
            fileWriter.write(customer.getId()+"   "+password+"   "+name+"   "+surname+"   "+birthDate+"   "+startDate+"   "+customerType+"   "+duration+"   "+lenght+"   "+weight+"   "+"\n");
            fileWriter.close();
            System.out.println("customer added");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void deleteCustomer(){
        System.out.println("Enter id of customer:");
        String id=IntroScreen.scan.nextLine();
        if(Long.parseLong(id)>=24000000||Long.parseLong(id)<21000001){
            System.out.println("this id cant belong to a customer");
            return;
        }

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
    }
}




package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IntroScreen {
    static Scanner scan=new Scanner(System.in);
    static File workerstxt=new File("C:\\JavaProjeOdevi\\src\\Workers.txt"); //File ı neden static tanımladık static  burda tek bir yerde çalışması için static yaptık
    static File customerstxt=new File("C:\\JavaProjeOdevi\\src\\Customers.txt");
    static File subofficestxt=new File("C:\\JavaProjeOdevi\\src\\SubOffices.txt");
    static File logstxt=new File("C:\\JavaProjeOdevi\\src\\Logs.txt");

    public static void main(String[] args) {
        System.out.println("Wellcome to Fitness Center\n");
        System.out.println("Please enter your ID and Password...\n");
        String password;
        int userID;
        do {
            System.out.println("UserID:");
            userID = scan.nextInt();
            System.out.println("Password:");
            password = scan.next();
        } while (!userLogin(userID, password));
        Person user=connectUser(userID);        //polymorphism
        user.setId(userID);

        System.out.println("Wellcome "+user.getName()+" "+user.getSurname());
        takeLog(user.getId()+" ["+user.getName()+" "+user.getSurname()+"] Logged in...");
        while(user.screen(user));    //////////

        return;
    }

    private static Boolean userLogin(int userID,String password){
        String line;
        String[] linesp;
        File[] files={workerstxt,customerstxt};
        for(File file:files){
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNext()) {
                    line=reader.nextLine();
                    linesp=line.split("   ");

                    if(userID==Integer.parseInt(linesp[0])){
                        if(password.equals(linesp[1])){
                            System.out.println("logining...");
                            return true;
                        }else{
                            System.out.println("incorrected password...");
                            return false;
                        }
                    }
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
                return false;
            }
        }
        System.out.println("incorrected id...");
        return false;
    }

    public static Person connectUser(int userID){
        int id=userID/1000000;
        String line;
        String[] linesp,offDays;
       if(id>10&&id<16){
           line=findUserLine(workerstxt,userID);
           linesp=line.split("   ");
           offDays=linesp[6].split(",");
           if (id==11){
               return new DirectorGeneral(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],offDays,Double.parseDouble(linesp[7]),Integer.parseInt(linesp[8]));
           }else if(id==12){
               return new Director(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],offDays,Double.parseDouble(linesp[7]),Integer.parseInt(linesp[8]));
           }else if(id==13){
               return new Registerer(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],offDays,Double.parseDouble(linesp[7]),Integer.parseInt(linesp[8]));
           }else if(id==14){
               return new Trainer(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],offDays,Double.parseDouble(linesp[7]),Integer.parseInt(linesp[8]));
           }else if(id==15) {
               return new Cleaner(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],offDays,Double.parseDouble(linesp[7]),Integer.parseInt(linesp[8]));
           }
        }else{
           line=findUserLine(customerstxt,userID);
           linesp=line.split("   ");
           if(id==21){
                return new CustomerGold(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],linesp[6],Integer.parseInt(linesp[7]),Double.parseDouble(linesp[8]),Double.parseDouble(linesp[9]));
           }else if(id==22){
                return new CustomerStandart(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],linesp[6],Integer.parseInt(linesp[7]),Double.parseDouble(linesp[8]),Double.parseDouble(linesp[9]));
           }else if(id==23){
                return new CustomerEconimoc(linesp[2],linesp[3],linesp[1],linesp[4],linesp[5],linesp[6],Integer.parseInt(linesp[7]),Double.parseDouble(linesp[8]),Double.parseDouble(linesp[9]));
           }
           else{
               System.out.println("invailed user id");
               return null;
           }
       }
       return null;
    }

    public static String findUserLine(File file,int userID){
        String line;
        String[] linesp;
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNext()) {
                line=reader.nextLine();
                linesp=line.split("   ");
                if(userID==Integer.parseInt(linesp[0])){
                    return line;
                }
            }
            reader.close();
            System.out.println("id coudnot find");
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void takeLog(String str){
        try {
            FileWriter fileWriter=new FileWriter(IntroScreen.logstxt,true);
            fileWriter.write(str+"\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

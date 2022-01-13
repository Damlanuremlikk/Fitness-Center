package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {

/*        Person musteri=new Customer("Damla","NUR","123qweqwe",100,0,2,120,0,2,"gold",13,175.0,62.0);
        Person musteri2=new Customer("Damla","NUR","123qweqwe",100,0,2,120,0,2,"gold",13,175.0,62.0);
        Person musteri3=new Customer("Damla","NUR","123qweqwe",100,0,2,120,0,2,"economic",13,175.0,62.0);
        Person musteri4=new Customer("Damla","NUR","123qweqwe",100,0,2,120,0,2,"aaaaaa",13,175.0,62.0);


        System.out.println(musteri.getStartDate());
        System.out.println(((Customer)musteri).getFinishDate());
        System.out.println(((Customer) musteri).getId());
        System.out.println(((Customer) musteri2).getId());
        System.out.println(((Customer) musteri3).getId());
        System.out.println(((Customer) musteri4).getId());*/


/*
        Person director=new Director("eyup","deniz","sifre",1990,01,06,2020,11,11, new String[]{"monday", "sunday"},2552.0);
        Person directorGeneral=new DirectorGeneral("eyup","deniz","sifre",1990,01,06,2020,11,11, new String[]{"monday", "sunday"},2552.0);

        for(String string:((Workers)directorGeneral).getOffDays()){
            System.out.println(string);
        }
        System.out.println(directorGeneral.getId());
*/      String line="general&&1000001 && ankara office && 0 && 8 && 8 && tavsantepe mahallesi Mustafa Kemal caddesi 2.sokak no:13";
        String[] linesp;
        linesp=line.split("&&");
        for (String s:linesp){
            System.out.println(s);
        }

    }
}


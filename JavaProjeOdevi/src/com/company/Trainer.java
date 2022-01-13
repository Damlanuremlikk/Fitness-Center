package com.company;

public class Trainer extends Workers{

    public Trainer(String name, String surname, String password, String birthDate, String startDate, String[] offDays, Double salary,int workOfficeCode) {

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
        System.out.println("Print my informations");
        System.out.println("Update my informations");
        System.out.println("Print my actions");
    }
}

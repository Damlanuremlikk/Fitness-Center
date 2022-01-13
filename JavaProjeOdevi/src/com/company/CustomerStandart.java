package com.company;

public class CustomerStandart extends Customer {
    CustomerStandart(String name, String surname, String password, String birthDate, String startDate, String customerType, int duration, Double lenght, Double weight) {
        String[] s = startDate.split(".");
        super.setName(name);
        super.setSurname(surname);
        super.setBirthDate(birthDate);
        super.setStartDate(startDate);
        super.setPassword(password);
        super.setFinishDate(startDate, duration);
        super.setCustomerType(customerType);
        super.setLenght(lenght);
        super.setWeight(weight);
        super.setDuration(duration);
        super.setBodyMassIndex();
    }

    public boolean screen(Person user) {
        System.out.println("Choose an action:");
        IntroScreen.scan.hasNext();                                                     //bug önlemek için
        String action=IntroScreen.scan.nextLine();
        if(action.equalsIgnoreCase("exit")){
            System.out.println("Exiting...");
            return false;
        }else if(action.equalsIgnoreCase("Print my informations")){
            printCustomerInformations((Customer) user);
        }else if(action.equalsIgnoreCase("Update my informations")){
            updateCustomerInformations((Customer) user);
            IntroScreen.takeLog(user.getId()+" Updated Informations");
        }else if(action.equalsIgnoreCase("Print my actions")){
            printMyActions();
        }
        return true;
    }

    public void printMyActions(){
        System.out.println("Exit");
        System.out.println("Print my informations");
        System.out.println("Update my informations");
        System.out.println("Print my actions");
    }
}
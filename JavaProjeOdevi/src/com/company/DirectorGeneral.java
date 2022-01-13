package com.company;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DirectorGeneral extends Director{

    public DirectorGeneral(String name, String surname, String password, String birthDate, String startDate, String[] offDays, Double salary,int workOfficeCode) {
        super(name, surname, password, birthDate, startDate, offDays, salary,workOfficeCode);
        for(String s:offDays){
            if(!s.equalsIgnoreCase("sunday")&&!s.equalsIgnoreCase("monday")&&!s.equalsIgnoreCase("tuesday")&&
                    !s.equalsIgnoreCase("wednesday")&&!s.equalsIgnoreCase("thursday")&&!s.equalsIgnoreCase("friday")&&!s.equalsIgnoreCase("saturday")){
                System.out.println(s+" bir gun degildir..!");
                return;
            }
        }

    }

    public boolean screen(Person user) {
        System.out.println("Choose an action:");
        IntroScreen.scan.hasNext();                                                     //bug önlemek için
        String action=IntroScreen.scan.nextLine();
        if(action.equalsIgnoreCase("exit")){
            System.out.println("Exiting...");
            return false;
        }else if(action.equalsIgnoreCase("Add Sub Office")){
            addSubOffice();
            IntroScreen.takeLog(user.getId()+" Added Sub Office");
        }else if(action.equalsIgnoreCase("Delete Sub Office")){
            deleteSubOffice();
            IntroScreen.takeLog(user.getId()+" Deleted Sub");
        }else if(action.equalsIgnoreCase("Add Director")){
            addWorker(12000001);
            IntroScreen.takeLog(user.getId()+" Added Director");
        }else if(action.equalsIgnoreCase("Delete Director")){
            deleteWorker(12000001);
            IntroScreen.takeLog(user.getId()+" Deleted Director");
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
        System.out.println("Add Sub Office");
        System.out.println("Delete Sub Office");
        System.out.println("Add Director");
        System.out.println("Delete Director");
        System.out.println("Print my informations");
        System.out.println("Update my informations");
        System.out.println("Print my actions");
    }

    public void addSubOffice(){
        System.out.println("Name of the Sub Office:");
        String name=IntroScreen.scan.nextLine();
        System.out.println("Number of Shower Room:");
        int showerRoomNuber=IntroScreen.scan.nextInt();
        System.out.println("Number of Toilet:");
        int toiletNumber=IntroScreen.scan.nextInt();
        System.out.println("Number of Wearing Room:");
        int wearingRoomNumber=IntroScreen.scan.nextInt();
        System.out.println("Enter an Address:");
        IntroScreen.scan.nextLine();                                           //bug
        String address=IntroScreen.scan.nextLine();

        SubOffice subOffice=new SubOffice(name,showerRoomNuber,toiletNumber,wearingRoomNumber,address);

        System.out.println("Do You Want to Set Swimming Pool? (y/yes=true, others=false)");
        String answer1=IntroScreen.scan.nextLine();
        if(answer1.equalsIgnoreCase("yes")||answer1.equalsIgnoreCase("y")){
            System.out.println("Type of Swimming Pool?");
            String type;
            type=IntroScreen.scan.nextLine();
            System.out.println("Max limit Swimming Pool?");
            int maxLimit=IntroScreen.scan.nextInt();
            subOffice.createSwimmingPool(type,maxLimit);
        }
        System.out.println("OK Than Lets Start Set Fitness Area...Enter count of those equipments...");
        subOffice.createFitness();
        System.out.println("Treadmill Number:");
        int treadmillNumber=IntroScreen.scan.nextInt();
        System.out.println("Vertical Bike Number:");
        int verticalBikeNumber=IntroScreen.scan.nextInt();
        System.out.println("Horizontal Bike Number:");
        int horizontalBikeNumber=IntroScreen.scan.nextInt();
        System.out.println("Elliptical Bike Number:");
        int ellipticalBikeNumber=IntroScreen.scan.nextInt();
        System.out.println("Climber Number:");
        int climberNumber=IntroScreen.scan.nextInt();
        System.out.println("Step Mill Number:");
        int stepMillNumber=IntroScreen.scan.nextInt();
        subOffice.fitness.createCardioEquipments(treadmillNumber,verticalBikeNumber,horizontalBikeNumber,ellipticalBikeNumber,climberNumber,stepMillNumber);
        System.out.println("Four Gym Station Number:");
        int fourGymStationNumber=IntroScreen.scan.nextInt();
        System.out.println("Sissy Squat Number:");
        int sissySquatNumber=IntroScreen.scan.nextInt();
        System.out.println("Olympic Adjustable Bench Number:");
        int olympicAdjustableBenchNumber=IntroScreen.scan.nextInt();
        System.out.println("EGlute Ham Devoloper Number:");
        int gluteHamDeveloperNumber=IntroScreen.scan.nextInt();
        System.out.println("Multi Power Number:");
        int multiPowerNumber=IntroScreen.scan.nextInt();
        System.out.println("Five Station Number:");
        int fiveStationNumber=IntroScreen.scan.nextInt();
        subOffice.fitness.createMultiFunctionEquipments(fourGymStationNumber,sissySquatNumber,olympicAdjustableBenchNumber,gluteHamDeveloperNumber,multiPowerNumber,fiveStationNumber);
        System.out.println("Chest Pres Corgemont Number:");
        int chestPresCorgemontNumber=IntroScreen.scan.nextInt();
        System.out.println("Lat Pulldown Convergent Number:");
        int latPulldownConvergentNumber=IntroScreen.scan.nextInt();
        System.out.println("Seated Leg Press Number:");
        int seatedLegPressNumber=IntroScreen.scan.nextInt();
        System.out.println("EFalt Banch Number:");
        int flatBanchNumber=IntroScreen.scan.nextInt();
        System.out.println("lat Pul Down Number:");
        int latPuldownNumber=IntroScreen.scan.nextInt();
        System.out.println("Olympic Flat Bacnh Number:");
        int olympicFlatBanchNumber=IntroScreen.scan.nextInt();
        subOffice.fitness.createStrenghtEquipments(chestPresCorgemontNumber,latPulldownConvergentNumber,seatedLegPressNumber,flatBanchNumber,latPuldownNumber,olympicFlatBanchNumber);
        System.out.println("Exercise Mat Number:");
        int exerciseMat=IntroScreen.scan.nextInt();
        System.out.println("Hexagon Dumball(5) Number:");
        int hexagonDumball5=IntroScreen.scan.nextInt();
        System.out.println("exagon Dumball(10)Number:");
        int hexagonDumball10=IntroScreen.scan.nextInt();
        System.out.println("exagon Dumball(20) Number:");
        int hexagonDumball20=IntroScreen.scan.nextInt();
        System.out.println("Kett Bell(10) Number:");
        int kettlebell10=IntroScreen.scan.nextInt();
        System.out.println("Kett Bell(20) Number:");
        int kettlebell20=IntroScreen.scan.nextInt();
        System.out.println("Kett Bell(30) Number:");
        int kettlebell30=IntroScreen.scan.nextInt();
        System.out.println("Elastic Band Number:");
        int elasticBand=IntroScreen.scan.nextInt();
        System.out.println("Jump Rope Number:");
        int jumpRope=IntroScreen.scan.nextInt();
        System.out.println("Wellness Ball Number:");
        int wellnessBall=IntroScreen.scan.nextInt();
        System.out.println("Balance PadNumber:");
        int balancePad=IntroScreen.scan.nextInt();
        subOffice.fitness.createOtherEquipments(exerciseMat,hexagonDumball5,hexagonDumball10,hexagonDumball20,kettlebell10,kettlebell20,kettlebell30,elasticBand,jumpRope,wellnessBall,balancePad);
        System.out.println("Fitness Area is OK\nHow many Team Working Room Do You Want to Add? (0=skip)");
        int teamWorkingRoomNumber=IntroScreen.scan.nextInt();
        for(int x=0;x<teamWorkingRoomNumber;x++){
            System.out.println("Max limit for Team Working Room"+(x+1));
            subOffice.createTeamWorkingRoom(IntroScreen.scan.nextInt());
        }
        subOffice.createSubOfficeID();
        //Bu noktadan sornası dosyaya kaydetme işlemi
        try {
            FileWriter subOfficeWriter=new FileWriter(IntroScreen.subofficestxt,true);
            subOfficeWriter.write("general"+" # "+subOffice.getSubOfficeID()+" # "+subOffice.getName()+" # "+subOffice.getShowerRoomNuber()+" # "+subOffice.getToiletNumber()+" # "+subOffice.getWearingRoomNumber()+" # "+subOffice.getAddress()+"\n");
            if(subOffice.swimmingPool!=null){
                subOfficeWriter.write("pool"+" # "+subOffice.swimmingPool.getType()+" # "+subOffice.swimmingPool.getMaxLimit()+"\n");
            }
            subOfficeWriter.write("cardio"+" # "+subOffice.fitness.cardioEquipments.getTreadmillNumber()+" # "+subOffice.fitness.cardioEquipments.getVerticalBikeNumber()+" # "+subOffice.fitness.cardioEquipments.getHorizontalBikeNumber()
                    +" # "+subOffice.fitness.cardioEquipments.getEllipticalBikeNumber()+" # "+subOffice.fitness.cardioEquipments.getClimberNumber()+" # "+subOffice.fitness.cardioEquipments.getStepMillNumber()+"\n");
            subOfficeWriter.write("multi"+" # "+subOffice.fitness.multiFunctionEquipments.getFourGymStationNumber()+" # "+subOffice.fitness.multiFunctionEquipments.getSissySquatNumber()+" # "+subOffice.fitness.multiFunctionEquipments.getOlympicAdjustableBenchNumber()
                    +" # "+subOffice.fitness.multiFunctionEquipments.getGluteHamDeveloperNumber()+" # "+subOffice.fitness.multiFunctionEquipments.getMultiPowerNumber()+" # "+subOffice.fitness.multiFunctionEquipments.getFiveStationNumber()+"\n");
            subOfficeWriter.write("strenght"+" # "+subOffice.fitness.strenghtEquipments.getChestPresCorgemontNumber()+" # "+subOffice.fitness.strenghtEquipments.getLatPuldownNumber()+" # "+subOffice.fitness.strenghtEquipments.getSeatedLegPressNumber()
                    +" # "+subOffice.fitness.strenghtEquipments.getFlatBanchNumber()+" # "+subOffice.fitness.strenghtEquipments.getLatPuldownNumber()+" # "+subOffice.fitness.strenghtEquipments.getOlympicFlatBanchNumber()+"\n");
            subOfficeWriter.write("other"+" # "+subOffice.fitness.otherEquipments.getExerciseMat()+" # "+subOffice.fitness.otherEquipments.getHexagonDumball5()+" # "+subOffice.fitness.otherEquipments.getHexagonDumball10()+" # "+subOffice.fitness.otherEquipments.getHexagonDumball20()
                    +" # "+subOffice.fitness.otherEquipments.getKettlebell10()+" # "+subOffice.fitness.otherEquipments.getKettlebell20()+" # "+subOffice.fitness.otherEquipments.getKettlebell30()+"||"+subOffice.fitness.otherEquipments.getElasticBand()
                    +" # "+subOffice.fitness.otherEquipments.getJumpRope()+" # "+subOffice.fitness.otherEquipments.getWellnessBall()+" # "+subOffice.fitness.otherEquipments.getBalancePad()+"\n");
            if (subOffice.teamWorkingRooms.size()>0){
                subOfficeWriter.write("team");
                for(int i=0;i<subOffice.teamWorkingRooms.size();i++){
                    subOfficeWriter.write(" # "+subOffice.teamWorkingRooms.get(i).getMaxLimit());
                }
                subOfficeWriter.write("\n");
            }
            subOfficeWriter.write("#######################################################################################################################\n");
            subOfficeWriter.close();
        } catch (IOException e) {
            System.out.println("subboffice dosyasina yazamadi");
            System.out.println(e);;
        }

    }

    public void deleteSubOffice(){
        System.out.println("Enter id of sub office:");
        String subOfficeID=IntroScreen.scan.nextLine();
        String line;
        String[] linesp;
        ArrayList<String> lines=new ArrayList<String>();

        try (Scanner reader = new Scanner(IntroScreen.subofficestxt)) {
            while (reader.hasNext()) {
                line=reader.nextLine();
                linesp=line.split(" # ");
                if(linesp[0].equals("general")&&linesp[1].equals(subOfficeID)){
                    while(!reader.nextLine().equals("#######################################################################################################################"));
                }else{
                    lines.add(line);
                }
            }
            reader.close();
            try {
                FileWriter usersWriter=new FileWriter(IntroScreen.subofficestxt);
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

package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SubOffice {
    SwimmingPool swimmingPool;
    Fitness fitness;
    private int subOfficeID,showerRoomNuber, toiletNumber,wearingRoomNumber;
    private String name,address;
    ArrayList<TeamWorkingRoom> teamWorkingRooms=new ArrayList<TeamWorkingRoom>();

    public SubOffice(String name,int showerRoomNumber, int toiletNumber, int wearingRoomNumber,String address) {
        this.name=name;
        this.toiletNumber = toiletNumber;
        this.wearingRoomNumber = wearingRoomNumber;
        this.address=address;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void createSwimmingPool(String type,int maxLimit){
        this.swimmingPool=new SwimmingPool(type,maxLimit);
    }
    public void createFitness(){
        this.fitness=new Fitness();
    }
    public void createTeamWorkingRoom(int maxLimit){
        this.teamWorkingRooms.add(new TeamWorkingRoom(maxLimit));
    }
    public void createSubOfficeID() {
        Scanner reader;
        try {
            reader = new Scanner(IntroScreen.subofficestxt);
            String line;
            String[] linesp;
            int id=1000001;
            while(reader.hasNext()){
                line=reader.nextLine();
                linesp=line.split(" # ");                               //split içine "||" yazma
                if(linesp[0].equalsIgnoreCase("general")){
                    if(id<=Integer.parseInt(linesp[1])){                    //yine aynı şekilde küçüktür işareti yakar!!!
                        id=(Integer.parseInt(linesp[1])+1);
                    }
                }
            }
            reader.close();
            this.subOfficeID = id;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getShowerRoomNuber() {
        return showerRoomNuber;
    }
    public void setShowerRoomNuber(int showerRoomNuber) {
        this.showerRoomNuber = showerRoomNuber;
    }
    public int getToiletNumber() {
        return toiletNumber;
    }
    public void setToiletNumber(int toiletNumber) {
        this.toiletNumber = toiletNumber;
    }
    public int getWearingRoomNumber() {
        return wearingRoomNumber;
    }
    public void setWearingRoomNumber(int wearingRoomNumber) {
        this.wearingRoomNumber = wearingRoomNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getSubOfficeID() {
        return subOfficeID;
    }

    //------------------------------------------------------------------------------------------------------------------
    public class SwimmingPool{
        private String type;
        private int maxLimit;

        public SwimmingPool(String type, int maxLimit) {
            this.type = type;
            this.maxLimit = maxLimit;
        }

        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public int getMaxLimit() {
            return maxLimit;
        }
        public void setMaxLimit(int maxLimit) {
            this.maxLimit = maxLimit;
        }
    }
    public class Fitness{
        CardioEquipments cardioEquipments;
        MultiFunctionEquipments multiFunctionEquipments;
        StrenghtEquipments strenghtEquipments;
        OtherEquipments otherEquipments;

        public void createCardioEquipments(int treadmillNumber, int verticalBikeNumber, int horizontalBikeNumber, int ellipticalBikeNumber, int climberNumber, int stepMillNumber){
            this.cardioEquipments=new CardioEquipments(treadmillNumber,verticalBikeNumber,horizontalBikeNumber,ellipticalBikeNumber,climberNumber,stepMillNumber);
        }
        public void createMultiFunctionEquipments(int fourGymStationNumber, int sissySquatNumber, int olympicAdjustableBenchNumber, int gluteHamDeveloperNumber, int multiPowerNumber, int fiveStationNumber){
            this.multiFunctionEquipments=new MultiFunctionEquipments(fourGymStationNumber,sissySquatNumber,olympicAdjustableBenchNumber,gluteHamDeveloperNumber,multiPowerNumber,fiveStationNumber);
        }
        public void createStrenghtEquipments(int chestPresCorgemontNumber, int latPulldownConvergentNumber, int seatedLegPressNumber, int flatBanchNumber, int latPuldownNumber, int olympicFlatBanchNumber){
            this.strenghtEquipments=new StrenghtEquipments(chestPresCorgemontNumber,latPulldownConvergentNumber,seatedLegPressNumber,flatBanchNumber,latPuldownNumber,olympicFlatBanchNumber);
        }
        public void createOtherEquipments(int exerciseMat, int hexagonDumball5, int hexagonDumball10, int hexagonDumball20, int kettlebell10, int kettlebell20, int kettlebell30, int elasticBand, int jumpRope, int wellnessBall, int balancePad){
            this.otherEquipments=new OtherEquipments(exerciseMat,hexagonDumball5,hexagonDumball10,hexagonDumball20,kettlebell10,kettlebell20,kettlebell30,elasticBand,jumpRope,wellnessBall,balancePad);
        }

        //--------------------------------------------------------------------------------------------------------------
        public class CardioEquipments{
            public int treadmillNumber,verticalBikeNumber,horizontalBikeNumber,ellipticalBikeNumber,climberNumber,stepMillNumber;

            public CardioEquipments(int treadmillNumber, int verticalBikeNumber, int horizontalBikeNumber, int ellipticalBikeNumber, int climberNumber, int stepMillNumber) {
                this.treadmillNumber = treadmillNumber;
                this.verticalBikeNumber = verticalBikeNumber;
                this.horizontalBikeNumber = horizontalBikeNumber;
                this.ellipticalBikeNumber = ellipticalBikeNumber;
                this.climberNumber = climberNumber;
                this.stepMillNumber = stepMillNumber;
            }

            public int getTreadmillNumber() {
                return treadmillNumber;
            }
            public void setTreadmillNumber(int treadmillNumber) {
                this.treadmillNumber = treadmillNumber;
            }
            public int getVerticalBikeNumber() {
                return verticalBikeNumber;
            }
            public void setVerticalBikeNumber(int verticalBikeNumber) {
                this.verticalBikeNumber = verticalBikeNumber;
            }
            public int getHorizontalBikeNumber() {
                return horizontalBikeNumber;
            }
            public void setHorizontalBikeNumber(int horizontalBikeNumber) {
                this.horizontalBikeNumber = horizontalBikeNumber;
            }
            public int getEllipticalBikeNumber() {
                return ellipticalBikeNumber;
            }
            public void setEllipticalBikeNumber(int ellipticalBikeNumber) {
                this.ellipticalBikeNumber = ellipticalBikeNumber;
            }
            public int getClimberNumber() {
                return climberNumber;
            }
            public void setClimberNumber(int climberNumber) {
                this.climberNumber = climberNumber;
            }
            public int getStepMillNumber() {
                return stepMillNumber;
            }
            public void setStepMillNumber(int stepMillNumber) {
                this.stepMillNumber = stepMillNumber;
            }
        }
        public class MultiFunctionEquipments{
            private int fourGymStationNumber,sissySquatNumber,olympicAdjustableBenchNumber,gluteHamDeveloperNumber,multiPowerNumber,fiveStationNumber;

            public MultiFunctionEquipments(int fourGymStationNumber, int sissySquatNumber, int olympicAdjustableBenchNumber, int gluteHamDeveloperNumber, int multiPowerNumber, int fiveStationNumber) {
                this.fourGymStationNumber = fourGymStationNumber;
                this.sissySquatNumber = sissySquatNumber;
                this.olympicAdjustableBenchNumber = olympicAdjustableBenchNumber;
                this.gluteHamDeveloperNumber = gluteHamDeveloperNumber;
                this.multiPowerNumber = multiPowerNumber;
                this.fiveStationNumber = fiveStationNumber;
            }

            public int getFourGymStationNumber() {
                return fourGymStationNumber;
            }
            public void setFourGymStationNumber(int fourGymStationNumber) {
                this.fourGymStationNumber = fourGymStationNumber;
            }
            public int getSissySquatNumber() {
                return sissySquatNumber;
            }
            public void setSissySquatNumber(int sissySquatNumber) {
                this.sissySquatNumber = sissySquatNumber;
            }
            public int getOlympicAdjustableBenchNumber() {
                return olympicAdjustableBenchNumber;
            }
            public void setOlympicAdjustableBenchNumber(int olympicAdjustableBenchNumber) {
                this.olympicAdjustableBenchNumber = olympicAdjustableBenchNumber;
            }
            public int getGluteHamDeveloperNumber() {
                return gluteHamDeveloperNumber;
            }
            public void setGluteHamDeveloperNumber(int gluteHamDeveloperNumber) {
                this.gluteHamDeveloperNumber = gluteHamDeveloperNumber;
            }
            public int getMultiPowerNumber() {
                return multiPowerNumber;
            }
            public void setMultiPowerNumber(int multiPowerNumber) {
                this.multiPowerNumber = multiPowerNumber;
            }
            public int getFiveStationNumber() {
                return fiveStationNumber;
            }
            public void setFiveStationNumber(int fiveStationNumber) {
                this.fiveStationNumber = fiveStationNumber;
            }
        }
        public class StrenghtEquipments{
            private int chestPresCorgemontNumber,latPulldownConvergentNumber,seatedLegPressNumber,flatBanchNumber,latPuldownNumber,olympicFlatBanchNumber;

            public StrenghtEquipments(int chestPresCorgemontNumber, int latPulldownConvergentNumber, int seatedLegPressNumber, int flatBanchNumber, int latPuldownNumber, int olympicFlatBanchNumber) {
                this.chestPresCorgemontNumber = chestPresCorgemontNumber;
                this.latPulldownConvergentNumber = latPulldownConvergentNumber;
                this.seatedLegPressNumber = seatedLegPressNumber;
                this.flatBanchNumber = flatBanchNumber;
                this.latPuldownNumber = latPuldownNumber;
                this.olympicFlatBanchNumber = olympicFlatBanchNumber;
            }

            public int getChestPresCorgemontNumber() {
                return chestPresCorgemontNumber;
            }
            public void setChestPresCorgemontNumber(int chestPresCorgemontNumber) {
                this.chestPresCorgemontNumber = chestPresCorgemontNumber;
            }
            public int getLatPulldownConvergentNumber() {
                return latPulldownConvergentNumber;
            }
            public void setLatPulldownConvergentNumber(int latPulldownConvergentNumber) {
                this.latPulldownConvergentNumber = latPulldownConvergentNumber;
            }
            public int getSeatedLegPressNumber() {
                return seatedLegPressNumber;
            }
            public void setSeatedLegPressNumber(int seatedLegPressNumber) {
                this.seatedLegPressNumber = seatedLegPressNumber;
            }
            public int getFlatBanchNumber() {
                return flatBanchNumber;
            }
            public void setFlatBanchNumber(int flatBanchNumber) {
                this.flatBanchNumber = flatBanchNumber;
            }
            public int getLatPuldownNumber() {
                return latPuldownNumber;
            }
            public void setLatPuldownNumber(int latPuldownNumber) {
                this.latPuldownNumber = latPuldownNumber;
            }
            public int getOlympicFlatBanchNumber() {
                return olympicFlatBanchNumber;
            }
            public void setOlympicFlatBanchNumber(int olympicFlatBanchNumber) {
                this.olympicFlatBanchNumber = olympicFlatBanchNumber;
            }
        }
        public class OtherEquipments{
            private int exerciseMat,hexagonDumball5,hexagonDumball10,hexagonDumball20,kettlebell10,kettlebell20,kettlebell30,elasticBand,jumpRope,wellnessBall,balancePad;

            public OtherEquipments(int exerciseMat, int hexagonDumball5, int hexagonDumball10, int hexagonDumball20, int kettlebell10, int kettlebell20, int kettlebell30, int elasticBand, int jumpRope, int wellnessBall, int balancePad) {
                this.exerciseMat = exerciseMat;
                this.hexagonDumball5 = hexagonDumball5;
                this.hexagonDumball10 = hexagonDumball10;
                this.hexagonDumball20 = hexagonDumball20;
                this.kettlebell10 = kettlebell10;
                this.kettlebell20 = kettlebell20;
                this.kettlebell30 = kettlebell30;
                this.elasticBand = elasticBand;
                this.jumpRope = jumpRope;
                this.wellnessBall = wellnessBall;
                this.balancePad = balancePad;
            }

            public int getExerciseMat() {
                return exerciseMat;
            }
            public void setExerciseMat(int exerciseMat) {
                this.exerciseMat = exerciseMat;
            }
            public int getHexagonDumball5() {
                return hexagonDumball5;
            }
            public void setHexagonDumball5(int hexagonDumball5) {
                this.hexagonDumball5 = hexagonDumball5;
            }
            public int getHexagonDumball10() {
                return hexagonDumball10;
            }
            public void setHexagonDumball10(int hexagonDumball10) {
                this.hexagonDumball10 = hexagonDumball10;
            }
            public int getHexagonDumball20() {
                return hexagonDumball20;
            }
            public void setHexagonDumball20(int hexagonDumball20) {
                this.hexagonDumball20 = hexagonDumball20;
            }
            public int getKettlebell10() {
                return kettlebell10;
            }
            public void setKettlebell10(int kettlebell10) {
                this.kettlebell10 = kettlebell10;
            }
            public int getKettlebell20() {
                return kettlebell20;
            }
            public void setKettlebell20(int kettlebell20) {
                this.kettlebell20 = kettlebell20;
            }
            public int getKettlebell30() {
                return kettlebell30;
            }
            public void setKettlebell30(int kettlebell30) {
                this.kettlebell30 = kettlebell30;
            }
            public int getElasticBand() {
                return elasticBand;
            }
            public void setElasticBand(int elasticBand) {
                this.elasticBand = elasticBand;
            }
            public int getJumpRope() {
                return jumpRope;
            }
            public void setJumpRope(int jumpRope) {
                this.jumpRope = jumpRope;
            }
            public int getWellnessBall() {
                return wellnessBall;
            }
            public void setWellnessBall(int wellnessBall) {
                this.wellnessBall = wellnessBall;
            }
            public int getBalancePad() {
                return balancePad;
            }
            public void setBalancePad(int balancePad) {
                this.balancePad = balancePad;
            }
        }
    }
    public class TeamWorkingRoom{
        private int maxLimit;

        public TeamWorkingRoom(int maxLimit) {
            this.maxLimit = maxLimit;
        }

        public int getMaxLimit() {
            return maxLimit;
        }
        public void setMaxLimit(int maxLimit) {
            this.maxLimit = maxLimit;
        }
    }
}

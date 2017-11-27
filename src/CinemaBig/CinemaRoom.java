package CinemaBig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaRoom {

    Scanner scanner;
    List<CinemaSeat> cinemaSeatList;

    private int normalSeatsAmount;
    private int vipSeatsAmount;
    private int costNormalSeats;
    private int costVipSeats;
    private int cash;
    private int howManyNormalTickets;
    private int howManyVipTickets;
    private int counterNormalFreeSeats;
    private int counterVipFreeSeats;

    public CinemaRoom(){
        scanner = new Scanner(System.in);
        cinemaSeatList = new ArrayList<>();
    }

    public void createCinemaRoom(){
        System.out.println("Hello !");
        System.out.println("At first we create cinema room");

        checkNormalSeatsAmount();

        checkNormalSeatsCost();

        checkVipSeatsAmount();

        checkVipSeatsCost();

        createSeats();
    }
    public void createSeats(){
        for(int i = 0; i<normalSeatsAmount; i++){
            cinemaSeatList.add(new CinemaSeat("Normal", costNormalSeats, true));
        }
        for(int i = normalSeatsAmount; i<vipSeatsAmount + normalSeatsAmount; i++){
            cinemaSeatList.add(new CinemaSeat("VIP", costVipSeats, true));
        }
    }
    public void checkNormalSeatsAmount(){
        boolean isGood = true;
        do{
            System.out.print("Type amount of normal seats: ");
            String normalSeatsAmountString = scanner.nextLine();

            try {
                normalSeatsAmount = Integer.parseInt(normalSeatsAmountString);
                this.normalSeatsAmount = normalSeatsAmount;

            } catch (NumberFormatException e) {
                System.out.println("Please type number");
                continue;
            }
            if(normalSeatsAmount > 0){
                isGood = false;
            }else {
                System.out.println("Type more than 0");
            }
        }while(isGood == true);

    }
    public void checkVipSeatsAmount(){
        boolean isGood = true;
        do {
            System.out.print("Type amount of VIP seats: ");
            String vipSeatsAmountString = scanner.nextLine();
            try {
                vipSeatsAmount = Integer.parseInt(vipSeatsAmountString);
                this.vipSeatsAmount = vipSeatsAmount;
            } catch (NumberFormatException e) {
                System.out.println("Please type number");
                continue;
            }
            if(vipSeatsAmount > 0){
                isGood = false;
            }else {
                System.out.println("Type more than 0");
            }
        }while(isGood == true);

    }
    public void checkNormalSeatsCost(){
        boolean isGood = true;
        do {
            System.out.print("Type cost of normal seat: ");
            String costNormalPlaceString = scanner.nextLine();
            try {
                costNormalSeats = Integer.parseInt(costNormalPlaceString);
                this.costNormalSeats = costNormalSeats;
            } catch (NumberFormatException e) {
                System.out.println("Please type number");
                continue;
            }
            if(costNormalSeats > 0){
                isGood = false;
            }else {
                System.out.println("Type more than 0");
            }
        }while(isGood == true);
    }
    public void checkVipSeatsCost(){
        boolean isGood = true;
        do {
            System.out.print("Type cost of VIP seat: ");
            String costVipPlaceString = scanner.nextLine();
            try {
                costVipSeats = Integer.parseInt(costVipPlaceString);
                this.costVipSeats = costVipSeats;
            } catch (NumberFormatException e) {
                System.out.println("Please type number");
                continue;
            }
            if(costVipSeats > 0){
                isGood = false;
            }else {
                System.out.println("Type more than 0");
            }
        }while(isGood == true);
    }

    public void showFreeSeats(){
        countFreeSeats();
        System.out.println("Free normal seats: " + counterNormalFreeSeats);
        System.out.println("Free Vip seats: " + counterVipFreeSeats);
    }
    public void countFreeSeats(){
        counterNormalFreeSeats = 0;
        counterVipFreeSeats = 0;
        for(CinemaSeat cinemaSeat : cinemaSeatList){
            if(cinemaSeat.getType().equalsIgnoreCase("Normal") && cinemaSeat.getIsFree() == true){
                counterNormalFreeSeats++;
            }
            if (cinemaSeat.getType().equalsIgnoreCase("VIP") && cinemaSeat.getIsFree() == true) {
                counterVipFreeSeats++;
            }
        }
    }
    public void sellNormalTickets(){

        checkHowManyNormalTickets();
        if(howManyNormalTickets <= normalSeatsAmount && howManyNormalTickets >0) {
            for (CinemaSeat cinemaSeat : cinemaSeatList) {
                if (cinemaSeat.getType().equalsIgnoreCase("Normal") && cinemaSeat.getIsFree() == true) {
                    cinemaSeat.setIsFree(false);
                    this.cash += costNormalSeats;
                    howManyNormalTickets--;
                    if (howManyNormalTickets == 0) {
                        break;
                    }
                }
            }
            System.out.println("You sold tickets");
        }else{
            System.out.println("You cannot type less than 1 and more than " + normalSeatsAmount);
        }
    }
    public void sellVipTickets(){
        checkHowManyVipTickets();
        if(howManyVipTickets <= vipSeatsAmount && howManyVipTickets > 0 ) {
            for (CinemaSeat cinemaSeat : cinemaSeatList) {
                if (cinemaSeat.getType().equalsIgnoreCase("VIP") && cinemaSeat.getIsFree() == true) {
                    cinemaSeat.setIsFree(false);
                    this.cash += costVipSeats;
                    howManyVipTickets--;
                    if (howManyVipTickets == 0) {
                        break;
                    }
                }
            }
            System.out.println("You sold tickets");
        }else{
            System.out.println("You cannot type less than 1 and more than " + vipSeatsAmount);
        }

    }
    public void checkHowManyNormalTickets(){
        boolean isGood = true;
        do {
            System.out.print("How many normal tickets: ");
            String howManyNormalTicketsString = scanner.nextLine();
            try {
                howManyNormalTickets = Integer.parseInt(howManyNormalTicketsString);
                this.howManyNormalTickets = howManyNormalTickets;
                isGood = false;
            } catch (NumberFormatException e) {
                System.out.println("Please type number");
            }
        }while(isGood == true);
    }
    public void checkHowManyVipTickets(){
        boolean isGood = true;
        do {
            System.out.print("How many normal tickets: ");
            String howManyVipTicketsString = scanner.nextLine();
            try {
                howManyVipTickets = Integer.parseInt(howManyVipTicketsString);
                this.howManyVipTickets = howManyVipTickets;
                isGood = false;
            } catch (NumberFormatException e) {
                System.out.println("Please type number");
            }
        }while(isGood == true);
    }
    public void cancelVipTicketPurchase(){
        checkHowManyVipTickets();
        int howMuchCanCancel = vipSeatsAmount - counterVipFreeSeats;
        if(howManyVipTickets <= howMuchCanCancel && howManyVipTickets >0) {
            for (CinemaSeat cinemaSeat : cinemaSeatList) {
                if (cinemaSeat.getType().equalsIgnoreCase("VIP") && cinemaSeat.getIsFree() == false) {
                    cinemaSeat.setIsFree(true);
                    this.cash -= costVipSeats;
                    howManyVipTickets--;
                    if (howManyVipTickets == 0) {
                        break;
                    }
                }
            }
            System.out.println("You cancelled tickets");
        }else{
            System.out.println("You cannot cancel less than 0 neither more tickets than you sold");
        }
    }
    public void cancelNormalTicketPurchase(){
        checkHowManyNormalTickets();
        int howMuchCanCancel = normalSeatsAmount - counterVipFreeSeats;
        if(howManyNormalTickets < howMuchCanCancel && howManyNormalTickets > 0) {
            for (CinemaSeat cinemaSeat : cinemaSeatList) {
                if (cinemaSeat.getType().equalsIgnoreCase("Normal") && cinemaSeat.getIsFree() == false) {
                    cinemaSeat.setIsFree(true);
                    this.cash -= costNormalSeats;
                    howManyNormalTickets--;
                    if (howManyNormalTickets == 0) {
                        break;
                    }
                }
            }
            System.out.println("You cancelled tickets");
        }else{
            System.out.println("You cannot cancel less than 0 neither more tickets than you sold");
        }
    }

    public void showCash(){
        System.out.println("Cash: " + cash);
    }
    public void showFreeSeatsValue(){
        countFreeSeats();
        System.out.println("Value of free normal seats: " + (counterNormalFreeSeats * costNormalSeats));
        System.out.println("Value of free VIP seats: " + (counterVipFreeSeats * costVipSeats));
    }
    public void clearCinemaRoom(){
        for(CinemaSeat cinemaSeat : cinemaSeatList){
            if (cinemaSeat.getType().equalsIgnoreCase("VIP") && cinemaSeat.getIsFree() == false) {
                cinemaSeat.setIsFree(true);
            }
            if(cinemaSeat.getType().equalsIgnoreCase("Normal") && cinemaSeat.getIsFree() == false){
                cinemaSeat.setIsFree(true);
            }
        }
    }
}

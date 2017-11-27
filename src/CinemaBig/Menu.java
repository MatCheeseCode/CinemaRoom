package CinemaBig;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private CinemaRoom cinemaRoom;

    private byte choice;

    public Menu(){
        cinemaRoom = new CinemaRoom();
        scanner = new Scanner(System.in);
    }

    public void showMenu(){
        cinemaRoom.createCinemaRoom();

        do{
            System.out.println();
            System.out.println("1. Show free seats");
            System.out.println("2. Sell tickets");
            System.out.println("3. Cancel ticket purchase");
            System.out.println("4. Show cash");
            System.out.println("5. Show value of free seats");
            System.out.println("6. Clear cinema room");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Type your choice: ");
            String choiceString = scanner.nextLine();

            try{
                this.choice = Byte.parseByte(choiceString);
            }catch(NumberFormatException e){
                System.out.println("Type only numbers from 1 to 6, or 9");
                continue;
            }
            if(choice > 0 && choice <7 || choice == 9 ) {

                switch (choice) {
                    case 1:
                        cinemaRoom.showFreeSeats();
                        break;
                    case 2:
                        System.out.println("Which ticket do you want to sell?");
                        System.out.println("1. Normal");
                        System.out.println("2. VIP");
                        System.out.println("0. Exit");
                        String choiceTypeSell = scanner.nextLine();
                        if (choiceTypeSell.equals("1")) {
                            cinemaRoom.sellNormalTickets();
                        } else if (choiceTypeSell.equals("2")) {
                            cinemaRoom.sellVipTickets();
                        }else if(choiceTypeSell.equals("0")){
                            continue;
                        } else {
                            System.out.println("Wrong choice");
                        }
                        break;
                    case 3:
                        System.out.println("Which ticket do you want to cancel?");
                        System.out.println("1. Normal");
                        System.out.println("2. VIP");
                        System.out.println("0. Exit");
                        String choiceTypeCancel = scanner.nextLine();
                        if (choiceTypeCancel.equals("1")) {
                            cinemaRoom.cancelNormalTicketPurchase();
                        } else if (choiceTypeCancel.equals("2")) {
                            cinemaRoom.cancelVipTicketPurchase();
                        } else if(choiceTypeCancel.equals("0")){
                            continue;
                        } else {
                            System.out.println("Wrong choice");
                        }
                        break;
                    case 4:
                        cinemaRoom.showCash();
                        break;
                    case 5:
                        cinemaRoom.showFreeSeatsValue();
                    case 6:
                        cinemaRoom.clearCinemaRoom();
                }
            }else{
                System.out.println("Type number from 1 to 6, or 9");
            }

        }while(choice != 9);
    }
}

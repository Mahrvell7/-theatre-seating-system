/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.theatre;

/**
 *
 * @author marvellous
 */
import java.sql.SQLOutput;
import java.util.Scanner;
public class Theatre {
    
    // seats array with available seats
     private static final boolean[][] seats = new boolean[][] {
                    {false, false, false, false, false, false,false, false, false, false, false, false},
                    {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                    {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
            };

    
    public static void main(String[] args) {
         // seats array with available seats
           

                // welcome message
                System.out.println("Welcome to the New Theatre");

                Scanner scanner = new Scanner(System.in);
                int option = -1;


                // menu loop with menu options
                while (option != 0) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Please select an option:");
                    System.out.println("1) Buy a ticket");
                    System.out.println("2) Print seating area");
                    System.out.println("3) Cancel ticket");
                    System.out.println("4) List available seats");
                    System.out.println("5) Save");
                    System.out.println("6) Load");
                    System.out.println("7) Print ticket information and total price");
                    System.out.println("8) Sort tickets by price");
                    System.out.println("0) Quit");
                    System.out.println("--------------------------------------------------------");


                    System.out.print("Enter option: ");
                    option = scanner.nextInt();

                    switch (option) {
                        // option 1 to buy a ticket
                        case 1:
                            buyTicket();
                            break;
                        case 2:
                            printSeatingArea();
                            break;
                        case 3: cancelTicket();
                            break;
                        case 4: listAvailableSeats();
                            break;
                        case 5: save();
                            break;
                        case 6: load();
                            break;
                        case 7: printTicketInformation();
                            break;
                        case 8:  sortTicketsByPrice();
                            break;
                        case 0:
                            System.out.println("Option 0 selected: Quit");
                            break;
                        default:
                            System.out.println("Invalid option selected");
                            break;
                    }
                }
            }
        public static void buyTicket() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter row number (from 1 to 3): ");
            int row = scanner.nextInt();

            while (row < 1 || row > 3) {
                System.out.println("Invalid row number");
                System.out.print("Enter row number (from 1 to 3): ");
                row = scanner.nextInt();
            }

            int maxSeats = seats[row-1].length;
            System.out.print("Enter seat number (1 to " + maxSeats + "): ");
            int seat = scanner.nextInt();

            while (seat < 1 || seat > maxSeats || seats[row-1][seat-1]) {
                if (seat < 1 || seat > maxSeats) {
                    System.out.println("Invalid seat number");
                } else {
                    System.out.println("Seat already occupied. Please choose a different seat");
                }

                System.out.print("Enter seat number ( from 1-" + maxSeats + "): ");
                seat = scanner.nextInt();
            }
            System.out.print("Enter the ticket price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter the person's name: ");
            String name = scanner.next();
            System.out.print("Enter the person's surname: ");
            String surname = scanner.next();
            System.out.print("Enter the person's email: ");
            String email = scanner.next();

           Person person = new Person(name, surname, email);
            Ticket ticket = new Ticket(row, seat, price, person);
          // Ticket.add(ticket);




            seats[row-1][seat-1] = true;
            System.out.println("Ticket bought successfully for seat " + seat + " in row " +row);
            System.out.println("  ");


        }
        public static void printSeatingArea() {
            System.out.println("\nSeating Area:");

            System.out.println("************");
            System.out.println("*   STAGE    *");
            System.out.println("************");

            // loop through each row of seats
            for (int i = 0; i < seats.length; i++) {

                // print the row number
                System.out.print("Row " + (i+1) + ": ");

                // loop through each seat in the row
                for (int j = 0; j < seats[i].length; j++) {

                    // if the seat is available, display 'O'
                    if (!seats[i][j]) {
                        System.out.print("O ");
                    }
                    // if the seat is sold, display 'X'
                    else {
                        System.out.print("X ");
                    }
                }

                // print a newline character to start the next row
                System.out.println(" ");

            }
        }

    public static void cancelTicket(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row number(1 to 3): ");
        int row  = scanner.nextInt();
        System.out.println("Enter your seat number: ");
        int seat = scanner.nextInt();

        //check if the seat and row are valid
        while (row < 1 || row >3 || seat < 1 || seat >seats[row - 1].length){
            System.out.println("Invalid row or seat number.");
            System.out.println("Enter row number(1 to 3): ");
            row = scanner.nextInt();
            System.out.println("Enter your seat number: ");
            seat = scanner.nextInt();
        }

        //check if seat is already sold
        if (seats[row - 1][seat - 1]){
            seats[row - 1][seat - 1] = false;
            System.out.println("Ticket for seat " + seat + " in row " + row + " cancelled successfully");
        }
        else{
            System.out.println("Seat " + seat + " in row " + row + " is not sold");
        }
    }


    public static void listAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i+1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                if (!seats[i][j]) {
                    System.out.print(j+1 + " ");
                }
            }
            System.out.println();
        }
    }
    public static void printTicketInformation() {
    System.out.println("Printing all tickets...");
     double totalPrice = 0;
//        for (Ticket ticket : Ticket) {
//            ticket.print();
//            totalPrice += ticket.getPrice();
//        }
       System.out.println("Total price of all tickets: £" + totalPrice);
 }

    public static void save() {
        System.out.println("Ticket saved");
    }

    public static void load() {
        System.out.println("Loading ticket saved");
    }


   public static void sortTicketsByPrice() {}
//        int[] prices = new int[seats.length * seats[0].length];
//        int k = 0;
//        for (int i = 0; i < seats.length; i++) {
//            for (int j = 0; j < seats[i].length; j++) {
//                if (seats[i][j]) {
//                    prices[k] = calculateTicketPrice(i+1);
//                    k++;
//                }
//            }}
//        Arrays.sort(prices);
//        System.out.println("Sorted ticket prices: ");
//        for (int price : prices) {
//            if (price != 0) {
//                System.out.println("$" + price);
//            }
//        }
  

}
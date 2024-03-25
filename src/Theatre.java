import java.io.*;
import java.util.*;

public class Theatre {
    // Create a Scanner for input user
    static Scanner scanner = new Scanner(System.in);

    // Initializing Array
    static char[] seat1 = new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
    static char[] seat2 = new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
    static char[] seat3 = new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};

    // Creating an ArrayList to save the ticket information
    static ArrayList<Ticket> ticketList = new ArrayList<>();

    public static void main(String[] args) {

        // Printing the welcome message
        System.out.println("Welcome to the new Theatre");

        // Printing Menu options
        while (true) {
            System.out.println("------------------------|Menu|-------------------------");
            System.out.println("1) Buying a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort ticket by price");
            System.out.println("    0) Quit");
            System.out.println("-------------------------------------------------------");

            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Thank you for using the Theatre program!");
                    break;
                }

                // Choosing menu option
                switch (choice) {
                    case 1 -> buy_ticket(); // Buying a ticket
                    case 2 -> print_seating_area(); // Implementing a seat area
                    case 3 -> cancel_ticket(); // Cancelling a ticket
                    case 4 -> show_available(); // Showing available seats
                    case 5 -> save(); // Implement save to file
                    case 6 -> load(); // Implement load from file
                    case 7 -> show_tickets_info(); // Implement print ticket information and total price
                    case 8 -> sort_tickets(); // Implement sort tickets by price
                    default -> System.out.println("Invalid choice. Please enter a number between 0 and 8."); // Error message if user inputs
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input, please enter an Integer");
            }
        }
    }

    // Creating a method to store and create a new ticket
    private static void buy_ticket() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter your surname: ");
        String surname = scanner.next();

        System.out.print("Enter your email: ");
        String email = scanner.next();

        // Creating an Object using the class Person
        Person person = new Person(name, surname, email);

        int seatNumber;
        int rowNumber;
        double price = 0;

        try {
            System.out.print("Enter a row number between 1-3: ");
            rowNumber = scanner.nextInt();

            if (rowNumber > 0 && rowNumber < 4) {
                if (rowNumber == 1) {

                    System.out.print("Enter seat number between 1-12: ");
                    seatNumber = scanner.nextInt();

                    if (seatNumber > 0 && seatNumber < 13) {
                        if (seat1[seatNumber - 1] == 'X') {
                            System.out.println("Ticket already booked.");
                        } else {
                            seat1[seatNumber - 1] = 'X';
                            System.out.println("Ticket Booked");
                            System.out.println(Arrays.toString(seat1));
                            price = 30;
                        }
                    }
                } else if (rowNumber == 2) {

                    System.out.print("Enter seat number between 1-16: ");
                    seatNumber = scanner.nextInt();

                    if (seatNumber > 0 && seatNumber < 17) {
                        if (seat2[seatNumber - 1] == 'X') {
                            System.out.println("Ticket already booked.");
                        } else {
                            seat2[seatNumber - 1] = 'X';
                            System.out.println("Ticket Booked");
                            System.out.println(Arrays.toString(seat2));
                            price = 20;
                        }
                    }
                } else {

                    System.out.print("Enter seat number between 1-20: ");
                    seatNumber = scanner.nextInt();

                    if (seatNumber > 0 && seatNumber < 21) {
                        if (seat3[seatNumber - 1] == 'X') {
                            System.out.println("Ticket already booked.");
                        } else {
                            seat3[seatNumber - 1] = 'X';
                            System.out.println("Ticket Booked");
                            System.out.println(Arrays.toString(seat3));
                            price = 10;
                        }
                    }
                }
                // Initializing ArrayList
                Ticket ticket = new Ticket(rowNumber, seatNumber, price, person);
                ticketList.add(ticket);
            } else {
                System.out.println("This row number does not exist. Please select 1-3.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input. Please enter an Integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Seat out of bound.");
        }
    }

    // Creating a method to print the seating areas
    private static void print_seating_area() {

        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");
        System.out.println("     ***********");

        System.out.print("    ");
        for (int i = 0; i < seat1.length; i++) {
            if (i == seat1.length / 2) System.out.print(" ");
            System.out.print(seat1[i]);
        }
        System.out.println();

        System.out.print("  ");
        for (int i = 0; i < seat2.length; i++) {
            if (i == seat2.length / 2) System.out.print(" ");
            System.out.print(seat2[i]);
        }
        System.out.println();
        for (int i = 0; i < seat3.length; i++) {
            if (i == seat3.length / 2) System.out.print(" ");
            System.out.print(seat3[i]);
        }
        System.out.println();
    }

    // Creating a method to Cancel tickets
    private static void cancel_ticket() {
        // Getting input from user
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a row number between 1-3: ");
            int rowNumber = scanner.nextInt();

            if (rowNumber > 0 && rowNumber < 4) {
                System.out.print("Enter seat number: ");
                int seatNumber = scanner.nextInt();
                System.out.println();

                if (rowNumber == 1) {
                    if (seatNumber > 0 && seatNumber < 13) {
                        seat1[seatNumber - 1] = '0';
                        System.out.println(Arrays.toString(seat1));
                    }
                    if (seat1[seatNumber - 1] == '0') {
                        System.out.println("Ticket cancelled.");
                        ticket_remover(rowNumber, seatNumber);
                    } else {
                        System.out.println("Invalid seat number");
                    }
                } else if (rowNumber == 2) {
                    if (seatNumber > 0 && seatNumber < 17) {
                        seat2[seatNumber - 1] = '0';
                        System.out.println(Arrays.toString(seat2));
                    }
                    if (seat2[seatNumber - 1] == '0') {
                        System.out.println("Ticket cancelled.");
                        ticket_remover(rowNumber, seatNumber);
                    } else {
                        System.out.println("Invalid seat number");
                    }
                } else if (rowNumber == 3) {
                    if (seatNumber > 0 && seatNumber < 21) {
                        seat3[seatNumber - 1] = '0';
                        System.out.println(Arrays.toString(seat3));
                    }
                    if (seat3[seatNumber - 1] == '0') {
                        System.out.println("Ticket cancelled.");
                        ticket_remover(rowNumber, seatNumber);
                    } else {
                        System.out.println("Invalid seat number");
                    }
                }
            } else{
                System.out.println("Invalid row number");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input. Please enter an Integer.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of bound");
        }
    }

    // Creating a custom method to remove a ticket
    private static void ticket_remover(int rowNumber, int seatNumber) {
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).rowNumber == rowNumber) {
                if (ticketList.get(i).seatNumber == seatNumber) {
                    ticketList.remove(i);
                }
            }
        }
    }

    // Method to show available seats
    private static void show_available() {
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < seat1.length; i++) {
            if (seat1[i] == 'O') {
                System.out.print(i + 1 + ",");
            }
        }
        System.out.println();
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < seat2.length; i++) {
            if (seat2[i] == 'O') {
                System.out.print(i + 1 + ",");
            }
        }
        System.out.println();
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < seat3.length; i++) {
            if (seat3[i] == 'O') {
                System.out.print(i + 1 + ",");
            }
        }
        System.out.println();
    }

    // Method to save seat information in a text file
    private static void save() {
        try {
            // Using FileWriter class
            FileWriter writer = new FileWriter("save.txt");
            writer.write((seat1));
            writer.write("\n");
            writer.write((seat2));
            writer.write("\n");
            writer.write((seat3));
            writer.close();
            System.out.println("File Successfully Saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Method to load the last saved seat information text file
    private static void load() {
        try {
            // Using the File class
            File file = new File("save.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Creating a method to show ticket information
    private static void show_tickets_info() {
        int Total = 0;

        for (Ticket ticket : ticketList) {
            ticket.print();
            Total += ticket.price;
            System.out.println("Total price: " + Total);
        }
    }

    // Creating a method to show ticket information and prices in ascending order
    private static void sort_tickets() {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < ticketList.size() - 1; i++) {
            swapped = false;
            for (j = 0; j < ticketList.size() - i - 1; j++) {
                if (ticketList.get(j).price > ticketList.get(j + 1).price) {
                    // swap arr[j] and arr[j+1]
                    temp = (int) ticketList.get(j).price;
                    ticketList.get(j).price = ticketList.get(j + 1).price;
                    ticketList.get(j + 1).price = temp;
                    swapped = true;
                }
            }
            // IF no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }

        double Total = 0;

        for (i = 0; i < ticketList.size(); i++) {
            ticketList.get(i).print();
            System.out.println("-------------------------------------------------------");
            Total += ticketList.get(i).price;
            System.out.println("Total price: " + Total);
        }
    }
}
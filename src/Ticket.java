public class Ticket {
    int rowNumber;
    int seatNumber;
    double price;
    Person person; // Creating an object of class Person

    Ticket(int row, int seat, double price,Person person){
        this.rowNumber = row;
        this.seatNumber = seat;
        this.price = price;
        this.person = person;

    }
    void print() {
        System.out.println("name: " + this.person.name);
        System.out.println("surname: " + this.person.surname);
        System.out.println("email: " + this.person.email);
        System.out.println("row: " + this.rowNumber);
        System.out.println("seat: " + this.seatNumber);
        System.out.println("price: " + this.price);
        System.out.println();
    }
}
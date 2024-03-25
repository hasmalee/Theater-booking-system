package part_b;

import java.io.Serializable;

public class Ticket implements Serializable {

    private int row;
    private int seat;
    private double price;
    private Person person;


    public Ticket() {
        // Compiler will add default data
    }
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }


    public void print() {
        System.out.printf("|%-12s|%-13s|%9s|%-15s|%-20s|%-35s|",
                " "+row, "  "+seat, "£"+price+" ", person.getName(), person.getSurName(), person.getEmail());
    }
    public void printDetails() {
        System.out.println("\tTicket price : "+price);
        System.out.println("\tPerson name : "+person.getName());
        System.out.println("\tPerson surname : "+person.getSurName());
        System.out.println("\tPerson email : "+person.getEmail());
    }


    public int getRow() {
        return row;
    }
    public int getSeat() {
        return seat;
    }
    public double getPrice() {
        return price;
    }
    public Person getPerson() {
        return person;
    }


    public void setRow(int row) {
        this.row = row;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

}

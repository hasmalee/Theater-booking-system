package part_b;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Theater {

    private Ticket[] row1 = new Ticket[12];
    private Ticket[] row2 = new Ticket[16];
    private Ticket[] row3 = new Ticket[20];

    public static void main(String[] args) {

        // part_a.Theater Obj
        part_b.Theater theater = new part_b.Theater();

        System.out.println("\n\t\t\t>>> Welcome to the New Theatre <<<");
        while (true) {
            switch (theater.mainMenu()) {
                case -1:
                    break;

                case 0:
                    System.exit(0);
                    break;

                case 1:
                    theater.buy_ticket();
                    break;

                case 2:
                    theater.print_seating_area();
                    break;

                case 3:
                    theater.cancel_ticket();
                    break;

                case 4:
                    theater.show_available();
                    break;

                case 5:
                    theater.save();
                    break;

                case 6:
                    theater.load();
                    break;

                case 7:
                    theater.show_tickets_info();
                    break;

                case 8:
                    theater.sort_tickets();
                    break;

                default:
                    System.out.println("Invalid option !");
                    break;
            }
        }

    }

    private int getIntInput() {
        try {
            Scanner user = new Scanner(System.in);
            return user.nextInt();

        } catch(Exception ex) {
            System.out.println("Invalid input enter integer value !\n");
        }

        return -1;
    }
    private double getDoubleInput() {
        try {
            Scanner user = new Scanner(System.in);
            return user.nextInt();

        } catch(Exception ex) {
            System.out.println("Invalid input enter float value !\n");
        }

        return -1;
    }
    private String getStrInput() {
        Scanner user = new Scanner(System.in);
        return user.nextLine();
    }
    private boolean yesOrNoQuestion(String question) {
        boolean returnValue = false;
        while (true) {
            System.out.print(question);

            String yesOrNo = getStrInput();
            if (yesOrNo.equalsIgnoreCase("YES") || yesOrNo.equalsIgnoreCase("Y")) {
                returnValue = true;
                break;
            } else if (yesOrNo.equalsIgnoreCase("NO") || yesOrNo.equalsIgnoreCase("N")) {
                break;
            }
        }
        return returnValue;
    }
    private void optionBreakWithOptionName(String optionName) {
        System.out.println("\n\t------------------------------------------------------------");
        System.out.println("\t\t"+optionName+"\n");
    }
    private int mainMenu() {

        System.out.println("\t------------------------------------------------------------");
        System.out.println("\tPlease select an option :");
        System.out.println("\t1) Buy a ticket");
        System.out.println("\t2) Print seating area");
        System.out.println("\t3) Cancel ticket");
        System.out.println("\t4) List available seats");
        System.out.println("\t5) Save to file");
        System.out.println("\t6) Load from file");
        System.out.println("\t7) Print ticket information and total price");
        System.out.println("\t8) Sort tickets by price");
        System.out.println("\t\t0) Quit");
        System.out.println("\t------------------------------------------------------------");
        System.out.print("Enter option : ");

        return getIntInput();
    }
    private void buy_ticket() {

        optionBreakWithOptionName(">>>>> Buy a ticket");

        System.out.println("\tAvailable seat numbers");
        System.out.print("Row 1 :- ");
        for (int i=0;i<row1.length;i++) {
            if (row1[i] == null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 2 :- ");
        for (int i=0;i<row2.length;i++) {
            if (row2[i] == null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 3 :- ");
        for (int i=0;i<row3.length;i++) {
            if (row3[i] == null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.println("\n");

        boolean loopBreak = true;
        while (loopBreak) {
            System.out.print("Enter row number : ");
            int rowNumber = getIntInput();

            if (rowNumber > 0 && rowNumber < 4) {
                while(loopBreak) {
                    System.out.print("Enter seat number : ");
                    int seatNumber = getIntInput();

                    switch (rowNumber) {
                        case 1 -> {
                            if (seatNumber > 0 && seatNumber < 13) {
                                if (row1[seatNumber - 1] == null) {
                                    setTicket(rowNumber, seatNumber);
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " booked successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is not available !\n");
                                    if (!yesOrNoQuestion("Do you want to try again this row another seat : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to try again another seat : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 2 -> {
                            if (seatNumber > 0 && seatNumber < 17) {
                                if (row2[seatNumber - 1] == null) {
                                    setTicket(rowNumber, seatNumber);
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " booked successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is not available !\n");
                                    if (!yesOrNoQuestion("Do you want to try again this row another seat : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to try again another seat : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 3 -> {
                            if (seatNumber > 0 && seatNumber < 21) {
                                if (row3[seatNumber - 1] == null) {
                                    setTicket(rowNumber, seatNumber);
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " booked successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is not available !\n");
                                    if (!yesOrNoQuestion("Do you want to try again this row another seat : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to try again another seat : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                    }

                }


            } else if (rowNumber != -1) {
                System.out.println("Invalid row number !");
            }

            loopBreak = true;
            if (yesOrNoQuestion("\nDo you want to try again : ")) {
                loopBreak = true;
            }
        }


    }
    private void print_seating_area() {

        optionBreakWithOptionName(">>>>> Print seating area");

        System.out.print("\t\t*************\n\t\t*   STAGE   *\n\t\t*************\n\t\t");
        for (int i=0;i<row1.length;i++) {
            if (row1.length/2 == i) {
                System.out.print(" ");
            }
            if (row1[i] == null) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }

        }
        System.out.printf("\n\t%-2s"," ");

        for (int i=0;i<row2.length;i++) {
            if (row2.length/2 == i) {
                System.out.print(" ");
            }
            if (row2[i] == null) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }

        }
        System.out.printf("\n%-4s"," ");

        for (int i=0;i<row3.length;i++) {
            if (row3.length/2 == i) {
                System.out.print(" ");
            }
            if (row3[i] == null) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }

        }
        System.out.println("\n");

    }
    private void cancel_ticket() {

        optionBreakWithOptionName(">>>>> Cancel ticket");

        System.out.println("\tBooked seat numbers");
        System.out.print("Row 1 :- ");
        for (int i=0;i<row1.length;i++) {
            if (row1[i] != null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 2 :- ");
        for (int i=0;i<row2.length;i++) {
            if (row2[i] != null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 3 :- ");
        for (int i=0;i<row3.length;i++) {
            if (row3[i] != null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.println("\n");

        boolean loopBreak = true;
        while (loopBreak) {
            System.out.print("Enter row number : ");
            int rowNumber = getIntInput();

            if (rowNumber > 0 && rowNumber < 4) {
                while(loopBreak) {
                    System.out.print("Enter seat number : ");
                    int seatNumber = getIntInput();

                    switch (rowNumber) {
                        case 1 -> {
                            if (seatNumber > 0 && seatNumber < 13) {
                                if (row1[seatNumber - 1] != null) {
                                    row1[seatNumber - 1].printDetails();
                                    if (yesOrNoQuestion("\nAre you sure you want to cancel this ticket : ")) {
                                        row1[seatNumber - 1] = null;
                                        System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " cancel ticket successfully");
                                    }
                                    System.out.println();
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is available !\n");
                                    if (!yesOrNoQuestion("Do you want to cancel this row another ticket : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to cancel another ticket : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 2 -> {
                            if (seatNumber > 0 && seatNumber < 17) {
                                if (row2[seatNumber - 1] != null) {
                                    row2[seatNumber - 1].printDetails();
                                    if (yesOrNoQuestion("\nAre you sure you want to cancel this ticket : ")) {
                                        row2[seatNumber - 1] = null;
                                        System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " cancel ticket successfully");
                                    }
                                    System.out.println();
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is available !\n");
                                    if (!yesOrNoQuestion("Do you want to cancel this row another ticket : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to cancel another ticket : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 3 -> {
                            if (seatNumber > 0 && seatNumber < 21) {
                                if (row3[seatNumber - 1] != null) {
                                    row3[seatNumber - 1].printDetails();
                                    if (yesOrNoQuestion("\nAre you sure you want to cancel this ticket : ")) {
                                        row3[seatNumber - 1] = null;
                                        System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " cancel ticket successfully");
                                    }
                                    System.out.println();
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is available !\n");
                                    if (!yesOrNoQuestion("Do you want to cancel this row another ticket : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to cancel another ticket : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                    }

                }


            } else if (rowNumber != -1) {
                System.out.println("Invalid row number !\n");
            }

            loopBreak = true;
            if (!yesOrNoQuestion("Do you want to try again : ")) {
                loopBreak = false;
            }
        }
    }
    private void show_available() {

        optionBreakWithOptionName(">>>>> List available seats");

        System.out.print("Seats available in row 1 : ");
        for (int i=0;i<row1.length;i++) {
            if (row1[i] == null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nSeats available in row 2 : ");
        for (int i=0;i<row2.length;i++) {
            if (row2[i] == null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nSeats available in row 3 : ");
        for (int i=0;i<row3.length;i++) {
            if (row3[i] == null) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.println("\n");
    }
    private void save() {
        try {
            File dataFile = new File("Part_B_Data_File.txt");
            if (dataFile.exists()) {
                dataFile.delete();
            }
            if (dataFile.createNewFile()) {

                int count = 0;
                Ticket[] allRowArray = new Ticket[48];
                for (Ticket ticket : row1) {
                    allRowArray[count++] = ticket;
                }
                for (Ticket ticket : row2) {
                    allRowArray[count++] = ticket;
                }
                for (Ticket ticket : row3) {
                    allRowArray[count++] = ticket;
                }

                FileOutputStream fileOut = new FileOutputStream(dataFile.getName());
                ObjectOutputStream out = new ObjectOutputStream(fileOut);

                out.writeObject(allRowArray);
                out.close();
                fileOut.close();

                System.out.println(">>> Successfully save data into file\n");
            }

        } catch(IOException ex) {
            System.out.println("Try again !\n");
        }
    }
    private void load() {
        try {
            File dataFile = new File("Part_B_Data_File.txt");
            if (dataFile.exists()) {

                FileInputStream fileIn = new FileInputStream(dataFile.getName());
                ObjectInputStream in = new ObjectInputStream(fileIn);

                Ticket[] allRowArray = (Ticket[])in.readObject();
                in.close();
                fileIn.close();

                int count = 0;
                for (int i=0;i<row1.length;i++) {
                    row1[i] = allRowArray[count++];
                }
                for (int i=0;i<row2.length;i++) {
                    row2[i] = allRowArray[count++];
                }
                for (int i=0;i<row3.length;i++) {
                    row3[i] = allRowArray[count++];
                }

                System.out.println(">>> Successfully load data into programme\n");

            } else {
                System.out.println("No data file is available !\n");
            }

        } catch(IOException | ClassNotFoundException ex) {
            System.out.println("Try again !\n");
        }
    }
    private void show_tickets_info() {

        optionBreakWithOptionName(">>>>> Print ticket information and total price");

        int[] columnSpase = {12,13,9,15,20,35};
        String[] columnName = {" Row Number", " Seat Number", " Price", " Name", " Surname", " E-mail"};

        for (int f=0;f<2;f++) {
            for (int i=0;i<columnSpase.length;i++) {
                System.out.print("*");
                for (int j=0;j<columnSpase[i];j++){
                    System.out.print("-");
                }
            }
            System.out.println("*");
            if (f == 0) {
                System.out.printf("|%-"+columnSpase[0]+"s|%-"+columnSpase[1]+"s|%-"+columnSpase[2]+"s|%-"+columnSpase[3]+"s|%-"+columnSpase[4]+"s|%-"+columnSpase[5]+"s|",
                        columnName[0], columnName[1], columnName[2], columnName[3], columnName[4], columnName[5]);
                System.out.println();
            }

        }

        for (Ticket ticket : row1) {
            if (ticket != null) {
                ticket.print();
                System.out.println();
            }
        }

        for (Ticket ticket : row2) {
            if (ticket != null) {
                ticket.print();
                System.out.println();
            }
        }
        for (Ticket ticket : row3) {
            if (ticket != null) {
                ticket.print();
                System.out.println();
            }
        }

        for (int i=0;i<columnSpase.length;i++) {
            System.out.print("*");
            for (int j=0;j<columnSpase[i];j++){
                System.out.print("-");
            }
        }
        System.out.println("*\n");
    }
    private void sort_tickets() {

        optionBreakWithOptionName(">>>>> Sort tickets by price");

        int[] columnSpase = {12,13,9,15,20,35};
        String[] columnName = {" Row Number", " Seat Number", " Price", " Name", " Surname", " E-mail"};

        for (int f=0;f<2;f++) {
            for (int i=0;i<columnSpase.length;i++) {
                System.out.print("*");
                for (int j=0;j<columnSpase[i];j++){
                    System.out.print("-");
                }
            }
            System.out.println("*");
            if (f == 0) {
                System.out.printf("|%-"+columnSpase[0]+"s|%-"+columnSpase[1]+"s|%-"+columnSpase[2]+"s|%-"+columnSpase[3]+"s|%-"+columnSpase[4]+"s|%-"+columnSpase[5]+"s|",
                        columnName[0], columnName[1], columnName[2], columnName[3], columnName[4], columnName[5]);
                System.out.println();
            }

        }

        // Count all ticket count
        int count = 0;
        for (Ticket ticket : row1) {
            if (ticket != null) {
                count++;
            }
        }
        for (Ticket ticket : row2) {
            if (ticket != null) {
                count++;
            }
        }
        for (Ticket ticket : row3) {
            if (ticket != null) {
                count++;
            }
        }


        // Create new array and set all tickets
        Ticket[] allRowArray = new Ticket[count];

        count = 0;
        for (Ticket ticket : row1) {
            if (ticket != null) {
                allRowArray[count++] = ticket;
            }
        }
        for (Ticket ticket : row2) {
            if (ticket != null) {
                allRowArray[count++] = ticket;
            }
        }
        for (Ticket ticket : row3) {
            if (ticket != null) {
                allRowArray[count++] = ticket;
            }
        }

        // Sort ticket by price
        for (int i=0;i<allRowArray.length;i++) {
            for (int j=0;j<allRowArray.length;j++) {
                if (allRowArray[i].getPrice() < allRowArray[j].getPrice()) {
                    Ticket tempTicket = new Ticket(allRowArray[i].getRow(),
                            allRowArray[i].getSeat(),
                            allRowArray[i].getPrice(),
                            allRowArray[i].getPerson()
                    );
                    allRowArray[i] = allRowArray[j];
                    allRowArray[j] = tempTicket;
                }
            }
        }

        // Print all sorted ticket details
        for (Ticket ticket : allRowArray) {
            if (ticket != null) {
                ticket.print();
                System.out.println();
            }
        }

        for (int i=0;i<columnSpase.length;i++) {
            System.out.print("*");
            for (int j=0;j<columnSpase[i];j++){
                System.out.print("-");
            }
        }
        System.out.println("*\n");

    }
    private void setTicket(int row, int seat) {

        String name = null, surname = null, email = null;
        double price = 0;
        boolean loopBreak = true;
        
        while (loopBreak) {
            System.out.print("Enter ticket price : £");
            price = getDoubleInput();
            if (price > 0) {
                loopBreak = false;

            } else if (price != -1) {
                System.out.println("Invalid price !\n");
            }
        }
        loopBreak = true;

        while (loopBreak) {
            System.out.print("Enter person name : ");
            name= getStrInput().trim();
            if (isValidUsername(name)) {
                loopBreak = false;

            } else {
                System.out.println("Invalid name !\n");
            }
        }
        loopBreak = true;

        while (loopBreak) {
            System.out.print("Enter person surname : ");
            surname = getStrInput();
            if (isValidUsername(surname)) {
                loopBreak = false;

            } else {
                System.out.println("Invalid  surname !\n");
            }
        }
        loopBreak = true;

        while (loopBreak) {
            System.out.print("Enter person email : ");
            email = getStrInput();
            if (isValidEmail(email)) {
                loopBreak = false;

            } else {
                System.out.println("Invalid  email !\n");
            }
        }

        // Create ticket and person and add ticket in to array
        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(row, seat, price, person);

        switch (row) {
            case 1 -> row1[seat-1] = ticket;
            case 2 -> row2[seat-1] = ticket;
            case 3 -> row3[seat-1] = ticket;
        }
    }
    public static boolean isValidUsername(String name) {

        // Regex to check valid username.
        String regex = "^[A-Za-z]\\w{3,30}$";

        // Compile the ReGex
        Pattern pattern = Pattern.compile(regex);

        // If the username is empty return false
        if (name == null) {
            return false;
        }

        /*  Pattern class contains matcher() method
             to find matching between given username
             and regular expression. */
        Matcher matcher = pattern.matcher(name);

        // Return if the username matched the ReGex
        return matcher.matches();
    }
    public static boolean isValidEmail(String email) {

        // Regex to check valid email.
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        // Compile the ReGex
        Pattern pattern = Pattern.compile(emailRegex);

        // If the email is empty return false
        if (email == null)
            return false;

        /*  Pattern class contains matcher() method
            to find matching between given email
            and regular expression */
        Matcher matcher = pattern.matcher(email);

        // Return if the email matched the ReGex
        return matcher.matches();
    }
}

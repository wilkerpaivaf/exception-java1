package Application;

import model.entities.Reservation;
import model.excepitions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int roomNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("Check-in Date (dd/mm/yyyy): ");
            LocalDate checkInDate = LocalDate.parse(sc.nextLine(), f1);

            System.out.print("Check-out Date (dd/mm/yyyy): ");
            LocalDate checkOutDate = LocalDate.parse(sc.nextLine(), f1);


            Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println("Reservatio: " + reservation);


            System.out.print("Insert New Check-in Date (dd/mm/yyyy): ");
            checkInDate = LocalDate.parse(sc.nextLine(), f1);

            System.out.print("Insert New Check-out Date (dd/mm/yyyy): ");
            checkOutDate = LocalDate.parse(sc.nextLine(), f1);

            reservation.updateDates(checkInDate, checkOutDate);

            System.out.println("Reservatio: " + reservation);
        }
        catch(DomainException e) {
            System.out.println("Erro in Reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unpexpected Error");
        }



        sc.close();

    }
}


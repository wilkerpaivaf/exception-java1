package model.entities;

import com.sun.jdi.InvalidTypeException;
import model.excepitions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private static DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {

    }

    public Reservation(Integer roomNumber, LocalDate chekIn, LocalDate chekOut) throws DomainException{
        if(checkIn.isAfter(checkOut)){
            throw new DomainException("The Check-In must be before the Check-Out");
        }
        this.roomNumber = roomNumber;
        this.checkIn = chekIn;
        this.checkOut = chekOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getChekIn() {
        return checkIn;
    }

    public LocalDate getChekOut() {
        return checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn,checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        LocalDate now = LocalDate.now();
        if(checkIn.isBefore(now) || checkOut.isBefore(now)){
            throw new DomainException("Reservation Dates for updates must be future Dates");

        }
         if(checkIn.isAfter(checkOut)){
             throw new DomainException("The Check-In must be before the Check-Out");
        }
         else {
             this.checkIn = checkIn;
             this.checkOut = checkOut;
         }

    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + f1.format(checkIn)
                + ", check-out: "
                + f1.format(checkOut)
                + " "
                + duration()
                + " Nights";
    }
}

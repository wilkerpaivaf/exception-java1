package model.entities;

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

    public Reservation(Integer roomNumber, LocalDate chekIn, LocalDate chekOut) {
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

    public String updateDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if(checkIn.isBefore(now) || checkOut.isBefore(now)){
            return "Erro in reservation: Reservetion dates for update must be future then now ";

        }
         if(checkIn.isAfter(checkOut)){
            return "Check-in is after check-out";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
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

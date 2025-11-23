package cinema.showtime.impl;

import cinema.showtime.entity.ShowTime;
import cinema.showtime.service.IIsExpired;
import cinema.showtime.service.IReserveSeats;

import java.time.LocalDateTime;
import java.util.List;

public class ReserveSeats implements IReserveSeats, IIsExpired {
    @Override
    public boolean reserveSeats(ShowTime showTime, List<String> seats) {
        if (showTime == null || seats == null || seats.isEmpty()) {
            System.out.println("Invalid showtime or seats.");
            return false;
        }

        for (String seat : seats) {
            if (showTime.getBookedSeats().contains(seat)) {
                System.out.println("Seat already booked: " + seat);
                return false;
            }
        }

        showTime.getBookedSeats().addAll(seats);
        return true;
    }

    @Override
    public boolean isExpired(ShowTime showTime) {
        return showTime.getDatetime().isBefore(LocalDateTime.now());
    }
}

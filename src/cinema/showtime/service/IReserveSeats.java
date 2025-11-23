package cinema.showtime.service;

import cinema.showtime.entity.ShowTime;

import java.util.List;

public interface IReserveSeats {
    boolean reserveSeats(ShowTime showTime, List<String> seats);
}

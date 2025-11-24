package cinema.cinemahall.service;

import cinema.cinemahall.entity.CinemaHall;

import java.util.List;

public interface ICinemaHallService {
    void addHall(CinemaHall hall);
    CinemaHall getHallById(int id);
    List<CinemaHall> getAllHalls();
    int calculateTotalSeats(int hallId);
}

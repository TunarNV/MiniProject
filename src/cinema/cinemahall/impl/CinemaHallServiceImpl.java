package cinema.cinemahall.impl;

import cinema.appdata.AppData;
import cinema.cinemahall.entity.CinemaHall;
import cinema.cinemahall.service.ICinemaHallService;

import java.util.List;

public class CinemaHallServiceImpl implements ICinemaHallService {
    private final AppData appData;

    public CinemaHallServiceImpl(AppData appData) {
        this.appData = appData;
    }
    @Override
    public void addHall(CinemaHall hall) {
      appData.getHalls().add(hall);
    }

    @Override
    public CinemaHall getHallById(int id) {
        return appData.getHalls().stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CinemaHall> getAllHalls() {
        return appData.getHalls();
    }

    @Override
    public int calculateTotalSeats(int hallId) {
        CinemaHall cinemaHall = getHallById(hallId);
        if (cinemaHall == null) return 0;
        return cinemaHall.getRows() * cinemaHall.getCols();
    }
}

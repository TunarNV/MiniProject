package cinema.showtime.service;

import cinema.showtime.entity.ShowTime;

public interface IIsExpired {
    boolean isExpired(ShowTime showTime);
}

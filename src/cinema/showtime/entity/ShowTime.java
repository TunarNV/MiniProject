package cinema.showtime.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowTime {
    private int id;
    private int movieId;
    private int hallId;
    private LocalDateTime datetime;
    private double price;
    private List<String> bookedSeats = new ArrayList<>();

    public ShowTime(int id, int movieId, int hallId, LocalDateTime datetime, double price) {
        this.id = id;
        this.movieId = movieId;
        this.hallId = hallId;
        this.datetime = datetime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<String> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    @Override
    public String toString() {
        return "ShowTime{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", hallId=" + hallId +
                ", datetime=" + datetime +
                ", price=" + price +
                '}';
    }
}

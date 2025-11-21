package cinema.appdata;

import cinema.bookings.entity.Booking;
import cinema.cinemahall.entity.CinemaHall;
import cinema.movie.entity.Movie;
import cinema.showtime.entity.ShowTime;
import cinema.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AppData {
    private List<User>users = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    private List<CinemaHall> halls = new ArrayList<>(); // <-- CinemaHall burda
    private List<ShowTime> showtimes = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private User loggedUsers;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getLoggedUsers() {
        return loggedUsers;
    }

    public void setLoggedUsers(User loggedUsers) {
        this.loggedUsers = loggedUsers;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<CinemaHall> getHalls() {
        return halls;
    }

    public void setHalls(List<CinemaHall> halls) {
        this.halls = halls;
    }

    public List<ShowTime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<ShowTime> showtimes) {
        this.showtimes = showtimes;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}

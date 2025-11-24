package cinema.bookings.impl;

import cinema.appdata.AppData;
import cinema.bookings.entity.Booking;
import cinema.bookings.service.IBookingService;
import cinema.showtime.entity.ShowTime;
import cinema.showtime.impl.ReserveSeats;
import cinema.showtime.service.IIsExpired;
import cinema.showtime.service.IReserveSeats;
import cinema.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public class BookingService implements IBookingService {
    private final AppData appData;
    private final IReserveSeats reserveSeatsService;
    private final IIsExpired iIsExpiredService;

    public BookingService(AppData appData) {
        this.appData = appData;
        this.reserveSeatsService =  new ReserveSeats();
        this.iIsExpiredService = new ReserveSeats();
    }

    @Override
    public boolean createBooking(int showtimeId, List<String> seats) {
        User loggedUser = appData.getLoggedUsers();
        if (loggedUser == null){
            System.out.println("Please login first!");
            return false;
        }

        ShowTime showTime = appData.getShowtimes().stream().filter(st -> st.getId() == showtimeId)
                .findFirst().orElse(null);
        if (showTime == null){
            System.out.println("ShowTime not found!");
            return false;
        }

        if (!iIsExpiredService.isExpired(showTime)){
            System.out.println("This showtime has already passed!");
            return false;
        }

        if (!reserveSeatsService.reserveSeats(showTime,seats)){
            System.out.println("Some seats are already booked!");
            return false;
        }


        showTime.getBookedSeats().addAll(seats);
        double totalPrice = seats.size() * showTime.getPrice();

        Booking booking = new Booking(
                (int) System.currentTimeMillis(),
                loggedUser.getId(),
                showtimeId,
                seats,
                totalPrice,
                LocalDateTime.now());

        appData.getBookings().add(booking);

        System.out.println("Booking successful!");
        System.out.println("Seats: " + seats);
        System.out.println("Total Price: " + totalPrice + " AZN");


        return true;
    }

    @Override
    public List<Booking> getMyBookings() {
        User loggedUser = appData.getLoggedUsers();

        if (loggedUser == null) {
            System.out.println("Please login first!");
            return List.of();
        }

        return appData.getBookings().stream()
                .filter(b -> b.getUserId() == loggedUser.getId())
                .toList();
    }
}

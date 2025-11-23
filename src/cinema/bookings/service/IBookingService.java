package cinema.bookings.service;

import cinema.bookings.entity.Booking;

import java.util.List;

public interface IBookingService {
     boolean createBooking(int showtimeId, List<String> seats);
     List<Booking> getMyBookings();
}

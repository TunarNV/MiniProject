package cinema.movie.service;

import cinema.movie.entity.Movie;

import java.util.List;

public interface IMovieService {
    void addMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(int id);
}

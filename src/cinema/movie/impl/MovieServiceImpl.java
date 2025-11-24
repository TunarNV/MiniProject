package cinema.movie.impl;

import cinema.appdata.AppData;
import cinema.movie.entity.Movie;
import cinema.movie.service.IMovieService;

import java.util.List;

public class MovieServiceImpl implements IMovieService {
    private final AppData appData;

    public MovieServiceImpl(AppData appData) {
        this.appData = appData;
    }

    @Override
    public void addMovie(Movie movie) {
        appData.getMovies().add(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return appData.getMovies();
    }

    @Override
    public Movie getMovieById(int id) {
        return appData.getMovies()
                .stream()
                .filter(m-> m.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

package test.java;

import org.junit.jupiter.api.Test;
import test.java.RatingMovie.Movie;
import test.java.RatingMovie.MovieService;
import test.java.RatingMovie.Rating;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RatingMovieTest {
    private MovieService service = new MovieService();

    @Test
    public void movieServiceTest() {
        Movie matrix = new Movie("Матрица");
        Movie shrek = new Movie("Шрек");
        service.addGrade(matrix, new Rating<>(8.7));
        service.addGrade(matrix, new Rating<>(9.7));
        service.addGrade(shrek, new Rating<>(8.6));
        service.addGrade(shrek, new Rating<>(9.6));

        List<Movie> topMovies = service.getTopMovies();

        assertEquals(9.2, service.getAverageRating(matrix), 0.01);
        assertEquals("Матрица", topMovies.get(0).getTitle());
        assertEquals("Шрек", topMovies.get(1).getTitle());
    }
}

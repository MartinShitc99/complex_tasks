package test.java.RatingMovie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Система должна принимать оценки различных типов
 * Система должна сортировать оценки по фильмам
 * Должна вычислить средний балл фильма
 *
 * Первое:
 * Должен быть дженироком чтобы принимать любой тип и считать от 1.0 до 10.00
 * Второе:
 * мы должны принять все оценки и раскидать по фильмам например а = 5, 9; б = 9, 8;
 * Третье
 * Рассчитать каждую оценку и дать среднюю
 */

public class MovieService {
    private final Map<Movie, List<Rating<? extends Number>>> movieRatings = new HashMap<>();

    public synchronized void addGrade(Movie movie, Rating<? extends Number> rating) {
        double val = rating.getGrade().doubleValue();
        if (val < 1.0 || val > 10.0) {
            throw new IllegalArgumentException("Оценка должна быть от 1 до 10");
        }

        List<Rating<? extends Number>> ratings = movieRatings.computeIfAbsent(movie, k -> new ArrayList<>());

        ratings.add(rating);
    }

    public double getAverageRating(Movie movie) {
        List<Rating<? extends Number>> ratings = movieRatings.get(movie);

        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }

        return ratings.stream()
                .mapToDouble(r -> r.getGrade().doubleValue())
                .average()
                .orElse(0.0);
    }

    public List<Movie> getTopMovies() {
        return movieRatings.keySet().stream()
                .sorted(Comparator.comparingDouble(m -> getAverageRating((Movie) m)).reversed())
                .collect(Collectors.toList());
    }
}

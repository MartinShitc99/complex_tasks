package test.java.RatingMovie;

import java.util.Objects;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    public String getTitle() {
        return title;
    }
}

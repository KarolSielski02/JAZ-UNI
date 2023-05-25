package pl.pjatk.MovieService.Movie;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.Movie.Model.Movie;

import java.util.Optional;

@Repository
@Table(name = "movie")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

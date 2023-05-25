package pl.pjatk.MovieService.Movie;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.Movie.Model.Movie;

@Repository
@Table(name = "movie")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT is_available FROM movie WHERE ID = ?1", nativeQuery = true)
    boolean changeAvailabilityForID(Integer ID);
}

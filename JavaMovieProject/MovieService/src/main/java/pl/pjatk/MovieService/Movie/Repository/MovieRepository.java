package pl.pjatk.MovieService.Movie.Repository;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.Movie.Model.Movie;

import java.util.List;

@Repository
@Table(name = "movie")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET is_available = 1 WHERE ID = ?1", nativeQuery = true)
    void changeToAvailableForID(Integer ID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET is_available = 0 WHERE ID = ?1", nativeQuery = true)
    void changeToUnavailableForID(Integer ID);

    @Query(value = "SELECT * FROM movie WHERE ID = ?1", nativeQuery = true)
    Movie getById(Integer ID);

    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> findAll();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM movie WHERE ID = ?1", nativeQuery = true)
    void deleteById(int ID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET Name = ?1, Category = ?2 WHERE ID = ?3", nativeQuery = true)
    void updateMovieByIDAndNameAndCategory(String Name, String Category, int ID);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO movie ( Name, Category, is_available) VALUES (?1,?2,0)", nativeQuery = true)
    void addMovie(String name, String category);
}


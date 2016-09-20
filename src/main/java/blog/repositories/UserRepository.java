package blog.repositories;

import blog.models.User;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by bzhou on 09/09/16.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u")
    List<User> findAll();

    @Query("SELECT max(u.id) from User u")
    int maxId();
}

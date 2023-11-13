package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shop.entity.User;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE name = ?1", nativeQuery = true)
    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

}

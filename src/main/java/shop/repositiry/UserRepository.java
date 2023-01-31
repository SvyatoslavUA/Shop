package shop.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

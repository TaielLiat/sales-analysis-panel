package sheqet.sales_analysis_panel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sheqet.sales_analysis_panel.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);

}
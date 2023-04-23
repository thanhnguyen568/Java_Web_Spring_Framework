package be.ss13security.repository;

import be.ss13security.entity.UserApp;
import be.ss13security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByUserApp(UserApp userApp);
}

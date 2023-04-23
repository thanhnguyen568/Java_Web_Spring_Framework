package be.ss13security.repository;

import be.ss13security.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    UserApp findByUserName(String userName);
}

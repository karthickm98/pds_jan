package com.karthick.pds_jan.repository;

import com.karthick.pds_jan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {



//    Optional<User> findById(Long aLong);


//    Optional<User> findById(Long aLong);

    List<User> findByName(String name);


//    List<User> findAllByNameEndingWith(String suffix);


//    User save(User entity);
}

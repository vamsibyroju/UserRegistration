package com.user.registration.repositories;

import com.user.registration.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByEmail(String name);
    
}


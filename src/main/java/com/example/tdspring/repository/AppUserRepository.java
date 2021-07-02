package com.example.tdspring.repository;

import com.example.tdspring.entities.AppUser;
import com.example.tdspring.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    public AppUser findByUsername(String username) throws ResourceNotFoundException;
}

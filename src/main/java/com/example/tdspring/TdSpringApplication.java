package com.example.tdspring;

import com.example.tdspring.entities.AppRole;
import com.example.tdspring.entities.AppUser;
import com.example.tdspring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TdSpringApplication implements CommandLineRunner {

    @Autowired
    AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(TdSpringApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void run(String... args) throws Exception {
        // TODO block d'initialisation
        accountService.saveUser(new AppUser("1234","admin",null));
        accountService.saveUser(new AppUser("1234", "editeur",null));
        accountService.saveRole(new AppRole("ADMIN"));
        accountService.saveRole(new AppRole("EDITEUR"));
        accountService.addRoleToUser("admin", "ADMIN");
        accountService.addRoleToUser("editeur", "editeur");
    }

}

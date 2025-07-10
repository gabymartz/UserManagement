package com.example.user.management.config;

import com.example.user.management.entity.UserApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final com.example.user.management.repository.userRepository userRepository;

    public BootStrapData(com.example.user.management.repository.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void createUsers() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            UserApp admin = new UserApp("Admin", "User", "admin", "admin@gmail.com", "admin");
            userRepository.save(admin);
        }

        if (userRepository.findByUsername("nmartineza").isEmpty()) {
            UserApp user = new UserApp("Nayely", "Martinez", "nmartineza", "nmartinez@gmail.com", "123");
            userRepository.save(user);
        }

        System.out.println("Usuarios iniciales cargados en la base de datos.");
    }
    @Override
    public void run(String... args) throws Exception {
        createUsers();
        System.out.println();
    }

}

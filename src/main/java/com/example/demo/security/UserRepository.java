package com.example.demo.security;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
<<<<<<< HEAD
}
=======
}
>>>>>>> e3fd7648bbe5744615b64a20bb809a37f0a645fc

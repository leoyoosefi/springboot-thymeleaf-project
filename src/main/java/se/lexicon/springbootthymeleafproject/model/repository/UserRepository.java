package se.lexicon.springbootthymeleafproject.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootthymeleafproject.model.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByUsername(String username);
}

package se.lexicon.springbootthymeleafproject.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootthymeleafproject.model.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}

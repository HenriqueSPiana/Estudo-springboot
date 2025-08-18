package HenriqueSPiana.com.github.Estudo_springboot.repository;

import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

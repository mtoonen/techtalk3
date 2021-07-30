package nl.b3p.techtalk.example.repositories;

import nl.b3p.techtalk.example.resources.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepo extends JpaRepository<Example, Long> {
}

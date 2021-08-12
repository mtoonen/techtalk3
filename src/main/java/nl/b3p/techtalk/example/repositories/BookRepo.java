package nl.b3p.techtalk.example.repositories;

import nl.b3p.techtalk.example.resources.Example;
import nl.b3p.techtalk.example.resources.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}

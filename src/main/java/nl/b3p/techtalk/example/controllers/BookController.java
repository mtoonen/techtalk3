package nl.b3p.techtalk.example.controllers;

import nl.b3p.techtalk.example.repositories.BookRepo;
import nl.b3p.techtalk.example.resources.books.Book;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("books")
@RestController
public class BookController {

    @Autowired
    private BookRepo repo;

    @GetMapping("all")
    public List<Book> view(){
        return repo.findAll();
    }

    @GetMapping("paged")
    public Page<Book> viewPaged(@ParameterObject Pageable page){
        return repo.findAll(page);
    }

    @GetMapping("search")
    public List<Book> search(@RequestParam(required = false) String s, @RequestParam(required = false) String isbn) {
        Book book = new Book();
        book.setTitle(s);
        book.setIsbn(isbn);

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("isbn", ExampleMatcher.GenericPropertyMatchers.exact());

        return repo.findAll(Example.of(book, customExampleMatcher));
    }

}

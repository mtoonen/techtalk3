package nl.b3p.techtalk.example.controllers;

import nl.b3p.techtalk.example.repositories.BookRepo;
import nl.b3p.techtalk.example.resources.books.Book;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

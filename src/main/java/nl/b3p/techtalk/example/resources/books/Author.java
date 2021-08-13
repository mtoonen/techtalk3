package nl.b3p.techtalk.example.resources.books;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    private String author_name;
}

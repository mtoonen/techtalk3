package nl.b3p.techtalk.example.resources.books;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;
    private String publisher_name;
}

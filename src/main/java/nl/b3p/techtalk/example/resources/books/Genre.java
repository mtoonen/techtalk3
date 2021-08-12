package nl.b3p.techtalk.example.resources.books;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;
    private String genre;
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Genre parent;

}

package ingrid.com.libreria.libros;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String isbn;

    @Column(nullable = false, length = 50)
    private String titulo;

    public Libro() {
    }

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}

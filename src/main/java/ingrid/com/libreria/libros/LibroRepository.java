package ingrid.com.libreria.libros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("""
        SELECT l FROM Libro l
        WHERE l.isbn LIKE CONCAT('%', :criterio, '%')
        OR l.titulo LIKE CONCAT('%', :criterio, '%')
    """)
    List<Libro> buscarPorTodo(@Param("criterio") String criterio);
}

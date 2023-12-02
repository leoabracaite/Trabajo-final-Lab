package com.app.biblioteca.repository;


import com.app.biblioteca.model.Libros_Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface Libros_autorRepository extends JpaRepository <Libros_Autor, Long> {
    @Query("SELECT la FROM Libros_Autor la WHERE la.libro.id = :idLibro AND la.autor.id = :idAutor")
    Libros_Autor buscarPorIdLibroYIdAutor(@Param("idLibro") Long idLibro, @Param("idAutor") Long idAutor);
}

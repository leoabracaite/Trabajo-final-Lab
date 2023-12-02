package com.app.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.biblioteca.model.Libro;
import com.app.biblioteca.model.LibroAD;

import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository <Libro, Long> {
    //SELECT l,a,g
    //FROM libros l
    //JOIN libros_autor la ON l.id_libro = la.id_libro
    //JOIN autores a ON la.id_autor = a.id_autor
    //JOIN generos g ON g.id_libro = l.id_libro;
    //@Query("SELECT l,a,g.primer_genero,g.segundo_genero,g.tercer_genero FROM Libro l JOIN FETCH l.libros_autor la JOIN FETCH la.autor a JOIN FETCH l.genero g")
    //@Query("SELECT l FROM Libro l JOIN FETCH l.autores la JOIN FETCH la.autor a JOIN FETCH l.genero g")
    //@Query("SELECT DISTINCT l,a,g.primer_genero,g.segundo_genero,g.tercer_genero FROM Libro l LEFT JOIN FETCH l.autores la LEFT JOIN FETCH la.autor a LEFT JOIN FETCH l.genero g")
    @Query("SELECT NEW com.app.biblioteca.model.LibroAD(l.id_libro, l.titulo, l.nro_pags, l.sinopsis, a.id_autor, a.nombre, a.nacionalidad, l.primer_genero, l.segundo_genero, l.tercer_genero) FROM Libro l LEFT JOIN l.autores la LEFT JOIN la.autor a")
    List<LibroAD> librosConAyG();
    //@Query("DELETE FROM ")
    //Libro eliminarLibro(@Param("libroId") Long id_eliminar);

    @Query("SELECT l FROM Libro l JOIN Prestamo p ON l.id_libro <> p.libro.id_libro")
        //@Query("SELECT l FROM Libro l JOIN Prestamo p ON l.id_libro <> p.libro.id_libro WHERE p.estado = false")
    List<Libro> obtenerLibDispo();


    //SELECT l FROM libros l WHERE l.id_libro NOT IN (SELECT pe.id_libro FROM prestamos pe)
    @Query("SELECT l FROM Libro l WHERE l.id_libro NOT IN (SELECT pe.libro.id_libro FROM Prestamo pe WHERE pe.estado = false)")
    List<Libro> obtenerLibrosSinPres();

    //@Query("SELECT NEW com.app.biblioteca.model.LibroAD(l.id_libro, l.titulo, l.nro_pags, l.sinopsis, a.id_autor, a.nombre, a.nacionalidad, g.primer_genero, g.segundo_genero, g.tercer_genero) FROM Libro l LEFT JOIN l.autores la LEFT JOIN la.autor a LEFT JOIN l.genero g WHERE l.titulo = :tit)")
    //List<LibroAD> listarPortit(@Param("tit") String tit);
    @Query("SELECT NEW com.app.biblioteca.model.LibroAD(l.id_libro, l.titulo, l.nro_pags, l.sinopsis, a.id_autor, a.nombre, a.nacionalidad, l.primer_genero, l.segundo_genero, l.tercer_genero) FROM Libro l LEFT JOIN l.autores la LEFT JOIN la.autor a WHERE l.titulo = :tit")
    List<LibroAD> listarPortit(@Param("tit") String tit);

    @Modifying
    @Query(value = "INSERT INTO libros (nro_pags, sinopsis, titulo) VALUES (:nroPags, :sinopsis, :titulo)", nativeQuery = true)
    int saveLibroManualmente(@Param("nroPags") int nroPags, @Param("sinopsis") String sinopsis, @Param("titulo") String titulo);
}

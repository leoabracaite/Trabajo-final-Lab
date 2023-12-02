package com.app.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.biblioteca.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository <Autor ,Long> {

}

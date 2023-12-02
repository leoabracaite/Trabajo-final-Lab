package com.app.biblioteca.repository;

import com.app.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    @Query("SELECT p from Prestamo p ")
    List<Prestamo> obtenerPrest();

    @Modifying
    @Query("UPDATE Prestamo p SET p.estado = true WHERE p.id_prestamo = :idEst")
    void actualizarEst(@Param("idEst") Long idEst);
}

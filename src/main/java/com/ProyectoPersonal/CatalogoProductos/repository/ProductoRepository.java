package com.ProyectoPersonal.CatalogoProductos.repository;

import com.ProyectoPersonal.CatalogoProductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

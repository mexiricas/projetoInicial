package com.example.projetoInicial.repository;

import com.example.projetoInicial.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends  JpaRepository<Usuario, Long> {
    List<Usuario> findByName(String name);
}

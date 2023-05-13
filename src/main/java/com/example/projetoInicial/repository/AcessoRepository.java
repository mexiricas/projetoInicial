package com.example.projetoInicial.repository;

import com.example.projetoInicial.models.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcessoRepository extends  JpaRepository<Acesso, Long> {
    List<Acesso> findByPagina(String pagina);
    long countByPagina(String pagina);
}

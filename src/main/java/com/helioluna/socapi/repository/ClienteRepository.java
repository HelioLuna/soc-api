package com.helioluna.socapi.repository;

import com.helioluna.socapi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM cliente c WHERE c.nome LIKE :nome")
    List<Cliente> findAllByName(@Param("nome") String nome);
}

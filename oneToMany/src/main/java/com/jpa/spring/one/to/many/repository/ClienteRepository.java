package com.jpa.spring.one.to.many.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jpa.spring.one.to.many.entity.Cliente;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Optional<Cliente> findByNuCpf(String long1);

    public List<Cliente> findAllByNoClienteLike(String nmCliente);
    
    Page<Cliente> findAll(Pageable pageable);
    
    List<Cliente> findAll();
 
    Cliente save(Cliente cliente);
    
}

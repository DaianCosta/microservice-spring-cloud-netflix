package com.daian.pagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daian.pagamento.entities.Venda;

@Repository
public interface VendaRepository  extends JpaRepository<Venda, Long>{

}

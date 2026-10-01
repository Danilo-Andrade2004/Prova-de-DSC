package com.br.oficinamecanicamotorforte.veiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.oficinamecanicamotorforte.veiculo.model.Veiculo;

@Repository 
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
}

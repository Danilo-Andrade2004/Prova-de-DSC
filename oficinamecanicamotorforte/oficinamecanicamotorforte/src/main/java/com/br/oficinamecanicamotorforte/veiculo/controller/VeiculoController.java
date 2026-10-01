package com.br.oficinamecanicamotorforte.veiculo.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.oficinamecanicamotorforte.veiculo.dto.VeiculoRequestDTO;
import com.br.oficinamecanicamotorforte.veiculo.dto.VeiculoResponseDTO;
import com.br.oficinamecanicamotorforte.veiculo.model.Veiculo;
import com.br.oficinamecanicamotorforte.veiculo.service.VeiculoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    private final VeiculoService service;

    public VeiculoController(VeiculoService service){
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public VeiculoResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criar(@Valid @RequestBody VeiculoRequestDTO dto){
        VeiculoResponseDTO veiculo = service.criar(dto);
        URI uri = URI.create("/veiculos/" + veiculo.getId());
        return ResponseEntity.created(uri).body(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoRequestDTO dto){
        VeiculoResponseDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

package com.br.oficinamecanicamotorforte.veiculo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.br.oficinamecanicamotorforte.veiculo.dto.VeiculoRequestDTO;
import com.br.oficinamecanicamotorforte.veiculo.dto.VeiculoResponseDTO;
import com.br.oficinamecanicamotorforte.veiculo.exception.VeiculoException;
import com.br.oficinamecanicamotorforte.veiculo.model.Veiculo;
import com.br.oficinamecanicamotorforte.veiculo.repository.VeiculoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoResponseDTO criar(VeiculoRequestDTO dto){
        Veiculo salvo = veiculoRepository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<Veiculo> listar(){
        return veiculoRepository.findAll();
    }
    
    public VeiculoResponseDTO buscarPorId(Long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoException(id));
        return toResponseDTO(veiculo);
    }

    public VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO dto){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoException(id));

        veiculo.setPlaca(dto.getPlaca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAnoFabricacao(dto.getAnoFabricacao());
        veiculo.setTipo(dto.getTipo());
        veiculo.setProprietario(dto.getProprietario());
        Veiculo atualizado = veiculoRepository.save(veiculo);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new VeiculoException(id));
        veiculoRepository.deleteById(id);
    }

    private Veiculo toEntity(VeiculoRequestDTO dto){
        return new Veiculo(null, dto.getPlaca(), dto.getModelo(), dto.getAnoFabricacao(), dto.getTipo(), dto.getProprietario());
    }

    private VeiculoResponseDTO toResponseDTO(Veiculo veiculo){
        return new VeiculoResponseDTO(veiculo.getId(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getTipo(), veiculo.getProprietario());
    }
}

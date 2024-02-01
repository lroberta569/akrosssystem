package br.com.larissa.akrosssystem.service;

import br.com.larissa.akrosssystem.dto.SquadDTO;
import br.com.larissa.akrosssystem.model.Squad;
import br.com.larissa.akrosssystem.repository.CollaboratorRepository;
import br.com.larissa.akrosssystem.repository.SquadRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Larissa Silva
 * @description Serviços relacionados ao Squad
 **/
@Log4j2
@Service
public class SquadService {
    @Autowired
    private SquadRepository squadRepository;
    @Autowired
    private CollaboratorRepository collaboratorRepository;

    /**
     * Método para listar todos os squads
     *
     * @return List<SquadDTO>
     **/
    public List<SquadDTO> findAll() {
        List<Squad> squads = squadRepository.findAll();
        return squads.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Método para buscar o squad por id
     *
     * @param id
     * @return SquadDTO
     **/
    public SquadDTO findById(Long id) {
        Squad squad = squadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Squad não encontrado com ID: " + id));
        return mapToDTO(squad);
    }

    /**
     * Método para salvar o squad
     *
     * @param squadDTO
     * @return SquadDTO
     **/
    @Transactional
    public SquadDTO create(SquadDTO squadDTO) {
        Squad squad = mapToEntity(squadDTO);
        squad = squadRepository.save(squad);
        return mapToDTO(squad);
    }

    /**
     * Método para atualizar o squad
     *
     * @param id, squadDTO
     * @return SquadDTO
     **/
    public Object update(Long id, SquadDTO squadDTO) {
        SquadDTO dtoSquad = findById(id);
        if (dtoSquad != null) {
            BeanUtils.copyProperties(squadDTO, dtoSquad);
            Squad squadToUpdate = mapToEntity(dtoSquad);
            squadToUpdate.setIdSquad(id);
            Squad squadUpdate = squadRepository.save(squadToUpdate);
            return mapToDTO(squadUpdate);
        } else {
            return new RuntimeException("Squad não encontrado com ID: " + id);
        }
    }


    /**
     * Método para deletar o squad
     *
     * @param id
     **/
    public void delete(Long id) {
        squadRepository.deleteById(id);

    }

    /**
     * Método para converter um Squad para SquadDTO
     *
     * @param squad
     * @return SquadDTO
     **/
    private SquadDTO mapToDTO(Squad squad) {
        SquadDTO dto = new SquadDTO();
        dto.setId(squad.getIdSquad());
        dto.setName(squad.getName());
        dto.setCollaborators(squad.getCollaborators());
        return dto;
    }

    /**
     * Método para converter um SquadDTO para Squad
     *
     * @param dto
     * @return Squad
     **/
    private Squad mapToEntity(SquadDTO dto) {
        Squad squad = new Squad();
        squad.setIdSquad(dto.getId());
        squad.setName(dto.getName());
        squad.setCollaborators(dto.getCollaborators());
        return squad;
    }


}

package br.com.larissa.akrosssystem.service;

import br.com.larissa.akrosssystem.dto.CollaboratorDTO;
import br.com.larissa.akrosssystem.model.Collaborator;
import br.com.larissa.akrosssystem.repository.CollaboratorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Larissa Silva
 * @description Serviços relacionados ao Colaborador
 **/
@Service
public class CollaboratorService {
    @Autowired
    private CollaboratorRepository collaboratorRepository;

    /**
     * Método para listar todos os colaboradores
     *
     * @return List<CollaboratorDTO>
     **/
    public List<CollaboratorDTO> findAll() {
        List<Collaborator> collaborators = collaboratorRepository.findAll();
        return collaborators.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Método para buscar o colaborador por id
     *
     * @param id
     * @return CollaboratorDTO
     **/
    public CollaboratorDTO findById(Long id) {
        Collaborator colaborador = collaboratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado com ID: " + id));
        return mapToDTO(colaborador);
    }

    /**
     * Método para salvar o colaborador
     *
     * @param colaboradorDTO
     * @return CollaboratorDTO
     **/
    @Transactional
    public CollaboratorDTO create(CollaboratorDTO colaboradorDTO) {
        Collaborator colaborador = mapToEntity(colaboradorDTO);
        colaborador = collaboratorRepository.save(colaborador);
        return mapToDTO(colaborador);
    }

    /**
     * Método para atualizar o colaborador
     *
     * @param id, collaboratorDTO
     * @return CollaboratorDTO
     **/
    public Object update(Long id, CollaboratorDTO collaboratorDTO) {
        CollaboratorDTO dtoCollaborator = findById(id);
        if (dtoCollaborator != null) {
            BeanUtils.copyProperties(collaboratorDTO, dtoCollaborator);
            Collaborator collaboratorToUpdate = mapToEntity(dtoCollaborator);
            collaboratorToUpdate.setId(id);
            Collaborator collaboratorUpdate = collaboratorRepository.save(collaboratorToUpdate);
            return mapToDTO(collaboratorUpdate);
        } else {
            return new RuntimeException("Colaborador não encontrado com ID: " + id);
        }
    }


    /**
     * Método para deletar o colaborador
     *
     * @param id
     **/
    public void delete(Long id) {
        collaboratorRepository.deleteById(id);
    }

    /**
     * Método para converter um Collaborator para CollaboratorDTO
     *
     * @param collaborator
     * @return CollaboratorDTO
     **/
    private CollaboratorDTO mapToDTO(Collaborator collaborator) {
        CollaboratorDTO dto = new CollaboratorDTO();
        dto.setId(collaborator.getId());
        dto.setName(collaborator.getName());
        dto.setRole(collaborator.getRole());
        dto.setIdSquad(collaborator.getIdSquad());
        return dto;
    }

    /**
     * Método para converter um CollaboratorDTO para Collaborator
     *
     * @param dto
     * @return Collaborator
     **/
    private Collaborator mapToEntity(CollaboratorDTO dto) {
        Collaborator collaborator = new Collaborator();
        collaborator.setId(dto.getId());
        collaborator.setName(dto.getName());
        collaborator.setRole(dto.getRole());
        collaborator.setIdSquad(dto.getIdSquad());
        return collaborator;
    }


}

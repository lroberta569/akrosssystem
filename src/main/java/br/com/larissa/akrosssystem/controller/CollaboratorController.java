package br.com.larissa.akrosssystem.controller;

import br.com.larissa.akrosssystem.dto.CollaboratorDTO;
import br.com.larissa.akrosssystem.service.CollaboratorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/collaborator")
public class CollaboratorController {

    @Autowired
    CollaboratorService collaboratorService;

    /**
     * Endpoint para consultar o colaborador pelo id
     *
     * @param id
     **/
    @GetMapping(value = "/{id}", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            CollaboratorDTO returnedCollaborator = collaboratorService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(returnedCollaborator);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao buscar o colaborador", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para consultar todos os colaboradores
     **/
    @GetMapping(value = "/all", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findAll() {
        try {
            List<CollaboratorDTO> returnedCollaborators = collaboratorService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(returnedCollaborators);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao buscar os colaboradores", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para salvar um colaborador
     *
     * @param collaboratorDTO
     **/
    @PostMapping(value = "/create", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity register(@RequestBody CollaboratorDTO collaboratorDTO) {
        try {
            CollaboratorDTO returnedCollaborator = collaboratorService.create(collaboratorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(returnedCollaborator);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao cadastrar o colaborador", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para atualizar um colaborador
     *
     * @param id, collaboratorDTO
     **/
    @PutMapping(value = "/update/{id}", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody CollaboratorDTO collaboratorDTO) {
        try {
            Object returnedCollaborator = collaboratorService.update(id, collaboratorDTO);
            return ResponseEntity.status(HttpStatus.OK).body(returnedCollaborator);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao atualizar o colaborador", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para deletar um colaborador
     *
     * @param id
     **/
    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            collaboratorService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Colaborador deletado com sucesso!");
        } catch (Exception e) {
            log.error("Ocorreu um erro ao deletar o colaborador", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

}

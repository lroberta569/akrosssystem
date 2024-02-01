package br.com.larissa.akrosssystem.controller;

import br.com.larissa.akrosssystem.dto.SquadDTO;
import br.com.larissa.akrosssystem.service.SquadService;
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
@RequestMapping("/squad")
public class SquadController {

    @Autowired
    private SquadService squadService;

    /**
     * Endpoint para consultar o squad pelo id
     *
     * @param id
     **/
    @GetMapping(value = "/{id}", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            SquadDTO returnedSquad = squadService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(returnedSquad);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao buscar o squad", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para consultar todos os squads
     **/
    @GetMapping(value = "/all", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findAll() {
        try {
            List<SquadDTO> returnedSquads = squadService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(returnedSquads);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao buscar os squads", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para salvar o squad
     *
     * @param squadDTO
     **/
    @PostMapping(value = "/create", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity register(@RequestBody SquadDTO squadDTO) {
        try {
            SquadDTO returnedSquad = squadService.create(squadDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(returnedSquad);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao cadastrar o squad", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para atualizar um squad
     *
     * @param id, squadDTO
     **/
    @PutMapping(value = "/update/{id}", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody SquadDTO squadDTO) {
        try {
            Object returnedSquad = squadService.update(id, squadDTO);
            return ResponseEntity.status(HttpStatus.OK).body(returnedSquad);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao atualizar o squad", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    /**
     * Endpoint para deletar um squad
     *
     * @param id
     **/
    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            squadService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Squad deletado com sucesso!");
        } catch (Exception e) {
            log.error("Ocorreu um erro ao deletar o squad", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}

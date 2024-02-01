package br.com.larissa.akrosssystem.dto;

import br.com.larissa.akrosssystem.model.Squad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Larissa Silva
 * @description Classe de resposta e requisição relacionada ao Colaborador
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorDTO {
    private Long id;
    private String name;
    private String role;
    private Squad IdSquad;
}

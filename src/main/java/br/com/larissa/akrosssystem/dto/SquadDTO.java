package br.com.larissa.akrosssystem.dto;

import br.com.larissa.akrosssystem.model.Collaborator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Larissa Silva
 * @description Classe de resposta e requisição relacionada ao Squad
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadDTO {
    private Long id;
    private String name;
    private List<Collaborator> collaborators;
}

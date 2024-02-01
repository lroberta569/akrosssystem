package br.com.larissa.akrosssystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Larissa Silva
 * @description Entidade relacionada ao Squad
 **/
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSquad;

    private String name;
    @JsonIgnoreProperties("idSquad")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSquad")
    private List<Collaborator> collaborators;

}

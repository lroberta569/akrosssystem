package br.com.larissa.akrosssystem.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Larissa Silva
 * @description Entidade relacionada ao Colaborador
 **/
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role;

    @ManyToOne
    @JoinColumn(name = "idSquad")
    private Squad idSquad;
}

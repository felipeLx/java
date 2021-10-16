package br.com.scc4.tms.model.main;

import br.com.scc4.tms.model.tenant.Embarcador;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="transportadoras")
@Data
public class Transportadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "empresas-1")
    @Size(min=2, max=200, message = "max-length-200")
    @Column(name = "nome_transportadora")
    private String nomeTransportadora;

    @ManyToMany
    @JoinTable(
            name = "transportadoras_embarcadores",
            joinColumns = {@JoinColumn(name="transportadoras_id")},
            inverseJoinColumns = {@JoinColumn(name="embarcadores_id")}
    )
    private Set<Embarcador> embarcadores = new HashSet<>();

    @NotNull
    @ManyToMany(mappedBy = "transportadoras")
    private Set<Plataforma> plataformas = new HashSet<>();

}

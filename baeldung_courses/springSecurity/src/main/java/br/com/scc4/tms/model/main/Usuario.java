package br.com.scc4.tms.model.main;

import br.com.scc4.tms.model.tenant.Embarcador;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
@Data
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "usuarios-1")
    @Size(min=2, max=200, message = "max-length-200")
    private String nome;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @NotBlank(message = "usuarios-3")
    @Size(min=2, max=200, message = "max-length-200")
    @Email(message = "max-length-200")
    private String email;

    @NotNull(message = "usuarios-4")
    private Boolean status;

    @CPF(message = "usuarios-5")
    @NotBlank(message = "usuarios-6")
    @Size(min=2, max=18, message = "max-length-18")
    private String cpf;

    @Column(name = "data_expiracao")
    @JsonFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataExpiracao;

    @ManyToMany
    @JoinTable(
            name = "usuarios_empresas",
            joinColumns = {@JoinColumn(name="id")},
            inverseJoinColumns = {@JoinColumn(name="empresaId")}
    )
    private Set<Empresa> empresas = new HashSet<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_plataforma")
    private Plataforma plataforma;

    @ManyToMany
    @JoinTable(
            name = "usuarios_embarcadores",
            joinColumns = {@JoinColumn(name="id")},
            inverseJoinColumns = {@JoinColumn(name="embarcadores_id")}
    )
    private Set<Embarcador> embarcadores = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Usuario() {}

    public Usuario(String nome, String username, String senha,  String email, Boolean status, String cpf, LocalDate dataExpiracao) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.status = status;
        this.cpf = cpf;
        this.dataExpiracao = dataExpiracao;

    }

    public Usuario(String name, String username, String email, String encode) {
        this.nome = name;
        this.username = username;
        this.email = email;
        this.senha = encode;
    }

    @PrePersist @PreUpdate
    private void prePersistPreUpdate() {
        if (this.cpf != null) {
            this.cpf = removerFormatacao(this.cpf);
        }
    }

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    public String removerFormatacao(String campo) {
        return campo.replaceAll("[^0-9]", "");
    }

}

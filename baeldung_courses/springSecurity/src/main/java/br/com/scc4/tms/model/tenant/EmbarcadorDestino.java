package br.com.scc4.tms.model.tenant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name="embarcador_destino")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmbarcadorDestino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank(message = "empresas-1")
    @Size(min=2, max=200, message = "max-length-200")
    @Column(name = "nome_embarcador_destino")
    private String nomeEmbarcadorDestino;

    @NotBlank(message = "empresas-1")
    @Size(min=2, max=200, message = "max-length-200")
    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @CNPJ(message = "empresas-12")
    @NotBlank(message = "empresas-3")
    @Size(min=2, max=18, message = "max-length-18")
    private String cnpj;

    @NotBlank(message = "empresas-4")
    @Size(min=2, max=200, message = "max-length-200")
    private String endereco;

    @NotBlank(message = "empresas-5")
    @Size(min=2, max=25, message = "max-length-25")
    private String telefone;

    @NotBlank(message = "empresas-6")
    @Size(min=2, max=100, message = "max-length-100")
    private String bairro;

    @NotBlank(message = "empresas-7")
    @Size(min=2, max=100, message = "max-length-100")
    private String cidade;

    @NotBlank(message = "empresas-8")
    @Size(min=2, max=100, message = "max-length-10")
    private String uf;

    @NotBlank(message = "empresas-9")
    @Size(min=2, max=30, message = "max-length-30")
    private String cep;

    @NotBlank(message = "empresas-10")
    @Size(min=2, max=200, message = "max-length-200")
    @Email(message = "max-length-200")
    private String email;

    @Size(min=2, max=100, message = "max-length-100")
    private String complemento;

    @Size(min=2, max=7, message = "max-length-30")
    private BigDecimal latitude;

    @Size(min=2, max=7, message = "max-length-30")
    private BigDecimal longitude;

    @NotNull(message = "empresas-11")
    private Boolean temEndereco;

    @NotNull(message = "empresas-11")
    private Boolean status;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_embarcador")
    private Embarcador embarcador;



    @PrePersist @PreUpdate
    private void prePersistPreUpdate() {

        if (this.cnpj != null) {
            this.cnpj = removerFormatacao(cnpj);
        }
        if (this.telefone != null) {
            this.telefone = removerFormatacao(telefone);
        }
        if (this.cep != null) {
            this.cep = removerFormatacao(cep);
        }
    }

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @JsonIgnore
    public boolean temEndereco() {
        return getEndereco() == null;
    }

    public String removerFormatacao(String campo) {
        return campo.replaceAll("[^0-9]", "");
    }
}


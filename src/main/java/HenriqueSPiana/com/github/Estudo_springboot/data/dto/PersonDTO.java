package HenriqueSPiana.com.github.Estudo_springboot.data.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

//@JsonPropertyOrder({"codigo","nome","sobrenome","genero","endereco"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    private static final long serialVersionUID =1L;


//    @JsonProperty("codigo")
    private long id;

    private String nome;

    private String sobrenome;

    private String endereco;
//    @JsonIgnore
    private String genero;


    public PersonDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTO person)) return false;
        return getId() == person.getId() && Objects.equals(getNome(), person.getNome()) && Objects.equals(getSobrenome(), person.getSobrenome()) && Objects.equals(getEndereco(), person.getEndereco()) && Objects.equals(getGenero(), person.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getEndereco(), getGenero());
    }
}

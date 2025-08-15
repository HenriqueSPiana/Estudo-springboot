package HenriqueSPiana.com.github.Estudo_springboot.model;

import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {

    private static final long serialVersionUID =1L;


    private long id;
    private String nome;
    private String sobreNome;
    private String endereco;
    private String genero;


    public People() {}

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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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
        if (!(o instanceof People people)) return false;
        return getId() == people.getId() && Objects.equals(getNome(), people.getNome()) && Objects.equals(getSobreNome(), people.getSobreNome()) && Objects.equals(getEndereco(), people.getEndereco()) && Objects.equals(getGenero(), people.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobreNome(), getEndereco(), getGenero());
    }
}

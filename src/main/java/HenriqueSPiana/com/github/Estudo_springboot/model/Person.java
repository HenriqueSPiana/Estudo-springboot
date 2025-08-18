package HenriqueSPiana.com.github.Estudo_springboot.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private static final long serialVersionUID =1L;


    private long id;
    private String nome;
    private String Sobrenome;
    private String endereco;
    private String genero;


    public Person() {}

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
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
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
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getNome(), person.getNome()) && Objects.equals(getSobrenome(), person.getSobrenome()) && Objects.equals(getEndereco(), person.getEndereco()) && Objects.equals(getGenero(), person.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getEndereco(), getGenero());
    }
}

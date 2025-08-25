package HenriqueSPiana.com.github.Estudo_springboot.data.dto.v2;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonDTOV2 implements Serializable {

    private static final long serialVersionUID =1L;

    private long id;

    private String nome;

    private String Sobrenome;

    private Date dataAniversario;

    private String endereco;

    private String genero;



    public PersonDTOV2() {}

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

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }




    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getEndereco(), getGenero());
    }
}

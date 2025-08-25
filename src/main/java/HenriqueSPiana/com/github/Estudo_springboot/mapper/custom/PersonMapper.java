package HenriqueSPiana.com.github.Estudo_springboot.mapper.custom;

import HenriqueSPiana.com.github.Estudo_springboot.data.dto.v2.PersonDTOV2;
import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityTODTO(Person person){
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setNome(person.getNome());
        dto.setSobrenome(person.getSobrenome());
        dto.setDataAniversario(new Date());
        dto.setGenero(person.getGenero());
        dto.setEndereco(person.getEndereco());
        return dto;
    }


    public Person convertDTOTOEntity(PersonDTOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        //entity.setDataAniversario(new Date());
        entity.setGenero(person.getGenero());
        entity.setEndereco(person.getEndereco());
        return entity;
        
    }

}

package HenriqueSPiana.com.github.Estudo_springboot.services;
import static org.mockito.Mockito.when;
import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import HenriqueSPiana.com.github.Estudo_springboot.repository.PersonRepository;
import HenriqueSPiana.com.github.Estudo_springboot.unitetests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {
    MockPerson input;

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void findByID() {
        Person person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        var result = service.findByID(1L);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());



        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("/api/person/v1")
                && link.getType().equals("GET")
                )
        );

        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("/api/person")
                && link.getType().equals("GET")
                )

        );
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("/api/person")
                && link.getType().equals("POST")
                )
        );
        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("/api/person")
                && link.getType().equals("PUT")
                )
        );

        assertNotNull(result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("/api/person/1")
                && link.getType().equals("PUT")
                )
        );
        assertEquals("Address Test1",result.getEndereco());
        assertEquals("Last Name Test1",result.getSobrenome());
        assertEquals("First Name Test1",result.getNome());
        assertEquals("Female",result.getGenero());


    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}
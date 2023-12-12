package com.example.springbootjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AsterixServiceTest {



    @Test
    void findAll() {
        AsterixRepository repo = Mockito.mock(AsterixRepository.class);
        Mockito.when(repo.findAll()).thenReturn(
                List.of(
                        new Character("1", "Bruda", 1, "Professioneller Bruda"),
                        new Character("2", "Brudar", 2, "professioneller Brudar")

                )
        );

        AsterixService service = new AsterixService(repo);

        List<Character> actual = service.findAll(new Character("5", "Brudi", 5, "Professioneller Brudi"));

        List<Character> expected = List.of(
                new Character("1", "Bruda", 1, "Professioneller Bruda"),
                new Character("2", "Brudar", 2, "professioneller Brudar")
        );

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findById() {
        AsterixRepository repo = Mockito.mock(AsterixRepository.class);
        Mockito.when(repo.findById("3")).thenReturn(
                Optional.of(
                        new Character("3", "Brudi", 3, "Professioneller Brudi")

                )
        );

            AsterixService service = new AsterixService(repo);

            List<Character> actual = service.findAll(new Character("5", "Brudi", 5, "Professioneller Brudi"));

            List<Character> expected = List.of(
                    new Character("3", "Brudi", 3, "Professioneller Brudi"),
                    new Character("4", "Bruddi", 4, "Professioneller Bruddi")

        );
        Assertions.assertEquals(expected, actual);


    }

    @Test
    void updateCharacter() {
        AsterixRepository repo = Mockito.mock(AsterixRepository.class);
        Character updatedCharacter = new Character(
                "3", "UpdatedBrudi", 3, "Updated Professioneller Brudi"
        );
        AsterixService service = new AsterixService(repo);

        List<Character> actual = service.findAll(
                new Character("5", "Brudi", 5, "Professioneller Brudi")
        );

        List<Character> expected = List.of(
                new Character("5", "UpdatedBrudi", 5, "Updated Professioneller Brudi")
        );
        Assertions.assertEquals(expected, actual);

    }
}
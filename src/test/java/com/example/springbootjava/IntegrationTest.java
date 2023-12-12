package com.example.springbootjava;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {


    @Autowired
    private AsterixRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBrudi() throws Exception {

        // given
        repo.save(new Character("5", "Brudi", 5, "Profi Brudi" ));


        // when
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/asterix/characters")
        )
        // then
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                )
                .andExpect(
                        MockMvcResultMatchers.content().json("""
                        [
       
                        {
                            "id": "5",
                            "name": "Brudi",
                            "age": 5,
                            "profession": "Profi Brudi"
                        }
                        ]
""")
                )
        ;
    }

    @Test
    void shouldReturnUpdatedCharacter() throws Exception {

        // given
        repo.save(new Character("6", "Brd", 6, "Profi Brd"));


        // when
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/asterix/characters")
        )
        // then
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                )
                .andExpect(
                        MockMvcResultMatchers.content().json("""
                        [
                        {
                            "id": "6",
                            "name": "Brd",
                            "age": 6,
                            "profession": "Profi Brd"
                        }
                        ]
"""

                        )
                )

        ;
    }
}

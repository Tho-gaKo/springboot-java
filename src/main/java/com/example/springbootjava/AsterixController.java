package com.example.springbootjava;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService service;

    @GetMapping("/characters")
    public List<Character> getAsterixCharacters() {
        return service.findAll(new Character("5", "Brudi", 5, "Professioneller Brudi"));

    }

    @PutMapping("{id}")
    Character save(@PathVariable String id, @RequestBody Character character) {
        return service.updateCharacter(character);
    }
}
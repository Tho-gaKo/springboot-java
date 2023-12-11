package com.example.springbootjava;

import com.example.springbootjava.character.AsterixService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
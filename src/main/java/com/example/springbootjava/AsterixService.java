package com.example.springbootjava;

import com.example.springbootjava.AsterixRepository;
import com.example.springbootjava.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AsterixService {

    private final AsterixRepository repository;

    public List<Character> findAll(Character character) {
        return repository.findAll();
    }

    public void addCharacter(Character addCharacter) {
        repository.save(addCharacter);
    }
    public void removeCharacter(Character remCharacter) {
        repository.delete(remCharacter);
    }

    public Character updateCharacter(Character updateCharacter) {
        return  repository.save(updateCharacter);
    }

    public void findAllCharacters(Character getAllCharacters) {
        repository.findAll();
    }

    public void findById(Character findCharacter) {
        repository.findById(findCharacter.id());
    }
}

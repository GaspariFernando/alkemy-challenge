package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.CharactersDTO;
import com.alkemy.disney.dto.CharactersSimplDTO;
import com.alkemy.disney.dto.MoviesDTO;
import com.alkemy.disney.services.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharactersController {
    @Autowired
    private CharactersService charactersService;

    @GetMapping
    public ResponseEntity<List<CharactersSimplDTO>> getAllSimpl(){
        List<CharactersSimplDTO> characters = charactersService.getAllCharactersSimpl();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/details")
    public ResponseEntity<List<CharactersDTO>> getAll(){
        List<CharactersDTO> characters = charactersService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @PostMapping()
    public ResponseEntity<CharactersDTO> addCharacter(@RequestBody CharactersDTO character){
        CharactersDTO addedCharacter = charactersService.addCharacter(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharactersDTO>updateCharacter(@PathVariable Long id, @RequestBody CharactersDTO character){
        CharactersDTO updatedCharacter=charactersService.updateCharacter(id, character);
        return ResponseEntity.ok().body(updatedCharacter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id){
        this.charactersService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
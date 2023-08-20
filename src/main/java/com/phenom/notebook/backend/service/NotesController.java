package com.phenom.notebook.backend.service;

import com.phenom.notebook.backend.model.Note;
import com.phenom.notebook.backend.repository.NoteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class NotesController {


    private final NoteRepository noteRepository;

    @Autowired
    NotesController(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

     @GetMapping("/notes/{userId}")
    public ResponseEntity<List<Note>> getNotesByUser(@PathVariable String userId){
        try{
            return ResponseEntity.ok(noteRepository.findNotesByUserId(userId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.of(Optional.of(List.of()));
    }

    @PostMapping("/createNote/{id}/{userId}/{title}")
    public void createNote(@PathVariable String id,@PathVariable String userId ,@PathVariable String title, @RequestBody String text){
        try{
            Note newNote = new Note(id,title,text,userId);
            noteRepository.save(newNote);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @PostMapping("/deleteNote/{id}")
    public void deleteNote(@PathVariable String id){
        try{
            noteRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}

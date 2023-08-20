package com.phenom.notebook.backend.service;

import com.phenom.notebook.backend.model.Note;
import com.phenom.notebook.backend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {


    private NoteRepository noteRepository;

    @Autowired
    NotesController(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes/{userId}")
    public List<Note> getNotesByUser(@PathVariable String userId){
        try{
            return noteRepository.findNotesByUserId(userId);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @PostMapping("/createNote/{userId}/{title}")
    public void createNote(@PathVariable String userId ,@PathVariable String title, @RequestBody String text){
        try{
            Note newNote = new Note(title,text,userId);
            noteRepository.save(newNote);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/updateNote/{userId}/{title}")
    public void updateNote(@PathVariable String userId, @PathVariable String title, @RequestBody String text){

    }


}

package com.phenom.notebook.backend.repository;

import com.phenom.notebook.backend.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note,String> {

        public List<Note> findNotesByUserId(String userId);

}

package com.phenom.notebook.backend.repository;

import com.phenom.notebook.backend.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note,Long> {



}

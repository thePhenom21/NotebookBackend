package com.phenom.notebook.backend.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Note {

    private String id;
    private String title;
    private String text;


    private String userId;

    public Note(){}

    public Note(String id,String title,String text,String userId){
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.title = title;
    }


}

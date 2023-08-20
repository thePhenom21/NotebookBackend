package com.phenom.notebook.backend.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Note {

    @Id
    private String id;
    private String title;
    private String text;
    private String userId;

    public Note(){}

    public Note(String title,String text,String userId){
        this.text = text;
        this.userId = userId;
        this.title = title;
    }


}

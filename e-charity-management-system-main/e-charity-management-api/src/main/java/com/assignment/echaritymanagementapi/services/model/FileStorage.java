package com.assignment.echaritymanagementapi.services.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

public class FileStorage {

    @Id
    private String id;

    private String name;

    private Binary content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Binary getContent() {
        return content;
    }

    public void setContent(Binary content) {
        this.content = content;
    }
}

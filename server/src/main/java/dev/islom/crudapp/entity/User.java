package dev.islom.crudapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class User {

    @Id
    private String id;

    @Field
    private String firstName;
    @Field
    private String lastName;

    public User() {
    }

    ;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}


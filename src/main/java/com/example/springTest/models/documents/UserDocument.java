package com.example.springTest.models.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserDocument {
    private @Id String id;
    private String name;
    private String surname;
    private String email;
    private String username;
}

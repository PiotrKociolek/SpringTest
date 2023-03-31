package com.example.springTest.repositories;

import com.example.springTest.models.documents.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
}

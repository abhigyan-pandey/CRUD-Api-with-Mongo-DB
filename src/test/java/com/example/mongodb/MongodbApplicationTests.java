package com.example.mongodb;

import com.example.mongodb.controllers.BookController;
import com.example.mongodb.entities.Books;
import com.example.mongodb.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.mockito.*;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
//@PrepareForTest(fullyQualifiedNames = "com.example.mongodb.*")
@SpringBootTest
class MongodbApplicationTests {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookRepository bookRepository;

    @Test
    void testStaticMethods() {
        List<Books> books = new ArrayList<>();
        Mockito.when(bookRepository.findAll()).thenReturn(books);
        Assertions.assertEquals(bookController.getBooksList(), books);
    }

}

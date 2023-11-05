package org.example.test;

import org.example.Library;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        assertTrue(library.addBook("Book1", "Author1", 1234567890L, 2020));
        assertTrue(library.addBook("Book2", "Author2", 9876543210L, 2015));

        assertEquals(2, library.getSize());
    }

    @Test
    public void testAddDuplicateBook() {
        assertTrue(library.addBook("Book1", "Author1", 1234567890L, 2020));
        assertFalse(library.addBook("Book1", "Author1", 1234567890L, 2020));

        assertEquals(1, library.getSize());
    }



    @Test
    public void testDeleteBook() {
        library.addBook("Book1", "Author1", 1234567890L, 2020);
        library.addBook("Book2", "Author2", 9876543210L, 2015);

        library.deleteBook(1234567890L);

        assertEquals(1, library.getSize());
    }

    @Test
    public void testFindIndex() {
        library.addBook("Book1", "Author1", 1234567890L, 2020);
        library.addBook("Book2", "Author2", 9876543210L, 2015);

        assertEquals(0, library.findIndex(1234567890L));
        assertEquals(1, library.findIndex(9876543210L));
        assertEquals(-1, library.findIndex(1111111111L));
    }
}

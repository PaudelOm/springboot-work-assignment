package com.omsarma.crud.service;

import com.omsarma.crud.entity.BookDTO;
import com.omsarma.crud.entity.Books;
import com.omsarma.crud.repo.BookRepository;
import com.omsarma.crud.response.ServerResponse;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;


    BookDTO convertToDTO(Books book){
        return new BookDTO(book.getTitle(), book.getAuthor(), book.getPublishedYear(), book.getGenre() );
    }

    Books convertDTOtoBook(BookDTO bookDTO){
        Books book = new Books();
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setPublishedYear(bookDTO.getPublishedYear());
        book.setTitle(bookDTO.getTitle());
        return book;
    }

    public ServerResponse saveBook(BookDTO bookDto) {
        try{
            Books savedBook = bookRepo.save(convertDTOtoBook(bookDto));

            return ServerResponse.setSuccessMsg("Book Saved Successfully", HttpStatus.CREATED, convertToDTO(savedBook));
        }
         catch(Exception e){
            return ServerResponse.setFailMsg("Book Saved Failed", HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    public ServerResponse findAllBooks() {

        try {
            List<Books> booksList = bookRepo.findAll();
            List<BookDTO> responseDTOs = new ArrayList<>();
            if (booksList.isEmpty())
                return ServerResponse.setFailMsg("There are no books", HttpStatus.NO_CONTENT);
            else
                for (Books book : booksList) {
                    responseDTOs.add(convertToDTO(book));
                }
                return ServerResponse.setSuccessMsg("Books retrived Sucessfully", HttpStatus.OK, responseDTOs);
        } catch (Exception e){
            return ServerResponse.setFailMsg("Books retrival failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ServerResponse findByBookId(Long id) {
        try {
            Optional<Books> foundBook = bookRepo.findById(id);
            if(foundBook.isPresent()) {
                Books book = foundBook.get();
                return ServerResponse.setSuccessMsg("book found successfully", HttpStatus.OK, convertToDTO(book));
            } else
                return ServerResponse.setFailMsg("No such book found", HttpStatus.NOT_FOUND);
        } catch(Exception e){
            return ServerResponse.setFailMsg("Book retrieval failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    public ServerResponse updateBook(Long id, Books bookDetails) {

        try {
            Optional<Books> foundBook = bookRepo.findById(id);
            if (foundBook.isPresent()) {
                Books existingBook = foundBook.get();
                existingBook.setTitle(bookDetails.getTitle());
                existingBook.setAuthor(bookDetails.getAuthor());
                existingBook.setPublishedYear(bookDetails.getPublishedYear());
                existingBook.setGenre(bookDetails.getGenre());
                Books updatedBook = bookRepo.save(existingBook);
                return ServerResponse.setSuccessMsg("book update successfully", HttpStatus.OK, new BookDTO(updatedBook.getTitle(), updatedBook.getAuthor()));
            } else
                return ServerResponse.setFailMsg("No such book found", HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            return ServerResponse.setFailMsg("Book update failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ServerResponse deleteBookById(Long id) {

        try{
            Optional<Books> foundBook = bookRepo.findById(id);
            if (foundBook.isPresent()){
                bookRepo.deleteById(id);
                return ServerResponse.setSuccessMsg("Book Deleted Successfully", HttpStatus.OK);
            }else
                return ServerResponse.setFailMsg("No such book found", HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            return ServerResponse.setFailMsg("Book Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

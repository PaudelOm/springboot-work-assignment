package com.omsarma.crud.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.omsarma.crud.entity.BookDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)       // remove the null object from the response api
public class ServerResponse {

    private String message;
    private HttpStatus status;

    private BookDTO bookDTO;

    private List<BookDTO> bookDTOList;

    public ServerResponse() {
    }

    public ServerResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ServerResponse(String message, HttpStatus status, List<BookDTO> bookDTOs) {
        this.message = message;
        this.status = status;
        this.bookDTOList = bookDTOs;
    }

    public ServerResponse(String message, HttpStatus status, BookDTO bookDTO) {
        this.message = message;
        this.status = status;
        this.bookDTO = bookDTO;
    }

    public static ServerResponse setSuccessMsg(String message, HttpStatus status, List<BookDTO> bookDTOs){
        return new ServerResponse(message, status, bookDTOs);
    }

    public static ServerResponse setSuccessMsg(String message, HttpStatus status, BookDTO bookDTO){
        return new ServerResponse(message, status, bookDTO);
    }

    public static ServerResponse setSuccessMsg(String message, HttpStatus status) {
        return new ServerResponse(message, status);
    }

    public static ServerResponse setFailMsg(String message, HttpStatus status){
        return new ServerResponse(message, status);
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }
}

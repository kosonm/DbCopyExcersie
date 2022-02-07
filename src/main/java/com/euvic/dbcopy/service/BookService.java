package com.euvic.dbcopy.service;

import com.euvic.dbcopy.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooksNotCopied();

    long count();
}

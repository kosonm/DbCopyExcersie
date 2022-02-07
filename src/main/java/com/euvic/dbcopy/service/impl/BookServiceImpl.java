package com.euvic.dbcopy.service.impl;

import com.euvic.dbcopy.model.Book;
import com.euvic.dbcopy.repository.BookRepository;
import com.euvic.dbcopy.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAllBooksNotCopied() {
        return bookRepository.findAllBooksNotCopied();
    }

    @Override
    public long count() {
        return bookRepository.count();
    }
}

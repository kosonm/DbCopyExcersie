package com.euvic.dbcopy.repository;

import com.euvic.dbcopy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// no need for @Repository annotation bc JpaRepository already has it
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b.* FROM BOOK b  WHERE NOT EXISTS(SELECT 1 FROM COPIED_BOOK c WHERE c.TITLE = b.TITLE )", nativeQuery = true)
    List<Book> findAllBooksNotCopied();

}

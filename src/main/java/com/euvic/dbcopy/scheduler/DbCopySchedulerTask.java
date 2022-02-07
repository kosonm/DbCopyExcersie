package com.euvic.dbcopy.scheduler;

import com.euvic.dbcopy.model.Book;
import com.euvic.dbcopy.model.CopiedBook;
import com.euvic.dbcopy.service.BookService;
import com.euvic.dbcopy.service.CopiedBookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DbCopySchedulerTask {

    private static final Logger log = LoggerFactory.getLogger(DbCopySchedulerTask.class);

    private static int count = 0;

    private final BookService bookService;

    private final CopiedBookService copiedBookService;

    @Scheduled(fixedDelayString = "${my.fixed.delay}")
    public void copyValues() {
        count++;

        log.info("DbCopySchedulerTask number " + count);
        log.info("DbCopySchedulerTask started at: " + System.currentTimeMillis() / 1000);

        List<Book> books = bookService.findAllBooksNotCopied();
        List<CopiedBook> copiedBooks = new ArrayList<>();

        for (Book book : books) {
            copiedBooks.add(getCopiedBook(book));
        }

        copiedBookService.saveAll(copiedBooks);

        log.info("DbCopySchedulerTask copied " + books.size() + " books.");
        log.info("DbCopySchedulerTask ended at: " + System.currentTimeMillis() / 1000);
    }

    public CopiedBook getCopiedBook(Book book) {
        CopiedBook copiedBook = new CopiedBook();
        copiedBook.setAuthor(book.getAuthor());
        copiedBook.setTitle(book.getTitle());
        return copiedBook;
    }

}

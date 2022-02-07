package com.euvic.dbcopy.unit;

import com.euvic.dbcopy.model.Book;
import com.euvic.dbcopy.model.CopiedBook;
import com.euvic.dbcopy.scheduler.DbCopySchedulerTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DbCopySchedulerTaskTest {

    @Test
    void shouldReturnCopiedBookObject(){
        // Given
        Book book = new Book();
        book.setAuthor("Test Author");
        book.setTitle("Test Title");
        DbCopySchedulerTask dbCopySchedulerTask = new DbCopySchedulerTask(null, null);

        // When
        CopiedBook copiedBook = dbCopySchedulerTask.getCopiedBook(book);
        // Then
        assertThat(copiedBook).isNotNull();
        assertThat(copiedBook.getAuthor()).isEqualTo("Test Author");
        assertThat(copiedBook.getTitle()).isEqualTo("Test Title");

    }
}

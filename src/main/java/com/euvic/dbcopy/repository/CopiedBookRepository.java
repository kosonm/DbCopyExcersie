package com.euvic.dbcopy.repository;

import com.euvic.dbcopy.model.CopiedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopiedBookRepository extends JpaRepository<CopiedBook, Long> {

}

package com.euvic.dbcopy.service;


import com.euvic.dbcopy.model.CopiedBook;

import java.util.List;

public interface CopiedBookService {

    List saveAll(Iterable<CopiedBook> entities);

    long count();
}

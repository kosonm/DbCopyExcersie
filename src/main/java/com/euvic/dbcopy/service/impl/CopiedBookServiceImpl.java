package com.euvic.dbcopy.service.impl;

import com.euvic.dbcopy.model.CopiedBook;
import com.euvic.dbcopy.repository.CopiedBookRepository;
import com.euvic.dbcopy.service.CopiedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopiedBookServiceImpl implements CopiedBookService {

    private final CopiedBookRepository copiedBookRepository;

    @Override
    public List saveAll(Iterable<CopiedBook> entities) {
        return copiedBookRepository.saveAll(entities);
    }

    @Override
    public long count() {
        return copiedBookRepository.count();
    }


}

package com.euvic.dbcopy.controller;

import com.euvic.dbcopy.service.BookService;
import com.euvic.dbcopy.service.CopiedBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    private final CopiedBookService copiedBookService;

    private final ObjectMapper objectMapper;

    @GetMapping("/count")
    public ObjectNode getCount() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("bookCount", bookService.count());
        objectNode.put("copiedBookCount", copiedBookService.count());
        return objectNode;
    }

}

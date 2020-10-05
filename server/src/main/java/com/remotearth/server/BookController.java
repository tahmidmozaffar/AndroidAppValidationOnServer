package com.remotearth.server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    // valid signature
    private static final String SIGNATURE = "yq6BmfrS7OkuDG5J90W1zYEjRjY=";

    // invalid signature
    // private static final String SIGNATURE = "bvkLtY9uMu48Z/8I7kTtOGxkh3o=";

    @PostMapping("/books")
    List<Book> getBooks(@RequestHeader("signature") String signature) {

        if (signature.equals(SIGNATURE)) {
            return DummyData.getDummyBooks();
        }

        return new ArrayList<>();

    }

}

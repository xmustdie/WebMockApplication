package ru.nsk.mock.utils;

import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Andrei Durkin <a.durkin@goodt.me>
 * @created 08.06.2022
 */


public final class Responses {
    public Responses() {
    }

    public static ResponseEntity<Void> created(URI uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    public static ResponseEntity<Void> ok() {
        return new ResponseEntity(HttpStatus.OK);
    }
}

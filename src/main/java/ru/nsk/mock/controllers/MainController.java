package ru.nsk.mock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsk.mock.services.SaveService;
import ru.nsk.mock.utils.Responses;

import java.util.Map;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

/**
 * @author Andrei Durkin <a.durkin@goodt.me>
 * @created 08.06.2022
 */

@RestController
@RequestMapping(value = "/", consumes = TEXT_PLAIN_VALUE)

public class MainController {

    @Autowired
    private SaveService service;

    @PostMapping("SAPHostControl")
    public ResponseEntity<Void> firstEndPointMethod(@RequestHeader Map headers,
                                                    @RequestBody String resource) {

        service.saveData(headers, resource);
        return Responses.ok();
    }

    @PostMapping("SAPHostControl.cgi")
    public ResponseEntity<Void> secondEndPointMethod(@RequestHeader Map headers,
                                                     @RequestBody String resource) {
        service.saveData(headers, resource);
        return Responses.ok();
    }
}

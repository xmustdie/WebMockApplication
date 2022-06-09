package ru.nsk.mock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsk.mock.services.SaveService;
import ru.nsk.mock.utils.Responses;

import java.util.Map;

/**
 * @author Andrei Durkin <a.durkin@goodt.me>
 * @created 08.06.2022
 */

@RestController
@RequestMapping(value = "/")
public class MainController {

    final String SAPHostControl = "SAPHostControl";
    final String SAPHostControlCgi = "SAPHostControl.cgi";

    @Autowired
    private SaveService service;

    @PostMapping("SAPHostControl")
    public ResponseEntity<Void> firstEndPointMethod(@RequestHeader Map headers,
                                                    @RequestBody String resource) {
        service.saveData(headers, resource, "POST : " + SAPHostControl);
        return Responses.ok();
    }

    @PostMapping("SAPHostControl.cgi")
    public ResponseEntity<Void> secondEndPointMethod(@RequestHeader Map headers,
                                                     @RequestBody String resource) {
        service.saveData(headers, resource, "POST : " + SAPHostControlCgi);
        return Responses.ok();
    }

    @PutMapping("SAPHostControl")
    public ResponseEntity<Void> thirdEndPointMethod(@RequestHeader Map headers,
                                                    @RequestBody String resource) {
        service.saveData(headers, resource, "PUT : " + SAPHostControl );
        return Responses.ok();
    }

    @PutMapping("SAPHostControl.cgi")
    public ResponseEntity<Void> forthEndPointMethod(@RequestHeader Map headers,
                                                     @RequestBody String resource) {
        service.saveData(headers, resource, "PUT : " + SAPHostControlCgi);
        return Responses.ok();
    }

    @GetMapping("SAPHostControl")
    public ResponseEntity<Void> fifthEndPointMethod(@RequestHeader Map headers) {
        String resource = "===no data===";
        service.saveData(headers, resource, "GET : " + SAPHostControl);
        return Responses.ok();
    }

    @GetMapping("SAPHostControl.cgi")
    public ResponseEntity<Void> sixEndPointMethod(@RequestHeader Map headers) {
        String resource = "===no data===";
        service.saveData(headers, resource, "GET : " +  SAPHostControlCgi);
        return Responses.ok();
    }
}

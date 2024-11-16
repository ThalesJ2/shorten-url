package br.com.encurtaurl.controllers;

import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/urls")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity<Url> create(@RequestBody Url url) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.create(url));
    }

    @GetMapping("/{tinyUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String tinyUrl) {
        Url url = urlService.findByTinyUrl(tinyUrl);
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header("Location", url.getOriginalUrl()).build();
    }
}

package br.com.encurtaurl.controllers;

import br.com.encurtaurl.dtos.RequestUrlDTO;
import br.com.encurtaurl.dtos.UrlProjectionDTO;
import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.services.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urls")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<RequestUrlDTO> create(@RequestBody RequestUrlDTO dto , HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.create(dto,request));
    }

    @GetMapping("/{tinyUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String tinyUrl, HttpServletRequest request) {
        UrlProjectionDTO url = urlService.findByTinyUrl(tinyUrl,request);
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header("Location", url.originalUrl()).build();
    }
}

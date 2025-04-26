package com.volpe.encurtador.web.rest;

import com.volpe.encurtador.domain.Url;
import com.volpe.encurtador.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/urls")
public class UrlResource {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<Url> shortenUrl(@RequestBody final String url) {

        Url savedUrl = urlService.saveUrl(url);

        return new ResponseEntity<>(savedUrl, HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Url> getAllUrls() {
        return urlService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Url> getUrlById(@PathVariable final Long id) {
        Optional<Url> url = urlService.getUrlById(id);
        return url.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

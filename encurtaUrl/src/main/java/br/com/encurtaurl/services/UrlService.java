package br.com.encurtaurl.services;

import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.exceptions.ResourceNotFoundException;
import br.com.encurtaurl.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UrlService {

    private final static String BASE_64 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final static Integer SIZE_URL = 8;
    @Autowired
    private UrlRepository urlRepository;


    @Transactional(readOnly = true)
    public Url findByTinyUrl(String tinyUrl) {
        return urlRepository.findByTinyUrl(tinyUrl).orElseThrow(()
                -> new ResourceNotFoundException("tinyUrl not found"));
    }


    @Transactional
    public Url create(Url url) {
        url.setTinyUrl(generateTinyUrl());
        return urlRepository.save(url);
    }


    String generateTinyUrl(){
        StringBuilder tinyUrl = new StringBuilder();
        for(int i = 0; i < SIZE_URL; i++){
            tinyUrl.append(BASE_64.charAt((int)(Math.random() * BASE_64.length())));
        }
        return tinyUrl.toString();
    }
}

package br.com.encurtaurl.services;

import br.com.encurtaurl.dtos.UrlDTO;
import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.exceptions.ResourceNotFoundException;
import br.com.encurtaurl.projections.UrlProjection;
import br.com.encurtaurl.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Service
public class UrlService {

    private final static String BASE_64 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final static Integer SIZE_URL = 8;
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private IpInfoService ipInfoService;


    @Transactional(readOnly = true)
    public UrlDTO findByTinyUrl(String tinyUrl) {
        UrlProjection projection = urlRepository.getUrlBy(tinyUrl).orElseThrow(()-> new ResourceNotFoundException("url not found"));
        return new UrlDTO(projection);
    }


    @Transactional
    public Url create(Url url) {
        System.out.println(ipInfoService.getAddressByIp("2.22.51.255"));
        url.setTinyUrl(generateTinyUrl());
        System.out.println(convertToUtc(url.getExpiration()));
        LocalDateTime now = convertToUtc(url.getExpiration());
        if(url.getExpiration() != null)
            url.setExpiration(now);


        return urlRepository.save(url);
    }


    String generateTinyUrl(){
        StringBuilder tinyUrl = new StringBuilder();
        for(int i = 0; i < SIZE_URL; i++){
            tinyUrl.append(BASE_64.charAt((int)(Math.random() * BASE_64.length())));
        }
        return tinyUrl.toString();
    }

    LocalDateTime convertToUtc(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault())
                .withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();

    }
}

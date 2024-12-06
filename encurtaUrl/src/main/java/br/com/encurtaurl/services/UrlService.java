package br.com.encurtaurl.services;

import br.com.encurtaurl.dtos.url.RequestUrlDTO;
import br.com.encurtaurl.dtos.url.UrlProjectionDTO;
import br.com.encurtaurl.entities.Metric;
import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.exceptions.ResourceNotFoundException;
import br.com.encurtaurl.projections.UrlProjection;
import br.com.encurtaurl.repositories.MetricRepository;
import br.com.encurtaurl.repositories.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class UrlService {

    private final static String BASE_64 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final static Integer SIZE_URL = 8;
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private IpInfoService ipInfoService;

    @Autowired
    private MetricRepository metricRepository;


    @Transactional
    public UrlProjectionDTO findByTinyUrl(String tinyUrl,HttpServletRequest request) {
        UrlProjection projection = urlRepository.getUrlBy(tinyUrl).orElseThrow(()-> new ResourceNotFoundException("url not found"));
        String ip = getIp(request);
        Metric metric =  ipInfoService.getAddressByIp(ip);
        long clicks = metricRepository.count()+1;
        metric.setClick(clicks);
        metric  = metricRepository.save(metric);
        return new UrlProjectionDTO(projection);
    }


    @Transactional
    public RequestUrlDTO create(RequestUrlDTO dto , HttpServletRequest request) {
        String ip = getIp(request);
        Metric metric = ipInfoService.getAddressByIp(ip);
        Url url = new Url(dto);
        url.setTinyUrl(generateTinyUrl());
        if(url.getExpiration() != null)
        {
            LocalDateTime converted = convertToUtc(url.getExpiration(),metric.getTimezone());
            url.setExpiration(converted);
        }
        System.out.println();
        url = urlRepository.save(url);
        return new RequestUrlDTO(url);
    }

    String generateTinyUrl(){
        StringBuilder tinyUrl = new StringBuilder();
        for(int i = 0; i < SIZE_URL; i++){
            tinyUrl.append(BASE_64.charAt((int)(Math.random() * BASE_64.length())));
        }
        return tinyUrl.toString();
    }

    LocalDateTime convertToUtc(LocalDateTime localDateTime, String timezone){
            ZonedDateTime zoneSystem = localDateTime.atZone(ZoneId.of(timezone));
         return zoneSystem.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    }

    String getIp(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if(ip != null)
            return ip;
        return request.getRemoteAddr();
    }
}

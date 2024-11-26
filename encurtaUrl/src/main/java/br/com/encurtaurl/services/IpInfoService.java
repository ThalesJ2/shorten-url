package br.com.encurtaurl.services;

import br.com.encurtaurl.entities.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ipinfo", url = "https://ipinfo.io/")
public interface IpInfoService {

    @GetMapping("/{ip}")
    Address getAddressByIp(@PathVariable String ip);

}

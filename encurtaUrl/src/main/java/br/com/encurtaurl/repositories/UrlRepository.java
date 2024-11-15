package br.com.encurtaurl.repositories;

import br.com.encurtaurl.entities.Url;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {

    Optional<Url> findByTinyUrl(String tinyUrl);
}

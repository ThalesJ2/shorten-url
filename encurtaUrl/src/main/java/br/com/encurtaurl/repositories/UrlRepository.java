package br.com.encurtaurl.repositories;

import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.projections.UrlProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {

    Optional<Url> findByTinyUrl(String tinyUrl);

    @Query(nativeQuery = true , value = """
    SELECT url.id,url.tiny_url,url.original_url,url.expiration FROM url 
    where (url.expiration >= CURRENT_TIMESTAMP(0) or expiration IS NULL)
    and url.tiny_url = :tinyUrl
    """)
    Optional<UrlProjection> getUrlBy(String tinyUrl);
}

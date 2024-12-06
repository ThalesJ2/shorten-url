package br.com.encurtaurl.repositories;

import br.com.encurtaurl.entities.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {

}

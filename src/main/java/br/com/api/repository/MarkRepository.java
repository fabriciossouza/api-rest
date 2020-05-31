package br.com.api.repository;

import br.com.api.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    Mark findByName(String name);
}

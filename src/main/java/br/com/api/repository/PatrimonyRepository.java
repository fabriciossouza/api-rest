package br.com.api.repository;

import br.com.api.entity.Patrimony;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatrimonyRepository extends JpaRepository<Patrimony, Long> {

    List<Patrimony> findAllPatrimoniesByMarkId(Long id);
}

package br.com.acervocesar.repositorios;

import br.com.acervocesar.entidades.producao.Producao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RepositorioProducoes extends JpaRepository<Producao, Integer> {
}

package br.com.gerenciamento.spring_boot.repository;

import br.com.gerenciamento.spring_boot.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtosRepository extends JpaRepository<Produtos,Integer> {


}

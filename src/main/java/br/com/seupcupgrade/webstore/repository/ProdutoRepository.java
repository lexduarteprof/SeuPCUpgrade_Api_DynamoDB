package br.com.seupcupgrade.webstore.repository;

import br.com.seupcupgrade.webstore.document.Produtos;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ProdutoRepository extends CrudRepository<Produtos, Long> {

}

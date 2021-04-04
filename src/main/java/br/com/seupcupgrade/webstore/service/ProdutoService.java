package br.com.seupcupgrade.webstore.service;

import br.com.seupcupgrade.webstore.document.Produtos;
import br.com.seupcupgrade.webstore.repository.ProdutoRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){

        this.produtoRepository = produtoRepository;
    }

    public Flux<Produtos> findAll(){

        return Flux.fromIterable(this.produtoRepository.findAll());

    }

    public Mono <Produtos> findByIdProduto(Long Id){

        return Mono.justOrEmpty(this.produtoRepository.findById(Id));

    }

    public Mono <Produtos> save (Produtos produtos){

        return Mono.justOrEmpty(this.produtoRepository.save(produtos));

    }


    public Mono <Boolean> deleteByProduto (Long Id){

        produtoRepository.deleteById(Id);
        return Mono.just(true);
    }




}

package br.com.seupcupgrade.webstore.controller;

import br.com.seupcupgrade.webstore.repository.ProdutoRepository;
import br.com.seupcupgrade.webstore.document.Produtos;
import br.com.seupcupgrade.webstore.controller.ProdutoController;
import br.com.seupcupgrade.webstore.service.ProdutoService;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.com.seupcupgrade.webstore.constants.ProdutoConstants.*;

@RestController
@Slf4j

public class ProdutoController {

    ProdutoService produtoService;
    ProdutoRepository produtoRepository;


    //private static final org.slf4j.Logger log =
    //        org.slf4j.LoggerFactory.getLogger(ProdutoController.class);  // (já gerado automaticamente)

    public ProdutoController (ProdutoService produtoService, ProdutoRepository produtoRepository){

        this.produtoService = produtoService;
        this.produtoRepository = produtoRepository;

    }

    @GetMapping(PRODUTOS_ENDPOINT_LOCAL)
    public Flux<Produtos> getAllProdutos(){

        log.info("requesting all Produtos");
        return produtoService.findAll();

    }

    @GetMapping(PRODUTOS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Produtos>> findByIdProduto(@PathVariable Long id){

        log.info("requesting Produto by ID " + id);
        return produtoService.findByIdProduto(id)
                .map((item) -> new ResponseEntity<>(item,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(PRODUTOS_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Produtos> createProduto(@RequestBody Produtos produto){
        log.info("Novo Produto Criado");

        return produtoService.save(produto);

    }

    @DeleteMapping(PRODUTOS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code =  HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteByIdProduto(@PathVariable Long id){

        produtoService.deleteByProduto(id);
        log.info("Produto Id "+ id + " deletado!");

        return Mono.just(HttpStatus.NOT_FOUND);


    }




}

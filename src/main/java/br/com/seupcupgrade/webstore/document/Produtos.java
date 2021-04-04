package br.com.seupcupgrade.webstore.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "NProdutos_Table")
public class Produtos {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    Long id;

    @DynamoDBAttribute(attributeName = "prd_titulo")
    String prd_titulo;
    @DynamoDBAttribute(attributeName = "prd_fabricante")
    String prd_fabricante;
    @DynamoDBAttribute(attributeName = "prd_preco")
    Double prd_preco;
    @DynamoDBAttribute(attributeName = "prd_precoaqusicao")
    Double prd_precoaqusicao;
    @DynamoDBAttribute(attributeName = "prd_qtestoque")
    int prd_qtestoque;
    @DynamoDBAttribute(attributeName = "prd_descricao")
    String prd_descricao;

    public Produtos(Long id, String prd_titulo, String prd_fabricante, Double prd_preco,
                    Double prd_precoaqusicao, int prd_qtestoque, String prd_descricao) {
        this.id = id;
        this.prd_titulo = prd_titulo;
        this.prd_fabricante = prd_fabricante;
        this.prd_preco = prd_preco;
        this.prd_precoaqusicao = prd_precoaqusicao;
        this.prd_qtestoque = prd_qtestoque;
        this.prd_descricao = prd_descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrd_titulo() {
        return prd_titulo;
    }

    public void setPrd_titulo(String prd_titulo) {
        this.prd_titulo = prd_titulo;
    }

    public String getPrd_fabricante() {
        return prd_fabricante;
    }

    public void setPrd_fabricante(String prd_fabricante) {
        this.prd_fabricante = prd_fabricante;
    }

    public Double getPrd_preco() {
        return prd_preco;
    }

    public void setPrd_preco(Double prd_preco) {
        this.prd_preco = prd_preco;
    }

    public Double getPrd_precoaqusicao() {
        return prd_precoaqusicao;
    }

    public void setPrd_precoaqusicao(Double prd_precoaqusicao) {
        this.prd_precoaqusicao = prd_precoaqusicao;
    }

    public int getPrd_qtestoque() {
        return prd_qtestoque;
    }

    public void setPrd_qtestoque(int prd_qtestoque) {
        this.prd_qtestoque = prd_qtestoque;
    }

    public String getPrd_descricao() {
        return prd_descricao;
    }

    public void setPrd_descricao(String prd_descricao) {
        this.prd_descricao = prd_descricao;
    }
}

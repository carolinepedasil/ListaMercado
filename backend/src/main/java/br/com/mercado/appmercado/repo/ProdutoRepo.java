package br.com.mercado.appmercado.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.mercado.appmercado.model.Produto;

public interface ProdutoRepo extends CrudRepository<Produto, Integer>{

}

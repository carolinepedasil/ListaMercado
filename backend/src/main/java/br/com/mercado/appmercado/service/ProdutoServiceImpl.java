package br.com.mercado.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mercado.appmercado.model.Produto;
import br.com.mercado.appmercado.repo.ProdutoRepo;

@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoRepo repo;
	
	@Override
	public Produto criarNovoProduto(Produto prod) {
		return repo.save(prod);
	}

	@Override
	public Produto alterarProduto(Produto prod) {
		return null;
	}

	@Override
	public List<Produto> listarTodos() {
		return null;
	}

	@Override
	public List<Produto> buscarPorPalavraChave(String key) {
		return null;
	}

	@Override
	public Produto buscarPorId(Integer id) {
		return null;
	}

}

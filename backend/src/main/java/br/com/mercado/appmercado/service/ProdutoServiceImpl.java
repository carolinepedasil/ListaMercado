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
		if (prod.getNome() == null || prod.getNome().length() == 0) return null;
		return repo.save(prod);
	}

	@Override
	public List<Produto> listarTodos() {
		return null;
	}

	@Override
	public List<Produto> buscarPorPalavraChave(String key) {
		return repo.findAllByNomeContaining(key);
	}

	@Override
	public Produto buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}

}

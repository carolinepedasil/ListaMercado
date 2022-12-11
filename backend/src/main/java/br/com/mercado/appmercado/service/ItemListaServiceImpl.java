package br.com.mercado.appmercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mercado.appmercado.model.ItemLista;
import br.com.mercado.appmercado.repo.ItemListaRepo;

@Component
public class ItemListaServiceImpl implements IItemListaService {

	@Autowired
	private ItemListaRepo repo;
	
	@Override
	public ItemLista inserirItem(ItemLista novo) { // não vem com id
		return repo.save(novo);
	}

	@Override
	public ItemLista alterarItem(ItemLista item) { // vem com id
		return repo.save(item);
	}

	@Override
	public void removerItem(Integer numSeq) {
		repo.deleteById(numSeq);
	}

}

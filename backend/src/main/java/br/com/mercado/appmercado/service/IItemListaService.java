package br.com.mercado.appmercado.service;

import br.com.mercado.appmercado.model.ItemLista;

public interface IItemListaService {
	
	public ItemLista inserirItem(ItemLista novo);
	public ItemLista alterarItem(ItemLista item);
	public void removerItem(Integer numSeq);

}

package br.com.mercado.appmercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.appmercado.model.ItemLista;
import br.com.mercado.appmercado.service.IItemListaService;

@RestController
public class ItemListaController {
	
	@Autowired
	private IItemListaService service;
	
	@PostMapping("/itemLista")
	public ResponseEntity<ItemLista> inserir(@RequestBody ItemLista novo) {
		ItemLista res = service.inserirItem(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/itemLista/{numSeq}")
	public ResponseEntity<ItemLista> alterar(@RequestBody ItemLista item, @PathVariable Integer numSeq) {
		item.setNumSeq(numSeq);
		ItemLista res = service.alterarItem(item);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/itemLista/{numSeq}")
	public ResponseEntity<?> apagar(@PathVariable Integer numSeq) {
		service.removerItem(numSeq);
		return ResponseEntity.ok("ok");
	}
	
}

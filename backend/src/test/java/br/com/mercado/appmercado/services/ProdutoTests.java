package br.com.mercado.appmercado.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.mercado.appmercado.model.Produto;
import br.com.mercado.appmercado.repo.ProdutoRepo;
import br.com.mercado.appmercado.service.IProdutoService;
import br.com.mercado.appmercado.service.ProdutoServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTests {
	
	@InjectMocks
	private ProdutoServiceImpl service;
	
	@Mock
	private ProdutoRepo repo;
	
	private Integer existingId = 1;
	private Integer nonExistingId = 100;
	private String keyword = "bolacha";
	private Produto newProduct;
	private Produto createdProduct;
	private ArrayList<Produto> listaDeVariosProdutos;
	
	@BeforeEach
	public void setup() throws Exception {
		newProduct = new Produto();
		newProduct.setNome("Bolacha");
		
		createdProduct = new Produto();
		createdProduct.setId(1);
		createdProduct.setNome("Bolacha");
		
		listaDeVariosProdutos = new ArrayList<Produto>();
		Produto p1, p2;
		p1 = new Produto();
		p1.setId(2);
		p1.setNome("Bolacha recheada");
		p2 = new Produto();
		p2.setId(3);
		p2.setNome("Bolacha água e sal");
		listaDeVariosProdutos.add(p1);
		listaDeVariosProdutos.add(p2);
		
		Mockito.when(repo.save(newProduct)).thenReturn(createdProduct);
		Mockito.when(repo.findById(existingId)).thenReturn(Optional.of(new Produto()));
		Mockito.when(repo.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
		Mockito.when(repo.findAllByNomeContaining("Biscoito")).thenReturn(new ArrayList<Produto>());
		Mockito.when(repo.findAllByNomeContaining(keyword)).thenReturn(listaDeVariosProdutos);
		
	}
	
	@Test
	public void deveriaCadastrarProduto() {
		assertEquals(service.criarNovoProduto(newProduct), createdProduct);
	}
	
	@Test
	public void deveriaRetornarPeloId() {
		assertNotNull(service.buscarPorId(existingId));
	}
	
	@Test
	public void deveriaNaoEncontrarId() {
		assertNull(service.buscarPorId(nonExistingId));
	}
	
	@Test
	public void deveriaRetornarListaComPalavraChave() {
		assertTrue(service.buscarPorPalavraChave(keyword).size() > 0);
	}
	
	@Test
	public void deveriaRetornarListaVazia() {
		assertTrue(service.buscarPorPalavraChave("Biscoito").size() == 0);
	}
	
	
//	@Autowired
//	private IProdutoService service;
////	private static ProdutoServiceImpl service;
//	private static Integer idFound = 1;
//	private static Integer idNotFound = 100;
//	private static Produto newProduct;
//	private static Produto createdProduct;
//	
//	@BeforeAll
//	public static void setup() {
//		System.out.println("Configurando parametros de testes");
//		newProduct = new Produto();
//		newProduct.setNome("Bolacha");
//		
//		createdProduct = new Produto();
//		createdProduct.setNome("Bolacha");
//		createdProduct.setId(1);
//		
//		/*
//		service = Mockito.mock(ProdutoServiceImpl.class);
//		Mockito.when(service.criarNovoProduto(newProduct)).thenReturn(new Produto());
//		Mockito.when(service.buscarPorId(idFound)).thenReturn(createdProduct);
//		Mockito.when(service.buscarPorId(idNotFound)).thenReturn(null);
//		Mockito.when(service.buscarPorPalavraChave("b")).thenReturn(new ArrayList<Produto>());
//		Mockito.when(service.listarTodos()).thenReturn(new ArrayList<Produto>());
//		Mockito.when(service.alterarProduto(createdProduct)).thenReturn(createdProduct);
//		*/
//	}
//	
//	@Test
//	public void shouldStoreProduct() {
//		assertNotNull(service.criarNovoProduto(newProduct));
//	}

}

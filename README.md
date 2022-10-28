# Lista de Mercado

- Gerenciamento de várias listas de mercado
- Marcar o status como concluído ou não
- Cadastro de produtos
- Consulta de produtos
- Inclusão de produtos nas listas
- Especificação da quantidada de produtos
- Marcação se o produto já foi comprado ou não
- Atribuição de valores aos produtos
- Inclusão de quantidade (kg, unidades, litros, etc)

## Funcionalidades:

|         |                             |    |                                                                                                                                              |
| ------- | --------------------------- | -- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| Produto |                             |    |                                                                                                                                              |
|         | Cadastrar produtos          |    | Informar o nome de um determinado produto e o sistema o armazena no banco                                                                    |
|         | Consultar produtos          |    | Informar palavras chaves para consultar ou buscar produtos a partir de uma lista                                                             |
|         | Consultar produtos pelo ID  |    | Informar o ID do produto e receber sua descrição                                                                                             |
| Lista   |                             |    |                                                                                                                                              |
|         | Criação de listas           |    | Criar uma nova lista inserindo a data e o local onde foi feita a compra                                                                      |
|         | Apagar uma lista            |    | Remover uma lista que foi criada por engano e remover todos os seus itens que foram criados                                                  |
|         | Inserção de itens na lista  |    | Criar um item associando a uma lista e a um produto, bem como deixar disponível a possibilidade de modificar quantidade e preço que foi pago |
|         | Alteração de itens da lista |    | Alterar apenas quantidade, preço pago e status                                                                                               |
|         | Remoção de itens da lista   |    | Poder remover um item que foi cadastrado na lista                                                                                            |
|         | Fechamento da lista         |    | Concluir a lista como sendo completa e gerar seu custo total a partir dos itens comprados                                                    |

## Projeto desenvolvido em:

- Java e Spring Boot no Back-End
- Angular com TypeScript no Front-End
- MySQL (Banco de Dados)
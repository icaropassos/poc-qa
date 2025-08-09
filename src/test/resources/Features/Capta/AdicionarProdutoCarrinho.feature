#language: pt

Funcionalidade: Incluir produtos no carrinho

Cenario: Realizar inclusão de um produto no carrinho

 Dado que estou no Capta
 E acesso com uma consultora válida
 Quando estou na tela do carrinho do capta
 E insiro o código do produto '76421'
 E insiro a quantidade '6' para o produto
 E clico no botão adicionar
 Então devo visualizar que o produto foi adicionado no carrinho com sucesso
 E que a pontuação da marca é > 0 
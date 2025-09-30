#language: pt
@regressao @capta
Funcionalidade: Realizar Pedido com Captação em Trânsito

Background:
  Dado que estou autenticado no sistema

Cenario: Realizar pedido com captação em trânsito que tenha impacto no prazo de entrega
  Dado que esteja sendo realizado um pedido que tenha um produto sem estoque nos CDs primário e secundário da consultora e tenha estoque em trânsito apenas no CD que tenha impacto no prazo de entrega
  Quando inserir o produto no carrinho
  Então deverá ser exibida a mensagem de produto indisponível com a opção de incluir o produto adiando a entrega do pedido.
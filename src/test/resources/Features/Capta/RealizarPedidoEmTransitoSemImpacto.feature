#language: pt
@regressao @capta
Funcionalidade: Realizar pedido com captação em trânsito sem impacto no prazo de entrega

Background:
  Dado que estou autenticado no sistema

Cenario: Realizar pedido com captação em trânsito sem impacto no prazo de entrega
  Dado que esteja sendo realizado um pedido que tenha um produto sem estoque nos CDs primário e secundário da consultora e tenha estoque em trânsito apenas em ambos os CDs, porém um deles não tem impacto no prazo de entrega e outro tem
  Quando inserir o produto no carrinho
  Então o item deverá ser inserido no carrinho, alocando no CD que não possui impacto no prazo com a captação em trânsito

# TODO: parametrizar dados e ajustar frases conforme a regra de negócio
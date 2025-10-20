#language: pt
@regressao @capta
Funcionalidade: Acessar a página principal de login

Background:
  Dado que estou autenticado no sistema

Cenario: CT01 - Usuário acessa a página principal de login
  Dado que o usuário acessa a página principal de login localizada em {https://www.saucedemo.com/}
  Quando a página é carregada completamente
  Então o sistema deve mostrar a tela de login com sucesso

# TODO: parametrizar dados e ajustar frases conforme a regra de negócio
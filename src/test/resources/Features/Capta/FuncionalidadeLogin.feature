#language: pt
@regressao @login
Funcionalidade: Login no Portal da Consultoria

Background:
  Dado que a consultora esteja na página de login do portal (https://consultoria-hml.natura.com.br/webfv/)

Cenário: Login com credenciais válidas redireciona para dashboard
  Dado que o campo "Login" esteja visível
  E que o campo "Senha" esteja visível
  Quando a consultora informar o código de consultora "800619" e a senha "senha123" e clicar no botão "Entrar"
  Então o sistema deve validar as credenciais
  E redirecionar a consultora para a página inicial (dashboard) do portal
  E a página de dashboard deve ser exibida com o conteúdo esperado

# TODO: parametrizar dados e ajustar frases conforme a regra de negócio
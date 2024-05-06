Feature: Cadastro com senhas diferentes

  Scenario: Tentativa de cadastro com senhas diferentes
    Given que estou na tela de login
    And vá para a tela de cadastro e faça o cadastro do usuário "Matheus" e senha "123" e confirmação de senha "321"
    Then devo ver uma mensagem de erro dizendo que as senhas não conferem
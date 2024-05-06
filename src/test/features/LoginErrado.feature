Feature: Login errado

  Scenario: Tentativa de login com usuário inexistente
    Given que estou na tela de login
    When tento fazer login com usuário "Matheus" e senha "123"
    Then devo ver uma mensagem de erro
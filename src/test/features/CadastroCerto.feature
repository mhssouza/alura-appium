Feature: Cadastro certo

  Scenario: Tentativa de cadastro com credenciais certas
    Given que estou na tela de login
    And vá para a tela de cadastro e faça o cadastro do usuário "Matheus" e senha "123" e confirmação de senha "123"
    Then o programa deve confirmar meu cadastro
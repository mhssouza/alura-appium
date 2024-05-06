Feature: Login certo

  Scenario: Tentativa de login com usuário correto
    Given que estou na tela de login
    And vá para a tela de cadastro e faça o cadastro do usuário "Matheus" e senha "123" e confirmação de senha "123"
    When fazer o login com o mesmo usuário "Matheus" e senha "123"
    Then devo ser redirecionado para a página inicial
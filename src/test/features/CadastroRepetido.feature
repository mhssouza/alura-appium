Feature: Cadastro Repetido

  Scenario: Tentativa de cadastro com o mesmo usuário duas vezes
    Given que estou na tela de login
    And vá para a tela de cadastro e faça o cadastro do usuário "Matheus" e senha "123" e confirmação de senha "123"
    Then o programa deve confirmar meu cadastro
    When eu tentar fazer o cadastro novamente com o usuario "Matheus", senha "123" e confirmação de senha "123"
    Then devo ver uma mensagem de erro dizendo que o usuário já foi cadastrado
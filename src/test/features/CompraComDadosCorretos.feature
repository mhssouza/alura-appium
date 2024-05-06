Feature: Compra com dados corretos

  Scenario: Tentativa de compras com credenciais certas
    Given que estou na tela de login
    And vá para a tela de cadastro e faça o cadastro do usuário "Matheus" e senha "123" e confirmação de senha "123"
    Then o programa deve confirmar meu cadastro
    When fazer o login com o mesmo usuário "Matheus" e senha "123"
    Then devo ser redirecionado para a página inicial
    When eu selecionar um produto para comprar
    And preencher os dados com o numero do cartao "1234567898765432", data de validade "03/29" e CVC "999"
    Then minha compra deve ser realizada
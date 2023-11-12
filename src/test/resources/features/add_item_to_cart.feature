Feature: Carrito de compras

  Scenario: Añadir un item al carrito de compras

    Given que estoy en la homepage de Amazon
    When busque un item en la barra de busqueda
    And entre al primer item
    And de click al boton de Agregar al carrito
    Then el icono del carrito debe tener un 1

  Scenario: Fallar al añadir un item que no está en stock

    Given que estoy en la pagina inicial
    When busque un item que no esta en stock
    And entre al primer item de la lista
    Then no debe aparecer el boton de agregar al carrito
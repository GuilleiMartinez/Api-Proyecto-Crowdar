Feature: Api example
  As an api user I want to execute request in order to get proper responses

  @Example @Success
  Scenario Outline: Ejemplo escenario para obtener informacion con GET
    Given Creo un usuario en clocky y mi Api-Key generada
    And un workspace ID que sea valido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | jsonName    | statusCode | operation | entity   |
      | exampleJson | 200        | GET       | USER     |



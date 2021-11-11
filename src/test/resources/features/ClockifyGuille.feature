Feature: Workspace
  COMO usuario de Clockify
  QUIERO ver las configuraciones de mi Worckspace
  PARA llevar un buen control de mis horas de trabajo y el de mis empleados


  #Pasos
  #1) Crear Feature y steps
  #2) Hacer el modelado -> src/main/java/api/model
  #3) Crear el servicio -> src/main/java/services/WorkspaceSinParametroService.java
  #4) Agregar el servicio en las configuraciones -> src/main/java/api/config/EntityConfiguration.java
  #5) Creat el json -> rq_sin_parametros.json
  #6) Controlar la ruta del jsn y el entity en los Examples
  #7) Ejecutar la prueba -> mvn -P Local "-Dcucumber.tags=@WorkspaceSinParametro" test



  @Guille
  Scenario Outline: Realizar un Get time entries
    Given que genere un X-Api-Key valido
    And un workspace ID valido
    And un User Id valido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then Valido los datos obtenidos

    Examples:
      | operation | entity    | jsonName     | status |
      | GET       | TIMEENTRIES |GetTimeEntriesGuille| 200    |
  @Guille
  Scenario Outline: Realizar un post time entries
    Given que genere un X-Api-Key valido
    And un workspace ID valido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then valido el ID
    And Guardo time entries ID

    Examples:
      | operation | entity    | jsonName     | status |
      | POST       | TIMEENTRIES | PostTimeEntries| 201   |


  @Guille
  Scenario Outline: Realizar un put time entries
    Given que genere un X-Api-Key valido
    And un workspace ID valido
    #And Tengo un time entry ID valido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then valido el ID


#     falta declarar los JSONS y conectar el model.
    Examples:
      | operation | entity    | jsonName     | status |
      | PUT      | TIMEENTRIES | PutTimeEntries| 200  |

  @Guille
  Scenario Outline: Realizar un get specific time entries
    Given que genere un X-Api-Key valido
    And un workspace ID valido
  #  And un ID valido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then valido el ID

    Examples:
      | operation | entity    | jsonName     | status |
      | GET2     | TIMEENTRIES |GetSpecificTimeEntries| 200   |

#    //PUEDO usar el modelado anterior
  @Guille
  Scenario Outline: Realizar un DELETE time entries
    Given que genere un X-Api-Key valido
    And un workspace ID valido
    #And un ID valido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    #Then valido el ID NULO
#
    Examples:
      | operation | entity    | jsonName           | status |
      | DELETE     | TIMEENTRIES |DeleteTimeEntries| 204    |


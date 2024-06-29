Feature: Tienda

  @ConsultaMascota
  Scenario: Consulta Mascota
    Given dado que estoy en la tienda
    When consulto la mascota de ID "10"
    Then valido el codigo de respuesta sea 200

  @AgregarMascota
  Scenario: Agregar una nueva mascota
    Given dado que estoy en la tienda
    When agrego una nueva mascota con los siguientes detalles:
      | id  | nombre |
      | 200 | Perro  |
    Then valido el codigo de respuesta sea 201 y la respuesta contiene la información de la nueva mascota
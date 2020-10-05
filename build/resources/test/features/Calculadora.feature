# language: es

Característica: Operaciones básicas de la calculadora usando Appium

  Esquema del escenario: Realizar operaciones básicas de la calculadora (suma, resta, multiplicación y división)
    Dado que ingreso a la calculadora del celular usando el simulador
    Cuando realizo una <operacion> basica con los datos <numeroUno> y <numeroDos>
    Entonces se verifica que el <resultado> sea el esperado
    Ejemplos:
      | operacion      | numeroUno | numeroDos | resultado |
      | suma           | 5         | 6         | 11        |
      | resta          | 9         | 3         | 6         |
      | multiplicacion | 7         | 3         | 21        |
      | division       | 8         | 2         | 4         |
# Pruebas Unitarias

Las pruebas unitarias son **fragmentos de código** que se usan para **verificar** que las **unidades más pequeñas** de una aplicación funcionan correctamente. Se ejecutan de forma aislada para garantizar que el código se comporta como se espera. 

## Tecnologías para pruebas unitarias en Java

1. ### JUnit5
Es un **framework** que permite escribir pruebas unitarias de nuestro código. A diferencia de JUnit4, utiliza programacion funcional, funciones lambda e incluye diferentes estilos de pruebas, configuraciones, anotaciones, ciclo de vida, etc.
- #### Arquitectura
    - *JUnit Plataform:* Es la libreria principal que está enfocada al **contexto de ejecución** del test. También puede ejecutar pruebas unitarias realizadas con otros Frameworks
    - *JUnit Jupiter:* Es una API con el que **escribimos** las pruebas unitarias (el código)
    - *JUnit Vintage:* Es un componente que nos permite **integrear** la version 4 con la version 5 de JUnit.

- #### JUnit Jupiter:
    - Es una API que nos permite escribir nuestros test
    - Agrega nuevos modelos y características en JUnit5
    - Nuevas anotaciones y estilos de testing
    - Permite escribir extensiones
    - **ANOTACIONES**
        - ```java 
          @Test
        Sirve para marcar un método como una prueba unitaria. 
        - ```java 
          @DisplayName
        Sirve para desplegar o mostrar el nombre del test 
        - ```java 
          @Nested
        Sirve para dar una jerarquia de nuestras pruebas unitarias (clases dentro de otras clases)
        - ```java 
          @Tag
        Sirve para etiquetar o categorizar un test
        - ```java 
          @ExtendWith
        Sirve para extender el comportamiento de las pruebas, permitiendo la integración con extensiones personalizadas o con extensiones proporcionadas por JUnit o bibliotecas de terceros.
        - ```java 
          @BeforeEach
        Sirve para ejecutar un test **antes** de cada metodo.
        - ```java 
          @AfterEach
        Sirve para ejecutar un test **después** de cada metodo.
        - ```java 
          @BeforeAll
        Sirve para ejecutar una sola vez **antes** de toda la cadena de test. 
        - ```java 
          @AfterAll
        Sirve para ejecutar una sola vez **después** de toda la cadena de test.
        - ```java 
          @Disable
        Sirve para deshabilitar un método o una prueba unitaria.


2. ### Assertions
Es una clase final que contiene métodos estáticos para hacer afirmaciones (assertions) en pruebas unitarias. Permite validar automáticamente que el código se comporte como esperas, y si no, la prueba falla.
Para realizar las pruebas nos apoyamos de los métodos que esta clase nos provee.












## Apuntes


- **Nota 01:** Dentro de la clase `CuentaTest` existe un test llamado `testCuenta()`. Este test evalua si los dos objetos Cuenta son iguales, para eso nos apoyamos con el método estático `assertNotEquals()`. Este método comparará si ambos objetos son iguales (en relación a su referencia en memoria); este fallará ya que, al usar la notación `@Data` de Lombon dentro de la clase `Cuenta` sobreescribimos el método `equals()` y `hashCode()`. Donde, `equals()` nos permitirá comparar solo si los valores de los atributos de la clase son iguales, ignorando su referencia en memoria. Y el segundo, devuelve un valor entero que es el *identificador* de la clase. Si no sobrescribiríamos el método `equals()`, al momento de comparar solo validaría si ambos objetos comparten la misma referencia en memoria. **CABE SEÑALAR QUE AMBOS MÉTODOS VAN DE LA MANO, SI IMPLEMENTAS EQUALS TIENES QUE IMPLEMENTAR HASHCODE**
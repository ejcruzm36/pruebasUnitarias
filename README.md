<h1 style="color: #EA5D5D">Pruebas Unitarias</h1>

Las pruebas unitarias son **fragmentos de código** que se usan para **verificar** que las **unidades más pequeñas** de una aplicación funcionan correctamente. Se ejecutan de forma aislada para garantizar que el código se comporta como se espera. 

<h2 style="color: #EB7E44">Tecnologías para pruebas unitarias en Java</h2>

<ol>
  <li><h3 style="color: #EBB344">JUnit5</h3></li>
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

  <li><h3 style="color: #EBB344">Assertions</h3></li>

  Es una clase final que contiene métodos estáticos para hacer afirmaciones (assertions) en pruebas unitarias. Permite validar automáticamente que el código se comporte como esperas, y si no, la prueba falla.
  Para realizar las pruebas nos apoyamos de los métodos que esta clase nos provee.
  Estos son algunos métodos que nos provee esta clase. *Todos los siguientes métodos reciben como último parámetro un mensaje que se mostrará cuando falla la aseción*

    - `assertEquals(par1, par2)`: Evalua si los dos parámetros son iguales.
    - `assertTrue(condition)`, `assertFalse(condition)`: Recibe una condicion y evalua si es true o false respectivamente.
    - `assertNull(object)`, `assertNotNull(object)`: Evalua si un objeto es nulo o no.
    - `assertThrows(typeException, () -> { expresion que lanza excepcion })`: Evalua si lanza una excepcion del tipo enviado o no. Este devuelve una excepción, se le puede asignar a una variable del tipo Exception y evaluar de otras formas. _Revisar testExceptions()_.
    - `assertAll( () -> { lambdas } )`: Recibe expresiones lambdas que contienen assertions.

  <li><h3 style="color: #EBB344">Mockito</h3></li>
</ol>


















<h2 style="color: #EB7E44">Apuntes</h2>
<ul>
  <li><b>Nota 01:</b></li>

  Dentro de la clase `CuentaTest` existe un test llamado `testCuenta()`. Este test evalua si los dos objetos Cuenta son iguales, para eso nos apoyamos con el método estático `assertNotEquals()`. Este método comparará si ambos objetos son iguales (en relación a su referencia en memoria); este fallará ya que, al usar la notación `@Data` de Lombon dentro de la clase `Cuenta` sobreescribimos el método `equals()` y `hashCode()`. Donde, `equals()` nos permitirá comparar solo si los valores de los atributos de la clase son iguales, ignorando su referencia en memoria. Y el segundo, devuelve un valor entero que es el *identificador* de la clase. Si no sobrescribiríamos el método `equals()`, al momento de comparar solo validaría si ambos objetos comparten la misma referencia en memoria. **CABE SEÑALAR QUE AMBOS MÉTODOS VAN DE LA MANO, SI IMPLEMENTAS EQUALS TIENES QUE IMPLEMENTAR HASHCODE**
  
  <li><b>Nota 02:</b></li>
  <li><b>Nota 03:</b></li>
  <li><b>Nota 04:</b></li>
</ul>
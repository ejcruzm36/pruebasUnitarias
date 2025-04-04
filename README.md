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
   - *ANOTACIONES*
      - ```java 
            @Test
      

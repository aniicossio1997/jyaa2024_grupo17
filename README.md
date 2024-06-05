# jyaa2024_grupo17

# Proyecto Sala De Elaboración

## Dependencias

- **Tomcat**: Versión 10.1.24 (preferentemente)
- **MySQL**: Versión 8.4

## Ejecución

1. **Abrir el Proyecto**:
   - Abra el proyecto en su IDE preferido, como IntelliJ IDEA o Eclipse.

2. **Configurar el Servidor**:
   - Configure la ejecución del proyecto para que se ejecute en el servidor Tomcat.
   - Asegúrese de que los puertos estén configurados correctamente:
     - **MySQL**: Puerto 3306 (por defecto)
     - **Tomcat**: Puerto 8080 (por defecto)

3. **Inicio del Servidor**:
   - Inicie el servidor Tomcat desde su IDE.

4. **Acceso a la Aplicación**:
   - Una vez que el servidor esté en ejecución, abra su navegador web y vaya a la siguiente URL:
     - [http://localhost:8080/SalaDeElaboracion/TestingServlet](http://localhost:8080/SalaDeElaboracion/TestingServlet)
   - **Nota**: Asegúrese de que esta URL coincida con la configuración de su proyecto.

## Consideraciones Adicionales

- La página web no se renderizará hasta que todos los procesos del test hayan finalizado, por lo que puede tardar un tiempo en cargarse completamente.
- Verifique que su base de datos MySQL esté en funcionamiento y que las credenciales de acceso estén correctamente configuradas en su archivo de configuración del proyecto.
- Asegúrese de que los controladores JDBC para MySQL estén correctamente añadidos a las dependencias de su proyecto.
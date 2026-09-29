# SpeedFastApp - Semana 7

Proyecto SpeedFast adaptado para la actividad de JDBC y MySQL.

## 1. Crear la base de datos

Abrir MySQL Workbench y ejecutar:

`sql/speedfast_db.sql`

Esto crea la base `speedfast_db` y las tablas `repartidor`, `pedido` y `entrega`.

## 2. Configurar MySQL en Java

Abrir:

`src/dao/ConexionDB.java`

y cambiar:

`PASSWORD = "tu_contraseña";`

por la contraseña real del usuario `root` de MySQL.

La conexión utilizada es:

`jdbc:mysql://localhost:3306/speedfast_db`

## 3. Abrir en IntelliJ IDEA

Abrir la carpeta del proyecto. IntelliJ reconocerá `pom.xml` como proyecto Maven y descargará automáticamente MySQL Connector/J.

Ejecutar:

`src/ui/Main.java`

## 4. Funcionalidades de la semana 7

- Registrar pedidos directamente en MySQL.
- Consultar pedidos desde MySQL mediante `JTable`.
- Registrar repartidores directamente en MySQL.
- Consultar repartidores desde MySQL.
- `PedidoDAO`, `RepartidorDAO` y `EntregaDAO`.
- Uso de `PreparedStatement`.
- Uso de `ResultSet`.
- Manejo de `SQLException`.
- Cierre automático de Connection, PreparedStatement y ResultSet mediante try-with-resources.
- Clase `ConexionDB` para centralizar la conexión.

## Nota sobre distancia

El modelo de base de datos entregado en la actividad no contiene una columna para `distanciaKm`. Por eso la distancia continúa formando parte del modelo Java, pero no se almacena en la tabla `pedido`. La JTable de pedidos que carga desde MySQL muestra solamente los campos persistidos por el modelo SQL: ID, dirección, tipo y estado.

## Entrega

Antes de subir el proyecto a GitHub, comprobar que:
1. MySQL esté ejecutándose.
2. `speedfast_db` exista.
3. La contraseña en `ConexionDB.java` sea correcta.
4. Maven haya descargado `mysql-connector-j`.
5. `Main.java` compile y ejecute.

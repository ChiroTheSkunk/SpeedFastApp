# SpeedFastApp

SpeedFastApp es una aplicacion de escritorio desarrollada en Java Swing para gestionar pedidos de entrega. El proyecto modela distintos tipos de pedidos, permite registrarlos desde una interfaz grafica, listarlos en una tabla y define la logica base para simular entregas mediante repartidores.

El codigo esta organizado como una aplicacion Java simple, sin dependencias externas ni framework de construccion. Puede abrirse directamente en IntelliJ IDEA o compilarse desde terminal con `javac`.

## Caracteristicas principales

- Registro de pedidos con ID, direccion, distancia y tipo de servicio.
- Soporte para tres tipos de pedidos:
  - `PedidoComida`
  - `PedidoEncomienda`
  - `PedidoExpress`
- Listado de pedidos registrados en una tabla Swing.
- Estados de pedido mediante `EstadoPedido`: `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.
- Modelo orientado a objetos con herencia, clases abstractas e interfaces.
- Logica de repartidores implementada con `Runnable` para simular entregas concurrentes.
- Zona de carga sincronizada para retirar pedidos pendientes de forma segura entre hilos.

## Tecnologias utilizadas

- Java
- Java Swing
- Programacion orientada a objetos
- Hilos con `Runnable`
- Colecciones de Java (`List`, `ArrayList`, `LinkedList`)

## Estructura del proyecto

```text
SpeedFastApp/
|-- src/
|   |-- interfaces/
|   |   |-- Cancelable.java
|   |   |-- Despachable.java
|   |   `-- Rastreable.java
|   |-- model/
|   |   |-- EstadoPedido.java
|   |   |-- Pedido.java
|   |   |-- PedidoComida.java
|   |   |-- PedidoEncomienda.java
|   |   |-- PedidoExpress.java
|   |   |-- Repartidor.java
|   |   `-- ZonaDeCarga.java
|   `-- ui/
|       |-- Main.java
|       |-- VentanaPrincipal.java
|       |-- VentanaRegistroPedido.java
|       `-- VentanaListaPedidos.java
|-- SpeedFastApp.iml
|-- .gitignore
`-- README.md
```

## Como funciona

La aplicacion inicia desde `ui.Main`, que crea la ventana principal usando `SwingUtilities.invokeLater` para ejecutar la interfaz grafica en el hilo adecuado de Swing.

Desde la ventana principal se puede:

1. Registrar un pedido.
2. Listar los pedidos registrados.
3. Iniciar una entrega mediante una confirmacion visual.

Los pedidos registrados se guardan en memoria dentro de `VentanaPrincipal.listaPedidos`, una lista compartida por las ventanas de la aplicacion. Esto significa que los datos existen solo mientras la aplicacion esta abierta; al cerrarla, los pedidos se pierden.

### Registro de pedidos

`VentanaRegistroPedido` muestra un formulario con los siguientes campos:

- ID del pedido
- Direccion de entrega
- Distancia en kilometros
- Tipo de pedido

Segun el tipo seleccionado, se crea una instancia concreta:

- `Comida` crea un `PedidoComida`
- `Encomienda` crea un `PedidoEncomienda`
- `Express` crea un `PedidoExpress`

Cada pedido inicia con estado `PENDIENTE`.

### Listado de pedidos

`VentanaListaPedidos` lee la lista compartida de pedidos y los muestra en una tabla con:

- ID
- Direccion
- Distancia
- Tipo de pedido

### Modelo de pedidos

La clase abstracta `Pedido` contiene los datos comunes:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`
- `estado`

Tambien declara el metodo abstracto `calcularTiempoEntrega()`, que cada subtipo implementa con su propia formula:

| Tipo | Formula |
| --- | --- |
| Comida | `distanciaKm * 5 + 15` |
| Encomienda | `distanciaKm * 4 + 20` |
| Express | `distanciaKm * 3 + 10` |

### Repartidores y zona de carga

El paquete `model` incluye una simulacion de entregas basada en hilos:

- `ZonaDeCarga` mantiene una lista de pedidos y permite agregar o retirar pedidos pendientes.
- Sus metodos principales son `synchronized`, por lo que estan preparados para usarse desde varios hilos.
- `Repartidor` implementa `Runnable`, retira pedidos pendientes, cambia su estado a `EN_REPARTO`, simula un tiempo de entrega y finalmente marca el pedido como `ENTREGADO`.

Actualmente, la interfaz grafica registra y lista pedidos. La accion "Asignar repartidor / Iniciar entrega" muestra una confirmacion, pero no ejecuta todavia la simulacion de `Repartidor` y `ZonaDeCarga`.

## Requisitos

- JDK instalado
- IntelliJ IDEA, Eclipse, NetBeans o cualquier editor compatible con Java

Se recomienda usar Java 8 o superior.

## Ejecucion desde IntelliJ IDEA

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que `src` este marcado como carpeta de codigo fuente.
3. Abrir `src/ui/Main.java`.
4. Ejecutar el metodo `main`.

## Ejecucion desde terminal

Desde la raiz del proyecto:

```bash
javac -d out/production/SpeedFastApp src/interfaces/*.java src/model/*.java src/ui/*.java
java -cp out/production/SpeedFastApp ui.Main
```

En PowerShell, los mismos comandos pueden ejecutarse desde:

```powershell
C:\Users\matia\IdeaProjects\SpeedFastApp
```

## Conceptos aplicados

- Encapsulamiento de datos mediante clases del modelo.
- Herencia con la clase abstracta `Pedido`.
- Polimorfismo en los distintos tipos de pedido.
- Interfaces para representar capacidades: `Despachable`, `Cancelable` y `Rastreable`.
- Separacion basica entre modelo (`model`) e interfaz grafica (`ui`).
- Manejo de eventos con Swing.
- Sincronizacion de acceso a datos compartidos en `ZonaDeCarga`.

## Limitaciones actuales

- Los pedidos se almacenan solo en memoria.
- No existe persistencia en archivos ni base de datos.
- La tabla de pedidos no muestra el estado actual del pedido.
- El boton de entrega en la interfaz no esta conectado todavia con la simulacion de repartidores.
- No hay validacion de IDs duplicados.
- No hay pruebas automatizadas configuradas.

## Posibles mejoras

- Conectar la ventana principal con `ZonaDeCarga` y `Repartidor`.
- Mostrar y actualizar el estado de cada pedido en la tabla.
- Agregar persistencia con archivos, SQLite u otra base de datos.
- Implementar busqueda, filtros y eliminacion de pedidos.
- Validar IDs duplicados y distancias negativas.
- Agregar pruebas unitarias para el modelo.

## Autor

Proyecto desarrollado como aplicacion academica/practica para gestionar pedidos y aplicar conceptos de programacion orientada a objetos en Java.

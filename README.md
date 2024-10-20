# UmbrellaCorporation

- link al repositorio: https://github.com/Roberquilez/UmbrellaCorporation.git
- Propietarios: Adrián Puyo Olías, Sira Gonzalez-Madroño y Roberto Quilez

## 1. Descripción del Proyecto

La aplicación **Umbrella Corporation** es un sistema basado en Spring Boot que gestiona el procesamiento concurrente de archivos CSV y ofrece un endpoint REST para acceder a los datos procesados. Además, la aplicación incluye una herramienta de monitoreo de hilos y funcionalidades para abrir automáticamente un navegador web con una interfaz visual al iniciar.

## 2. Funcionamiento del Proyecto

### 2.1. Procesamiento Concurrente de CSV:

El sistema es capaz de leer archivos CSV de forma concurrente utilizando un pool de hilos para mejorar la eficiencia del procesamiento. El procesamiento se lleva a cabo en bloques (batches) de 1000 líneas, donde cada bloque es asignado a un hilo. Esta tarea es gestionada por la clase `LectorDatosCSV`, que divide el archivo en partes y procesa cada una de ellas de manera simultánea, garantizando que los datos se procesen rápidamente.

### 2.2. Exposición de Datos mediante un Endpoint REST:

La clase `CSVController` expone un endpoint REST (`/datos-csv`) que permite a los usuarios procesar archivos CSV. El endpoint acepta una ruta de archivo como parámetro opcional. Si no se proporciona, se utiliza una ruta predeterminada. Los datos procesados son devueltos en forma de lista de arreglos de cadenas.

### 2.3. Monitoreo de Hilos:

Antes de iniciar el servidor, la aplicación utiliza la clase `MonitoringTool` para imprimir información acerca de los hilos activos en el sistema. Esto ayuda a obtener una visión general del estado de los hilos en el JVM durante el tiempo de ejecución.

### 2.4. Procesamiento de Datos:

La clase `DataProcessor` realiza una simulación de procesamiento de datos, registrando mensajes de inicio y fin del procesamiento. Esta funcionalidad puede ser extendida para implementar lógica de procesamiento más compleja según los requisitos del proyecto.

### 2.5. Apertura Automática del Navegador:

Una vez que la aplicación está lista, abre automáticamente un navegador web con una página HTML que contiene gráficos visualizados con la librería D3.js. El método `openBrowser` detecta el sistema operativo y ejecuta el comando adecuado para abrir el navegador según la plataforma en uso (Windows, Mac, Linux).

## 3. Estructura del Proyecto

- **CSVController**: Controlador REST que gestiona la entrada y salida de datos relacionados con el procesamiento de archivos CSV.
- **LectorDatosCSV**: Servicio que se encarga de la lectura y procesamiento concurrente de archivos CSV en bloques.
- **DataProcessor**: Simula el procesamiento de datos con un retardo para representar una tarea real.
- **MonitoringTool**: Herramienta de monitoreo que imprime detalles de los hilos en ejecución.
- **UmbrellaCorporationApplication**: Clase principal que inicia la aplicación Spring Boot, gestiona el procesamiento de datos y abre un navegador al inicio.

## 4. Funcionalidades Clave

1. **Procesamiento Concurrente de CSV**: Mejora la eficiencia en el manejo de grandes archivos CSV.
2. **Endpoint REST para Procesamiento CSV**: Interfaz sencilla para que los usuarios envíen y reciban datos CSV procesados.
3. **Monitoreo de Hilos**: Proporciona una visión del estado de los hilos activos durante la ejecución.
4. **Apertura Automática del Navegador**: Mejora la experiencia del usuario abriendo automáticamente una página HTML al iniciar la aplicación.

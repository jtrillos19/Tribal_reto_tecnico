**Desafío Técnico para Tribal**

Aplicación para mostrar categorías utilizando la API de https://api.chucknorris.io/jokes propuesta en el desafío.

---

## Descripción

Esta aplicación enumera varias categorías utilizando la API de chucknorris.io. Está desarrollada siguiendo buenas prácticas de programación, arquitectura limpia, patrón MVVM y coroutines.
### Estructura

La aplicación está organizada en las siguientes capas:

* **Presentación**: Responsable de la interfaz de usuario.
* **Dominio**: Encargada de la lógica de negocio.
* **Infraestructura**: Maneja la comunicación con el back-end (APIs).

---

## Presentación

La capa de presentación se encarga de la interfaz de usuario. Incluye los siguientes paquetes:

* **adapter** Contiene los adaptadores y ViewHolders para manejar las categorías.
* **ui** Contiene todas las actividades y recursos base de la aplicación.
* **viewmodels** Aloja los viewmodels para las categorías.

---

## Infraestructura

La capa de infraestructura gestiona la comunicación con el back-end (APIs) y actúa como un puente entre las capas de dominio y presentación.

* **di** Contiene la inyección de dependencias.
* **repository** Implementa los repositorios definidos en la capa de dominio.
* **api** Maneja los endpoints y sus administradores.

---

## Dominio

La capa de dominio se encarga de la lógica de negocio de la aplicación. Define los modelos de datos, las reglas de negocio y los servicios utilizados en la aplicación.

* **repository** Contiene los contratos de los repositorios utilizados en la capa de dominio.
* **services** Implementa la lógica de negocio de la aplicación.

---



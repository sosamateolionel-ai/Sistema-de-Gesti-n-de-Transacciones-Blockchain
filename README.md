# Sistema de Gestión de Transacciones Blockchain

## Descripción

Este proyecto implementa un sistema que simula operaciones de transferencia de criptomonedas en tres redes blockchain: Bitcoin, Ethereum y Solana. Utiliza programación orientada a objetos para gestionar billeteras, consultar saldos, validar direcciones y calcular comisiones según las características de cada red.

## Funcionamiento

El sistema permite registrar billeteras con un saldo inicial, consultar sus saldos y realizar transferencias entre billeteras registradas.

Cada transacción verifica que el monto sea mayor que cero, que las direcciones tengan un formato válido, que las billeteras estén registradas y que el saldo de origen sea suficiente para cubrir el monto y la comisión.

Se implementan tres redes:

* **Bitcoin:** utiliza una comisión fija de `0.0001 BTC` y una validación simplificada de direcciones.
* **Ethereum:** utiliza una comisión simulada de `0.002 ETH` y verifica el formato hexadecimal de las direcciones.
* **Solana:** utiliza una comisión fija de `0.000005 SOL` y comprueba el formato Base58 de las direcciones.

Cuando una transferencia se realiza correctamente, se descuenta del saldo de origen el monto más la comisión y se acredita el monto transferido al saldo de destino. Si alguna validación falla, la operación se rechaza.

## Clases e interfaz principales

### `RedBlockchain`

Interfaz que define las operaciones comunes de todas las redes: `verificarSaldo()`, `ejecutarTransaccion()` y `getNombre()`.

### `RedBase`

Clase abstracta que implementa la interfaz `RedBlockchain`. Centraliza la gestión de saldos, el registro de billeteras, las validaciones generales y la ejecución de transferencias. Declara métodos abstractos para validar direcciones, calcular comisiones y generar mensajes de confirmación.

### `RedBitcoin`

Hereda de `RedBase` y define las reglas de validación de direcciones, la comisión y el mensaje de confirmación correspondientes a Bitcoin.

### `RedEthereum`

Hereda de `RedBase` y establece las reglas específicas para las direcciones y las comisiones simuladas de Ethereum.

### `RedSolana`

Hereda de `RedBase` y establece las reglas específicas para las direcciones Base58 y las comisiones simuladas de Solana.

### `Main`

Crea las redes y registra billeteras de prueba. Luego realiza transferencias, consulta saldos y prueba situaciones de error, como saldo insuficiente, direcciones incompatibles y transferencias hacia la misma billetera.

## Conceptos de programación utilizados

* **Interfaces:** `RedBlockchain` establece un contrato común para las redes.
* **Abstracción:** `RedBase` reúne las operaciones compartidas y deja los comportamientos específicos para las subclases.
* **Herencia:** las redes concretas heredan de `RedBase`.
* **Polimorfismo:** la variable `red`, de tipo `RedBlockchain`, permite operar con diferentes redes mediante la misma interfaz.
* **Encapsulamiento:** los saldos se almacenan en un mapa privado y se gestionan mediante métodos de la clase base.
* **Sobrescritura de métodos:** cada red implementa sus propias reglas de validación, comisión y confirmación.
* **Colecciones:** se utiliza `HashMap` para asociar cada dirección de billetera con su saldo.
* **Expresiones regulares:** se utilizan para comprobar los formatos de las direcciones.
* **Validación de datos:** se controlan montos, direcciones, registro de billeteras y saldo disponible.

## Tecnologías utilizadas

* Java.
* IntelliJ IDEA.
* Programación orientada a objetos (POO).
* Colecciones de Java (`HashMap`).

## Ejecución

<img width="917" height="645" alt="image" src="https://github.com/user-attachments/assets/a4d1e75f-512d-4e7c-ad36-2a338cd1c361" />
<img width="602" height="355" alt="image" src="https://github.com/user-attachments/assets/e0fcf6d5-c6a5-4b46-a3dc-bb0857cd2f9e" />

## Objetivo del ejercicio

Aplicar interfaces, clases abstractas, herencia y polimorfismo para diseñar un sistema flexible que permita gestionar transferencias en diferentes redes blockchain. También se busca practicar el encapsulamiento de datos, el uso de colecciones y la validación de operaciones.

## Consideraciones

El sistema es una simulación educativa. No se conecta a redes blockchain reales, no consulta saldos externos ni emite transacciones auténticas. Las comisiones, los mensajes de confirmación y las reglas de validación son simplificados. Los saldos se mantienen únicamente en memoria durante la ejecución del programa.

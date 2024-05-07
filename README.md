# examenPOO
# POO - Examen Unidad 3

Trabajas en una fintech la cual está en proceso de convertirse en un banco, por lo que han decidido crear un nuevo sistema que pueda hacer la gestión de la empresa.

Los requerimientos que se ocupan para desarrollar este nuevo proyecto se describen a continuación, por lo que tu y tu equipo tendrán que analizar, comprender, realizar el diagrama **UML** correspondiente y desarrollar este nuevo producto. El fecha límite para la entrega de este producto es el día ***12 de mayo del 2024***, por lo que deberá estar listo para esa fecha sin errores o fallas.

El próximo banco comenzará sus operaciones con 2 sucursales, la sucursal “Madero” y “Acueducto”. Cada una de ellas puede tener solamente un único gerente.

# Roles ✅

El sistema va a contar con los 6 roles siguientes.

- Clientes
- Empleados
    - Gerente de sucursal
    - Ejecutivos de cuenta
    - Capturista
- Inversionistas

# Clientes 🙎🏽‍♂️

Los clientes van a poder ser dados de alta en el sistema únicamente por los empleados con el rol de ***ejecutivos de cuenta***, al momento en el que se dan de alta, se les asigna una tarjeta de débito, los datos que se ocupan para dar de alta al usuario son los siguientes.

| Nombre | Apellidos | Año de nacimiento |
| --- | --- | --- |
| Ciudad | Estado | RFC (Crear un algoritmo para generarlo automáticamente de acuerdo a la información del cliente) |
| CURP | Dirección | Fecha de registro |
| Sucursal de registro |  |  |

Al momento en el que se crea un cliente, se le debe de asignar una tarjeta de débito la cuál debe de contener los siguientes datos.

| Número de tarjeta (16 dígitos) | Fecha de creación | Saldo |
| --- | --- | --- |
| CVV | Clabe interbancaria | Fecha de vencimiento (5 años después de su creación) |
| Fecha y hora de último movimiento (se actualiza cada vez que se realiza un movimiento) |  |  |

# Empleados 🧑🏽‍💼

Es importante señalar que todos ellos podrán realiza las operaciones que les corresponden únicamente en la sucursal a la que pertenecen.

Todos los empleados contarán con los siguiente datos.

| Nombre | Apellidos | Año de nacimiento |
| --- | --- | --- |
| Ciudad | Estado | RFC (Crear un algoritmo para generarlo automáticamente de acuerdo a la información del cliente) |
| CURP | Dirección | Sucursal a la que pertenece |
| Salario | Rol | Fecha de inicio de trabajo |

### Gerente de surcursal

Esta persona podrá hacer todas operaciones con las que cuente el sistema. Es importante señalar que una vez que el sistema esté listo, ya debe de contar con un gerente registrado por default.

### Capturista

Esta persona es la encargada de realizar cualquier registro o modificación únicamente a los ejecutivos de cuenta. Es decir no podrá realizar ninguna otra operación que no sea sobre los ejecutivos de cuenta.

### Ejecutivo de cuenta

Este rol es el encargado de llevar todo el proceso de los clientes. Registro, modificaciones, eliminaciones, búsquedas, etc. De igual forma, una vez que un cliente solicite una tarjeta de crédito, este rol (junto con el gerente), serán los únicos que podrán autorizarlo.

# Inversionistas 👨🏽‍💼

Estas personas serán las encargadas de proveer de fondos al banco, podrán ser registrados, modificados, eliminados, etc. únicamente por el gerente, y para cualquier operación que se desee hacer con los inversionistas, el sistema tendrá que solicitar una contraseña (aún siendo el gerente), esto para garantizar la máxima seguridad en el sistema.

Una vez un inversionista quede registrado, podrá entrar a su perfil y proveer fondos al banco, fondos que únicamente el gerente podrá ver, es decir, una vez que algún inversionista realice alguna inversión en el banco, el gerente, dentro de su perfil, podrá ver que inversionista realizó que movimiento, junto con su fecha.

***Este apartado queda a elección en cuanto a los campos que deseen incluir.***

# Tarjetas 💳

Cada cliente puede ver las tarjetas con las que cuenta, de estas tarjetas, un cliente puede tener máximo 1 tarjeta de débito y hasta 3 tarjetas de crédito.

Las tarjetas de crédito se dividen en 3, ***simplicity, platino y oro.*** El cliente podrá solicitar las tarjetas una vez que tenga en la tarjeta de débito o una cantidad mayor a $50,000 pesos, $100,000 pesos y $200,000 pesos, respectivamente.

- **Tarjeta simplicity** - Crédito máximo de $60,000 MXN
- **Tarjeta platino** - Crédito máximo de $150,000 MXN
- **Tarjeta oro** - Crédito máximo de $400,000 MXN

Al momento en el que el cliente hace una compra con una tarjeta de crédito, restarle esa cantidad de su crédito máximo, esto para asegurar que no puede gastar más de lo que tiene permitido. Para poder gastar más con su tarjeta, debe de realizar el pago de ella para que su crédito vuelva a subir.

Cada tarjeta debe de contar mínimo con esta información.

| Número de tarjeta | Fecha de creación | Saldo |
| --- | --- | --- |
| CVV | Clabe interbancaria | Fecha de vencimiento (5 años después de su creación) |
| Fecha y hora de último movimiento (se actualiza cada vez que se realiza un movimiento) |  |  |

Es importante resaltar que una vez que el sistema detecte que el cliente tiene la cantidad permitida para solicitar alguna tarjeta, se le habilite una opción para solicitar, y dependiendo de sus saldo, que solicite la tarjeta correspondiente, caso contrario que no le aparezca la opción de solicitud.

Una vez que el cliente solicite una tarjeta de crédito, esta solicitud tiene que ser autorizada, por lo que los empleados con el rol de **ejecutivo de cuenta (y gerente)** serán los únicos que podrán autorizar o rechazar la solicitud. Es decir, una vez que un cliente pueda solicitar una tarjeta de crédito debido a que cuenta con fondos suficientes, y seleccione esa opción, se generará una solicitud que podrá ver el ejecutivo de cuenta y el gerente, donde ellos podrán aceptarla o rechazarla, y en caso de aceptarla, se generará una tarjeta y se le asociará al cliente.

Estos dos roles podrán ver todas las solicitudes que existen en la sucursal (si es que existen).

Los datos que se piden en una solicitud de tarjeta son los siguientes.

| Cliente que solicita | Fecha de solicitud | Tipo de tarjeta que solicita |
| --- | --- | --- |
| Monto en tarjeta de debido al momento de la solicitud | Estatus: En proceso, aprobada, rechazada | Id de cliente |

De igual forma, el cliente tendrá una opción para poder ver los estatus de su solicitud, es decir, si está en proceso, si ha sido aprobada o si ha sido rechazada. Es importante resaltar que el cliente no podrá realizar solicitudes múltiples, es decir, si desea realizar otra, debe de esperar a que la anterior cambie a ***aprobada o rechazada***.

De igual forma, el cliente podrá realizar los movimientos comunes con sus tarjetas, es decir, depositar y retirar.

# Notas 📒

- Cada usuario debe contar con su propia contraseña.
- Todos los movimientos son únicos por sucursal, es decir, algún ejecutivo de la sucursal A no podrá ver ni realizar movimientos de la sucursal B.
- Realizar todas las validaciones correspondientes, ej. no ID’s duplicados, que existan objetos antes de crear relaciones, que si se eliminan objetos no rompan otras relaciones, etc.
- Equipos de 3 personas.
- Subir el código a una rama llamada examen/unidad3
- En los README de los proyectos poner la descripción del ejercicio y los integrantes.
- Subir los integrantes en el excel “EquiposExamen3” que se encuentra en el grupo de Teams.
- Realizar los CRUDS correspondientes
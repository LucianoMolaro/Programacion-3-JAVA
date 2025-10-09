document.addEventListener("DOMContentLoaded", () => {
    const botonGuardar = document.getElementById("Guardar");

    botonGuardar.addEventListener("click", async () => {
        // Capturamos los valores del formulario
        const nombre = document.getElementById("nombre").value.trim();
        const apellido = document.getElementById("apellido").value.trim();
        const dni = document.getElementById("dni").value.trim();
        const sector = document.getElementById("sector").value.trim();
        const fechaIngreso = document.getElementById("fechaIngreso").value;
        const activo = document.getElementById("activo").value;

        // Validación básica
        if (!nombre || !apellido || !dni || !sector || !fechaIngreso) {
            alert("Por favor, complete todos los campos.");
            return;
        }

        // Creamos el objeto con los datos
        const datosEmpleado = {
            nombre,
            apellido,
            dni,
            sector,
            fechaIngreso,
            activo
        };

        try {
            // Enviamos los datos al backend (ajustá el puerto si usás otro)
            const respuesta = await fetch("http://localhost:3000/formulario", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(datosEmpleado)
            });

            if (respuesta.ok) {
                const resultado = await respuesta.json();
                console.log("Empleado cargado correctamente:", resultado);
                alert("Empleado guardado correctamente ✅");
                document.querySelector("form").reset();
            } else {
                console.error("Error al guardar empleado:", respuesta.statusText);
                alert("Error al guardar el empleado ❌");
            }
        } catch (error) {
            console.error("Error de conexión:", error);
            alert("No se pudo conectar con el servidor.");
        }
    });
});

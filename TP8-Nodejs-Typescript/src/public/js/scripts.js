let criterio = "descLegajo";
const botones = document.querySelectorAll("button[data-orden]");


document.addEventListener("DOMContentLoaded", async () => {
    
    // Cargar y mostrar empleados iniciales
    const listaEmp = await obtenerEmpleados();
    mostrarEmpleados(listaEmp);

    // **************** CORRECCIONES Y VINCULACIÓN DE EVENTOS ****************
    
    // 1. Botón 'eliminar' (Corrección de document.get a document.getElementById y llamado sin paréntesis)
    const eliminar = document.getElementById("eliminar") // CORRECCIÓN
    if(eliminar) eliminar.addEventListener("click", eliminarEmpleado) // CORRECCIÓN: pasar la referencia de la función

    // 2. Botón 'agregar' (Botón principal: debe LLAMAR a darAlta para MOSTRAR el formulario)
    const agregarBtn = document.getElementById("agregar")
    if(agregarBtn) agregarBtn.addEventListener("click", darAlta) 

    // 3. Botón 'editar' (Llamado sin paréntesis)
    const editar = document.getElementById("editar")
    if(editar) editar.addEventListener("click", editarEmpleado) // CORRECCIÓN: pasar la referencia de la función
    
    // 4. NUEVO: Botón 'Guardar' dentro del formulario
    const btnGuardarForm = document.getElementById("btn-guardar-form");
    if(btnGuardarForm) btnGuardarForm.addEventListener("click", guardarEmpleado); 

    // 5. NUEVO: Botón 'Cancelar' dentro del formulario
    const btnCancelarForm = document.getElementById("btn-cancelar-form");
    if(btnCancelarForm) btnCancelarForm.addEventListener("click", aparecer); // Aparecer oculta el formulario

});

function mostrarEmpleados(listaEmpleados) {

    const info = document.querySelector("#resultados");
    info.innerHTML = ""; // vaciamos primero

    listaEmpleados.forEach(emp => {
        // CORRECCIÓN: document.createElement solo debe tener el nombre de la etiqueta
        const div = document.createElement("div"); 
        div.className = "tabla-resultados"; // Usa la clase que tienes en tu HTML

        div.innerHTML = `
            <p>${emp.legajo}</p>
            <p>${emp.nombre}</p>
            <p>${emp.apellido}</p>
            <p>${emp.dni}</p>
            <p>${emp.sector}</p>
            <p>${formatearFecha(emp.fechaIngreso)}</p>
            <p>${emp.activo ? "Sí" : "No"}</p>
            <button>eliminar X</button>
        `;

        // CORRECCIÓN: document.createElement solo debe tener el nombre de la etiqueta
        const div2 = document.createElement("div"); 
        div2.className = "eliminar-editar"; // Usa la clase que tienes en tu HTML

        div2.innerHTML = `
            <button type="button" class="btnConfirmar">x</button>
            <button type="button" class="btnConfirmar">x</button>
        `;

        info.appendChild(div);
        info.appendChild(div2);
    });
}

function formatearFecha(fechaISO) {
    const fecha = new Date(fechaISO);
    return fecha.toLocaleDateString("es-AR"); // o "es-ES" según preferencia
}

async function guardarEmpleado() {
    const legajo = document.getElementById("legajo").value;
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const dni = document.getElementById("dni").value;
    const sector = document.getElementById("sector").value;
    const fechaIngreso = document.getElementById("fechaIngreso").value;
    const activoInput = document.getElementById("activo").value;
    
    // Convertir el string de 'activo' a booleano
    const activo = activoInput === 'true'; 

    if (!legajo || !nombre || !apellido || !dni || !sector || !fechaIngreso) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    const datosEmpleado = {
        legajo,
        nombre,
        apellido,
        dni,
        sector,
        fechaIngreso,
        activo
    };

    try {
        const respuesta = await fetch("http://localhost:3000/empleados", {
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
            
            aparecer(); // Ocultar el formulario después de guardar
            // Recargar la lista de empleados para que se vea el nuevo
            const listaEmp = await obtenerEmpleados();
            mostrarEmpleados(listaEmp);
            
            // window.location.href = "/empleados"; // Descomentar si quieres recargar la página completa
        } else {
            console.error("Error al guardar empleado:", respuesta.statusText);
            alert("Error al guardar el empleado ❌");
        }
    } catch (error) {
        console.error("Error de conexión:", error);
        alert("No se pudo conectar con el servidor.");
    }
}
async function editarEmpleado(){
    // ... (Tu código original)
    // Es recomendable modificar esta función para que lea inputs de un formulario de edición en el futuro.
    /* ... */
};


async function eliminarEmpleado(){
   
}


async function darAlta(){
    const formulario = document.getElementById("formulario-empleado");
    if(formulario) {
        formulario.style.display = "block"; // Muestra el formulario
        
        document.getElementById("legajo").value = '';
        document.getElementById("nombre").value = '';
        document.getElementById("apellido").value = '';
        document.getElementById("dni").value = '';
        document.getElementById("sector").value = '';
        document.getElementById("fechaIngreso").value = '';
        document.getElementById("activo").value = 'true';
    }
}

async function obtenerEmpleados(){
    const response = await fetch("/api/empleados");
    // if (!response.ok) throw new Error("Error al traer los empleados");
    const empleados = await response.json();
    return empleados;
}


function ordenarAsc(criterio){
    // ... (Tu código original)
    switch(criterio){
        case 'descLegajo': const descl = document.g // CORRECCIÓN PENDIENTE en tu código original
    }
}

function aparecer(){
    const formulario = document.getElementById("formulario-empleado");
    if(formulario) {
        formulario.style.display = "none"; // Oculta el formulario
    }
}
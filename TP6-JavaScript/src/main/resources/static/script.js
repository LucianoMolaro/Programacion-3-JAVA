const API_URL = "http://localhost:8080/agenda/contactos";

// Cargar lista al iniciar
//document.addEventListener("DOMContentLoaded", cargarAgendas);

// Manejar formulario
/*document.getElementById("agendaForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const nombre = document.getElementById("nombre").value;
  const telefono = document.getElementById("telefono").value;

  await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ nombre, telefono })
  });

  document.getElementById("agendaForm").reset();
  cargarAgendas();
});
*/

// Cargar todas las agendas
async function cargarAgendas() {
  const res = await fetch(API_URL);
  const data = await res.json();

  const list = document.getElementById("listaGuardados");
  list.innerHTML = "";

  data.forEach(agenda => {
    const li = document.createElement("li");
    li.textContent = `${agenda.nombre} - ${agenda.telefono}`;
    
    const btn = document.createElement("button");
    btn.textContent = "Eliminar";
    btn.onclick = () => eliminarAgenda(agenda.id);
    
    li.appendChild(btn);
    list.appendChild(li);
  });
}

// Eliminar agenda
async function eliminarAgenda(id) {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
  cargarAgendas();
}

async function guardarContacto() {
  document.getElementById("agregarContacto").addEventListener("submit", async (e) => {
    e.preventDefault();
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const email = document.getElementById("email").value;
    const domicilio = document.getElementById("domicilio").value;
    const telefono = document.getElementById("telefono").value;

      await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json"},
    body: JSON.stringify({ nombre, apellido, email, domicilio, telefono})
  });
  document.getElementById("agregarContacto").reset();
  cargarAgendas();

    






  })

}
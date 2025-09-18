document.addEventListener("DOMContentLoaded", function () {
  // Referencias a elementos
  const btnGuardar = document.getElementById("guardarContacto");
  const btnEliminar = document.getElementById("eliminar");
  const btnEditarSeleccionado = document.getElementById("btnEditarSeleccionado");
  const lista = document.getElementById("listaGuardados");
  const buscadorBtn = document.getElementById("buscador");
  const labelBuscador = document.getElementById("labelBuscador");
  const inputBuscador = document.getElementById("contacto");

  // Variable global para saber si se está editando
  let contactoEditando = null;

  // ============================
  // INICIALIZACIÓN
  // ============================

  ocultarBuscador();
  cargarContactos();

  // ============================
  // EVENTOS
  // ============================

  // Botón "Guardar"
  btnGuardar.addEventListener("click", function () {
    const contacto = {
      nombre: document.getElementById("nombre").value.trim(),
      apellido: document.getElementById("apellido").value.trim(),
      email: document.getElementById("email").value.trim(),
      domicilio: document.getElementById("domicilio").value.trim(),
      telefono: document.getElementById("telefono").value.trim(),
    };

    if (Object.values(contacto).some(valor => valor === "")) {
      alert("Por favor, completa todos los campos.");
      return;
    }

    let contactos = JSON.parse(localStorage.getItem("contactos")) || [];

    if (contactoEditando !== null) {
      // Editar existente
      contactos[contactoEditando] = contacto;
      contactoEditando = null;
    } else {
      // Agregar nuevo
      contactos.push(contacto);
    }

    localStorage.setItem("contactos", JSON.stringify(contactos));
    limpiarCampos();
    cargarContactos();
  });

  // Botón "Eliminar todos"
btnEliminar.addEventListener("click", function () {
  const seleccionado = document.querySelector('input[name="contactoSeleccionado"]:checked');
  let contactos = JSON.parse(localStorage.getItem("contactos")) || [];

  if (seleccionado) {
    const index = parseInt(seleccionado.value);

    if (confirm("¿Eliminar el contacto seleccionado?")) {
      contactos.splice(index, 1); // Elimina el contacto
      localStorage.setItem("contactos", JSON.stringify(contactos));
      contactoEditando = null;
      cargarContactos();
    }
  } else {
    if (contactos.length === 0) {
      alert("No hay contactos para eliminar.");
      return;
    }

    if (confirm("¿Eliminar todos los contactos?")) {
      localStorage.removeItem("contactos");
      contactoEditando = null;
      lista.innerHTML = "";
    }
  }
});


  btnEditarSeleccionado.addEventListener("click", function () {
    const seleccionado = document.querySelector('input[name="contactoSeleccionado"]:checked');

    if (!seleccionado) {
      alert("Selecciona un contacto primero.");
      return;
    }

    const index = parseInt(seleccionado.value);
    const contactos = JSON.parse(localStorage.getItem("contactos")) || [];
    const contacto = contactos[index];

    if (!contacto) {
      alert("Contacto no encontrado.");
      return;
    }

    document.getElementById("nombre").value = contacto.nombre;
    document.getElementById("apellido").value = contacto.apellido;
    document.getElementById("email").value = contacto.email;
    document.getElementById("domicilio").value = contacto.domicilio;
    document.getElementById("telefono").value = contacto.telefono;

    contactoEditando = index;
  });


  buscadorBtn.addEventListener("click", function () {
    const visible = labelBuscador.style.display === "inline";

    if (visible) {
      ocultarBuscador();
    } else {
      mostrarBuscador();
    }
  });

  // Buscar mientras se escribe
/*  inputBuscador.addEventListener("input", function () {
    const filtro = inputBuscador.value.toLowerCase();
    const elementos = lista.getElementsByTagName("li");

    Array.from(elementos).forEach(item => {
      const texto = item.textContent.toLowerCase();
      item.style.display = texto.includes(filtro) ? "block" : "none";
    });
  });*/

  function mostrarContacto(contacto, index) {
    const item = document.createElement("li");

    item.innerHTML = `
      <input type="radio" name="contactoSeleccionado" value="${index}">
      <strong>${contacto.nombre} ${contacto.apellido}</strong><br>
      <small>Email:</small> ${contacto.email}<br>
      <small>Domicilio:</small> ${contacto.domicilio}<br>
      <small>Tel:</small> ${contacto.telefono}
    `;

    lista.appendChild(item);
  }

  function cargarContactos() {
    lista.innerHTML = ""; // Limpiar lista

    let contactos = [];
    try {
      contactos = JSON.parse(localStorage.getItem("contactos")) || [];
    } catch (e) {
      console.error("Error al cargar contactos:", e);
      contactos = [];
    }

    contactos.forEach((contacto, index) => {
      if (contacto && contacto.nombre && contacto.apellido) {
        mostrarContacto(contacto, index);
      }
    });
  }

  function limpiarCampos() {
    document.getElementById("nombre").value = "";
    document.getElementById("apellido").value = "";
    document.getElementById("email").value = "";
    document.getElementById("domicilio").value = "";
    document.getElementById("telefono").value = "";
    contactoEditando = null;
  }

  function ocultarBuscador() {
    labelBuscador.style.display = "none";
    inputBuscador.style.display = "none";
    inputBuscador.value = "";
  }

  function mostrarBuscador() {
    labelBuscador.style.display = "inline";
    inputBuscador.style.display = "inline";
    inputBuscador.focus();
  }
});

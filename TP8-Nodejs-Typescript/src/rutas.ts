
import { fileURLToPath } from "url";
import { Router } from "express";
const router = Router();
import { cargarEmpleado, mostrarFomulario } from "./controlador/controlador";

router.get('/test', (requ, resp) => resp.send("HOLA MUNDO"))

router.get('/formulario', mostrarFomulario)
router.post('/formulario', cargarEmpleado)

export default router;
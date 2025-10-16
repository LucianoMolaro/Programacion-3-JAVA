
import path from "path"
import { Router } from "express";
const router = Router();
import { cargarEmpleado, editarEmpleado, obtenerEmpleados} from "./controlador/controlador";

router.get('/test', (requ, resp) => resp.send("HOLA MUNDO"))

// router.get('/formulario', (req, res)=> res.sendFile(path.join(__dirname, '../src/public/formulario.html')))
router.get('/empleados', (req, res)=> res.sendFile(path.join(__dirname, '../src/public/empleados.html')))
router.get('/api/empleados', obtenerEmpleados)
router.post('/empleados', cargarEmpleado)
router.put('/empleados', editarEmpleado)
export default router;
"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const path_1 = __importDefault(require("path"));
const express_1 = require("express");
const router = (0, express_1.Router)();
const controlador_1 = require("./controlador/controlador");
router.get('/test', (requ, resp) => resp.send("HOLA MUNDO"));
// router.get('/formulario', (req, res)=> res.sendFile(path.join(__dirname, '../src/public/formulario.html')))
router.get('/empleados', (req, res) => res.sendFile(path_1.default.join(__dirname, '../src/public/empleados.html')));
router.get('/api/empleados', controlador_1.obtenerEmpleados);
router.post('/empleados', controlador_1.cargarEmpleado);
router.put('/empleados', controlador_1.editarEmpleado);
exports.default = router;
//# sourceMappingURL=rutas.js.map
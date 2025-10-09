"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const router = (0, express_1.Router)();
const controlador_1 = require("./controlador/controlador");
router.get('/test', (requ, resp) => resp.send("HOLA MUNDO"));
router.get('/formulario', controlador_1.mostrarFomulario);
router.post('/formulario', controlador_1.cargarEmpleado);
exports.default = router;
//# sourceMappingURL=rutas.js.map
"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const router = (0, express_1.Router)();
const controlador_1 = require("../controlador/controlador");
router.get('/test', (requ, resp) => resp.send("HOLA MUNDO"));
const express = require("express");
const path = require("path");
router.get("/formulario", (req, res) => {
    res.sendFile(path.join(__dirname, "../src/public/formulario.html"));
});
router.post('/formulario', controlador_1.cargarEmpleado);
exports.default = router;
//# sourceMappingURL=rutas.js.map
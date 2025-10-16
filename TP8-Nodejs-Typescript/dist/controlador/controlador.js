"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.obtenerEmpleados = exports.editarEmpleado = exports.cargarEmpleado = void 0;
const mysqldb_1 = require("../mysqldb");
const cargarEmpleado = (requ, resp) => {
    const { nombre, apellido, dni, sector, legajo, fechaIngreso, activo } = requ.body;
    var values = [nombre, apellido, dni, sector, legajo, fechaIngreso, activo];
    mysqldb_1.empleadodb.getConnection((err, connection) => {
        if (err) {
            console.error(err);
            return;
        }
        else {
            let sql = "INSERT INTO empleado (nombre, apellido, dni, sector, legajo, fechaIngreso, activo) VALUES (?,?,?,?,?,?,?)";
            connection.query(sql, values, (error, results) => {
                if (error) {
                    console.error(error);
                }
                else if (results) {
                    resp.json({ message: "Empleado cargado correctamente" });
                }
            });
        }
    });
};
exports.cargarEmpleado = cargarEmpleado;
const editarEmpleado = (requ, resp) => {
    requ.body;
};
exports.editarEmpleado = editarEmpleado;
const obtenerEmpleados = (req, resp) => {
    mysqldb_1.empleadodb.getConnection((err, connection) => {
        if (err) {
            console.error(err);
            return;
        }
        else {
            let sql = "SELECT * FROM Empleado";
            connection.query(sql, (e, results) => {
                connection.release();
                resp.json(results);
            });
        }
    });
};
exports.obtenerEmpleados = obtenerEmpleados;
//# sourceMappingURL=controlador.js.map
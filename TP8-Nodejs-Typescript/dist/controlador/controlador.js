"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.mostrarFomulario = exports.cargarEmpleado = void 0;
const mysqldb_1 = require("../mysqldb");
const cargarEmpleado = (requ, resp) => new Promise((resolve, reject) => {
    const { nombre, apellido, dni, sector, fechaIngreso, activo } = requ.body;
    var values = [nombre, apellido, dni, sector, fechaIngreso, activo];
    mysqldb_1.empleadodb.getConnection((err, connection) => {
        if (err) {
            console.error(err);
            return;
        }
        else {
            let sql = "INSERT INTO Empleado (nombre, apellido, dni, sector, fechaIngreso, activo) VALUES (?,?,?,?,?,?)";
            connection.query(sql, values, (error, results) => {
                if (error) {
                    console.error(error);
                }
                else if (results) {
                    resp.json();
                }
            });
        }
    });
});
exports.cargarEmpleado = cargarEmpleado;
const mostrarFomulario = (resp) => {
    mysqldb_1.empleadodb.getConnection((error, connection) => {
        let sql = "SELECT * FROM Empleado";
        connection.query(sql, (error, results) => {
            if (error) {
                console.error(error);
            }
            else if (results) {
                resp.json();
            }
        });
    });
};
exports.mostrarFomulario = mostrarFomulario;
//# sourceMappingURL=controlador.js.map
import { error } from "console";
import { empleadodb } from "../mysqldb";
import { Request, Response } from "express";


export const cargarEmpleado = (requ: Request, resp: Response) => {
    const {nombre, apellido, dni,sector ,legajo ,fechaIngreso, activo} = requ.body;
    var values = [nombre, apellido, dni, sector, legajo, fechaIngreso, activo];
    empleadodb.getConnection((err, connection) => {
        if(err){
            console.error(err)
            return;
        }else{
            let sql = "INSERT INTO empleado (nombre, apellido, dni, sector, legajo, fechaIngreso, activo) VALUES (?,?,?,?,?,?,?)"
            connection.query(sql, values, (error, results) => {
                if(error){
                    console.error(error);
                }else if(results){
                    resp.json({ message: "Empleado cargado correctamente" });
                }
            })
        }

    })
}

export const obtenerEmpleados = (req: any, resp: Response) => {
    empleadodb.getConnection((err, connection) => {
        if(err) {
            console.error(err); return
        }else{
            let sql = "SELECT * FROM Empleado";
            connection.query(sql, (e, results) => {
                connection.release();                   
                resp.json(results)
            })
        }
    })  
}
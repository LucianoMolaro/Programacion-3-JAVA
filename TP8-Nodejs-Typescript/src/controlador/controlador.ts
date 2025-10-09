import { empleadodb } from "../mysqldb";


export const cargarEmpleado = (requ: Request, resp: Response) => new Promise((resolve, reject) => {
    const {nombre, apellido, dni, sector, fechaIngreso, activo} = requ.body;
    var values = [nombre, apellido, dni, sector, fechaIngreso, activo];
    empleadodb.getConnection((err, connection) => {
        if(err){
            console.error(err)
            return;
        }else{
            let sql = "INSERT INTO Empleado (nombre, apellido, dni, sector, fechaIngreso, activo) VALUES (?,?,?,?,?,?)"
            connection.query(sql, values, (error, results) => {
                if(error){
                    console.error(error);
                }else if(results){
                    resp.json();
                }
            })
        }

    })
})

export const mostrarFomulario = (resp: Response) => {
    empleadodb.getConnection ((error, connection)=>{
        let sql = "SELECT * FROM Empleado"
            connection.query(sql, (error, results) => {
                if(error){
                    console.error(error);
                }else if(results){
                    resp.json();
                }
            })

    })
}
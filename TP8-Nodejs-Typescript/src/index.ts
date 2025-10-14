import express from "express";
import rutas from "./rutas";
import path from "path";
const app = express();
// import { controlador } from "./controlador/controlador"

app.use(express.json());

app.use(express.urlencoded({extended: false}))

app.use(express.static(path.join(__dirname, "../src/public")));

app.use(rutas)

app.listen(3000
    , () => {
    console.log("Servidor en puerto 3000", 3000);
})


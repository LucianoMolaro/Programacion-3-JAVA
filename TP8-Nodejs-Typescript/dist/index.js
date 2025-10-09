"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const rutas_1 = __importDefault(require("./rutas"));
const path_1 = __importDefault(require("path"));
const app = (0, express_1.default)();
// import { controlador } from "./controlador/controlador"
app.use(express_1.default.json());
app.use(express_1.default.urlencoded({ extended: false }));
app.use(express_1.default.static(path_1.default.join(__dirname, "public")));
app.use(rutas_1.default);
app.listen(3000, () => {
    console.log("Servidor en puerto 3000", 3000);
});
//# sourceMappingURL=index.js.map
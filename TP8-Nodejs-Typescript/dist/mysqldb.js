"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.empleadodb = void 0;
const mysql_1 = require("mysql");
exports.empleadodb = (0, mysql_1.createPool)({
    host: 'localhost',
    user: 'admin',
    password: '',
    database: 'empleadodb',
    connectionLimit: 100
});
//# sourceMappingURL=mysqldb.js.map
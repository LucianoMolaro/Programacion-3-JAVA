import { createPool } from "mysql"

export const empleadodb = createPool({
    host: 'localhost',
    user: 'admin',
    password: '987645',
    database: 'empleadodb',
    connectionLimit: 100
});
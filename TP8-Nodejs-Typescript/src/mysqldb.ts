import { createPool } from "mysql"

export const empleadodb = createPool({
    host: 'localhost',
    user: 'admin',
    password: '',
    database: 'empleadodb',
    connectionLimit: 100
});
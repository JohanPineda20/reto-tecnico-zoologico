INSERT INTO roles(name, description) VALUES('ADMIN', 'role for an admin user');
INSERT INTO roles(name, description) VALUES('EMPLOYEE', 'role for an employee user');
INSERT INTO users(name, dni, phone, email, password, role_id) VALUES ('admin', '1003896758', '3164559786', 'admin@mail.com', '$2a$10$tZ6cOJHBJ/YzHgYWM2CVdOgo3RpjVcrbRA5rh7voGdhrZ5Gptv/ma', 1);
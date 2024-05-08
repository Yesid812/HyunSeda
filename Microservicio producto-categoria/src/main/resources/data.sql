-- noinspection SqlNoDataSourceInspectionForFile

-- Insertar datos en la tabla Category
INSERT INTO Category (categoryId, name) VALUES
                                            (1, 'Electrónicos'),
                                            (2, 'Ropa'),
                                            (3, 'Libros');

-- Insertar datos en la tabla Product
INSERT INTO Product (name, description, cantidad, price, categoryID) VALUES
                                                                         ('Laptop', 'Laptop de última generación', 5, 1200.00, 1),
                                                                         ('Smartphone', 'Smartphone con cámara de alta resolución', 10, 800.00, 1),
                                                                         ('Camisa', 'Camisa casual para hombres', 20, 50.00, 2),
                                                                         ('Pantalón', 'Pantalón deportivo para mujeres', 15, 40.00, 2),
                                                                         ('Java Programming', 'Libro de programación en Java', 30, 30.00, 3),
                                                                         ('Clean Code', 'Libro sobre buenas prácticas de programación', 25, 35.00, 3),
                                                                         ('Teclado', 'Teclado mecánico para gaming', 10, 100.00, 1),
                                                                         ('Zapatillas', 'Zapatillas deportivas para correr', 20, 60.00, 2),
                                                                         ('Spring in Action', 'Libro sobre el framework Spring', 15, 40.00, 3),
                                                                         ('Monitor', 'Monitor de alta resolución', 8, 300.00, 1);

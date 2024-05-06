-- Creación de la tabla Category si no existe
CREATE TABLE IF NOT EXISTS Category (
                                        categoryId INT PRIMARY KEY,    -- Definición de la columna para el ID de la categoría
                                        name VARCHAR(255) NOT NULL     -- Definición de la columna para el nombre de la categoría
    );

-- Creación de la tabla Product si no existe
CREATE TABLE IF NOT EXISTS Product (
                                       productId INT PRIMARY KEY AUTO_INCREMENT,  -- Definición de la columna para el ID del producto (autoincremental)
                                       name VARCHAR(255) NOT NULL,                -- Definición de la columna para el nombre del producto
    description TEXT,                          -- Definición de la columna para la descripción del producto
    cantidad INT NOT NULL,                     -- Definición de la columna para la cantidad del producto
    price DOUBLE NOT NULL,                     -- Definición de la columna para el precio del producto
    categoryID INT,                            -- Definición de la columna para el ID de la categoría del producto
    FOREIGN KEY (categoryID) REFERENCES Category(categoryId)  -- Definición de la clave externa para la relación con la tabla Category
    );

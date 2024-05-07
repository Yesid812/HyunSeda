-- Crear tabla para la entidad Order

CREATE TABLE IF NOT EXISTS orders (
                       order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       order_date TIMESTAMP NOT NULL,
                       order_state VARCHAR(255) NOT NULL,
                       client_id BIGINT,
                       FOREIGN KEY (client_id) REFERENCES client(id)
);

-- Crear tabla para la entidad ItemDetails
CREATE TABLE IF NOT EXISTS item_details (
                              order_id BIGINT,
                              product_id BIGINT,
                              amount INT,
                              PRIMARY KEY (order_id, product_id),
                              FOREIGN KEY (order_id) REFERENCES orders(order_id),
                              FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO Users (client_id, username, email, password) VALUES (1, 'john_doe', 'john@example.com', 'password123');
INSERT INTO Users (client_id, username, email, password) VALUES (2, 'alice_smith', 'alice@example.com', 'password456');
INSERT INTO Users (client_id, username, email, password) VALUES (3, 'eider_obando', 'eider@example.com', 'password789');
INSERT INTO Users (client_id, username, email, password) VALUES (4, 'jane_doe', 'jane@example.com', 'password321');
INSERT INTO Users (client_id, username, email, password) VALUES (5, 'bob_smith', 'bob@example.com', 'password654');

INSERT INTO roles (role_name) VALUES ('SUPERADMIN');
INSERT INTO roles (role_name) VALUES ('ADMIN');
INSERT INTO roles (role_name) VALUES ('EDITOR');
INSERT INTO roles (role_name) VALUES ('VISITANTE');

INSERT INTO user_role (role_id, user_id) VALUES (1, 1); -- John Doe es SUPERADMIN
INSERT INTO user_role (role_id, user_id) VALUES (2, 2); -- Alice Smith es ADMIN
INSERT INTO user_role (role_id, user_id) VALUES (3, 3); -- Eider Obando es EDITOR
INSERT INTO user_role (role_id, user_id) VALUES (4, 4); -- Jane Doe es VISITANTE
INSERT INTO user_role (role_id, user_id) VALUES (4, 5); -- Bob Smith también es VISITANTE
INSERT INTO roles VALUES
    (0, 'ROLE_ADMIN'),
    (1, 'ROLE_USER');

INSERT INTO users (id, username, password) VALUES (0, 'admin', '$2a$10$avkcsfVe.lh501NWrDGSiOcz4Js.FVytGUPstRyMRN4NX7loxxqGa');

INSERT INTO users_roles VALUES (0, 0);

INSERT INTO qtypes VALUES (1, 'one'), (2, 'few');
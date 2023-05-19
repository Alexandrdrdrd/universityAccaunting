CREATE TABLE if not exists lectors   (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
                                         degree VARCHAR(255) NOT NULL,
                                         salary DOUBLE PRECISION NOT NULL
);


CREATE TABLE if not exists departments (
                                           id SERIAL PRIMARY KEY,
                                           name VARCHAR(255) NOT NULL,
                                           head_id BIGINT,
                                           FOREIGN KEY (head_id) REFERENCES lectors (id)
);


CREATE TABLE if not exists department_lector (
                                                 department_id BIGINT,
                                                 lector_id BIGINT,
                                                 FOREIGN KEY (department_id) REFERENCES departments (id),
                                                 FOREIGN KEY (lector_id) REFERENCES lectors (id),
                                                 PRIMARY KEY (department_id, lector_id)
);
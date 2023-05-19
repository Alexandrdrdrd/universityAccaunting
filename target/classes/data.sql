INSERT INTO lectors (name, degree, salary)
VALUES
    ('John Doe', 'PROFESSOR', 5000),
    ('Jane Smith', 'ASSOCIATE_PROFESSOR', 4000),
    ('Michael Johnson', 'ASSISTANT', 3000);

INSERT INTO departments (name, head_id)
VALUES
    ('Department_1', 1),
    ('Department_2', 2),
    ('Department_3', 3);

INSERT INTO department_lector (department_id, lector_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 1),
    (3, 3);
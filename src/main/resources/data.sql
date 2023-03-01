INSERT INTO character(name, gender)
VALUES ('Shrek', 'Male'),
       ('Fiona', 'Female'),
       ('Mr. Potato', 'Male'),
       ('Ms. Potato', 'Female');

INSERT INTO franchise(name, description)
VALUES ('Shrek', 'DescriptionText'),
       ('Toy Story', 'DescriptionText');

INSERT INTO movie(title, release_year, franchise_id)
VALUES ('Toy Story', 1996, 2),
       ('Toy Story 2', 2000, 2),
       ('Shrek', 2001, 1),
       ('Shrek 2', 2004, 1);

INSERT INTO character_movie(character_id, movie_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 2);
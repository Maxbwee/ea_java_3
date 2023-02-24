INSERT INTO character(id, name, gender)
VALUES (1, 'Shrek', 'Male'),
       (2, 'Fiona', 'Female'),
       (3, 'Mr. Potato', 'Male'),
       (4, 'Ms. Potato', 'Female');

INSERT INTO franchise(id, name, description)
VALUES (1, 'Shrek', 'DescriptionText'),
       (2, 'Toy Story', 'DescriptionText');

INSERT INTO movie(id, title, release_year, franchise_id)
VALUES (1, 'Toy Story', 1996, 2),
       (2, 'Toy Story 2', 2000, 2),
       (3, 'Shrek', 2001, 1),
       (4, 'Shrek 2', 2004, 1);

INSERT INTO character_movie(character_id, movie_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 2);
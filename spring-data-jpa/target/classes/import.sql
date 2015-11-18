insert into library (id, name) values (1, 'Mediateka');

insert into book (id, title, library_id) values (1, 'The lord of the rings', 1);
insert into book (id, title, library_id) values (2, 'Harry Potter', 1);
insert into book (id, title, library_id) values (3, 'Prawdziwych bohaterow...', 1);

insert into author (id, name, surname) values (1, 'J. R. R.', 'Tolkien');
insert into author (id, name, surname) values (2, 'Joanne', 'Rowling');
insert into author (id, name, surname) values (3, 'Katarzyna', 'Masiarek');

insert into book_authors (book_id, author_id) values (1, 1);
insert into book_authors (book_id, author_id) values (2, 2);
insert into book_authors (book_id, author_id) values (3, 3);
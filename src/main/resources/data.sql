insert into bands (id,genre,name_Band) VALUES (1, 'pop','riri');
insert into bands (id,genre,name_Band) VALUES (2, 'pop','justin bieber');
insert into bands (id,genre,name_Band) VALUES (3, 'pop','one direction');
insert into bands (id,genre,name_Band) VALUES (4, 'pop','taylor swift');
insert into bands (id,genre,name_Band) VALUES (5, 'pop','harry styles');
insert into bands (id,genre,name_Band) VALUES (6, 'pop','justin timberlake');
insert into users (id, password, role, username) VALUES (1, '$2a$12$hiSA6K80jUVyL0sLmbKERuWGLAVo3GrDcB8gmHDMJ6XFH.cNLzFH.', 'ADMIN', 'admin');
insert into users (id, password, role, username) VALUES (2, '$2a$12$bVOsI3JmYXg2Zt.5Ae6Q/u3X5sQkXewVh5unhe6ZaqgTKDCfyRLOe',
                                                         'CASHIER', 'richard');
insert into users (id, password, role, username) VALUES (3, '$2a$12$DkCKE1NqoxZ1P/k8JmpTqu5L.8rHRYpSLMLm.HKi20YiJRENHRaDS',
                                                         'CASHIER', 'eugen');
insert into users (id, password, role, username) VALUES (4, '$2a$12$u6MdnNmZmImTbC4CcQ3HZOzuxf4JcWilvqBwOHZMiyfJzabt5nHHi',
                                                         'CASHIER', 'baka');
insert into users (id, password, role, username) VALUES (5, '$2a$12$kHRUBeyhP0mwarqb7mvVIOy3xDKGC46f9NOKIqGIyggzJbrTDgnbO',
                                                         'CASHIER', 'cenan');
insert into concerts (id, date_time_concert, name_concert, no_tickets) VALUES (1, '20 aprilie - 20:30', 'Disney Concert', 100);
insert into concerts (id, date_time_concert, name_concert, no_tickets) VALUES (2, '5 martie - 10:00', 'Goth Concert', 100);
insert into concerts (id, date_time_concert, name_concert, no_tickets) VALUES (3, '17 ianuarie - 00:30', 'Rock Concert', 100);
insert into concerts (id, date_time_concert, name_concert, no_tickets) VALUES (4, '14 noiembrie - 23:30', 'DnB Concert', 100);
insert into concerts (id, date_time_concert, name_concert, no_tickets) VALUES (5, '3 mai - 16:30', 'Classical Concert', 100);

insert into tickets (id, concert_id, places, price) VALUES (100, 1, 4, 20);
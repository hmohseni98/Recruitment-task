INSERT INTO person (first_name, last_name, is_customer)
VALUES ('hassan', 'mohseni', true),
       ('sara', 'hamzeh', false),
       ('ali', 'karimi', false),
       ('javad', 'rezaee', true),
       ('ahmad', 'gholami', true),
       ('sahra', 'mahmoudi', true);


INSERT INTO product (name, description, price, review_available, review_mode, is_visible,
                     is_paid_customer_comment_allowed)
VALUES ('A50', 'this is a cellphone', 8500000, 'ONLY_COMMENT', 'PUBLIC_MODE', true, true),
       ('Redmi Note 7', 'this is a cellphone', 4500000, 'COMMENT_AND_VOTE', 'CUSTOMER_MODE', true, false),
       ('13 pro max', 'this is a cellphone', 65000000, 'ONLY_VOTE', 'CUSTOMER_MODE', false, false);

INSERT INTO cart (is_paid, person_id, product_id)
VALUES (true, 1, 1),
       (false, 1, 2),
       (true, 2, 3),
       (true, 3, 1),
       (true, 4, 1),
       (true, 5, 1),
       (true, 6, 1);

INSERT INTO comment (description, is_approved, person_id, cart_id)
VALUES ('kheili khobe', true, 1, 1),
       ('pishnahad mikonam', true, 1, 2),
       ('hatman pishnahad mikonam', false, 2, 3),
       ('badak nist', false, 3, 4),
       ('mikham bazaam bekharam', false, 4, 5),
       ('khob nist kharab bood', false, 5, 6),
       ('bad nist', false, 6, 7);

INSERT INTO vote (rating, is_approved, person_id, product_id)
VALUES (4, true, 1, 1),
       (5, true, 1, 2),
       (4, true, 2, 3),
       (3, false, 3, 1),
       (4, false, 4, 1),
       (2, false, 5, 1),
       (3, false, 6, 1);
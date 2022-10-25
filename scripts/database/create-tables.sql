CREATE TABLE IF NOT EXISTS addresses
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    line1     VARCHAR(99),
    line2      VARCHAR(99),
    line3      VARCHAR(99),
    line4      VARCHAR(99),
    locality      VARCHAR(20),
    region VARCHAR(99),
    country VARCHAR(99),
    post_code VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS contact_infos
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    email    VARCHAR(99),
    phone VARCHAR(99),
    mobile_phone VARCHAR(99),
    address_id int,
    CONSTRAINT fk_contact_address FOREIGN KEY (address_id) REFERENCES addresses (id)
);

CREATE TABLE IF NOT EXISTS authors
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    first_name VARCHAR(99),
    last_name VARCHAR(99),
    about_text text,
    photo_url VARCHAR(255),
    website VARCHAR(255),
    dob VARCHAR(20),
    country VARCHAR(99),
    education VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS books
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    title VARCHAR(255),
    description text,
    image_url VARCHAR(255),
    isbn VARCHAR(99),
    language VARCHAR(99)
);

CREATE TABLE IF NOT EXISTS book_editions
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    book_id int,
    edition    VARCHAR(99),
    volume VARCHAR(99),
    isbn VARCHAR(99),
    CONSTRAINT fk_book_editions_book FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE TABLE IF NOT EXISTS book_authors
(
    book_id int,
    author_id int,
    book_name VARCHAR(255),
    author_first_name VARCHAR(99),
    author_last_name VARCHAR(99),
    CONSTRAINT fk_bookauthors_book FOREIGN KEY (book_id) REFERENCES books (id),
    CONSTRAINT fk_bookauthors_authors FOREIGN KEY (author_id) REFERENCES authors (id)
);

CREATE TABLE IF NOT EXISTS book_inventories
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    book_id int,
    edition_id int,
    total_count int,
    avl_count int,
    borrowed int,
    suspended int,
    CONSTRAINT fk_inventory_book FOREIGN KEY (book_id) REFERENCES books (id),
    CONSTRAINT fk_inventory_edition FOREIGN KEY (edition_id) REFERENCES book_editions (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    user_id     VARCHAR(99),
    first_name  VARCHAR(99),
    last_name VARCHAR(99),
    contact_id int,
    CONSTRAINT fk_user_contact FOREIGN KEY (contact_id) REFERENCES contact_infos (id)
);

CREATE TABLE IF NOT EXISTS leases
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    inventory_id int,
    user_id int,
    state    VARCHAR(20),
    lease_time BIGINT,
    return_time BIGINT,
    expiry_date VARCHAR(20),
    renewals VARCHAR(255),
    CONSTRAINT fk_lease_inventory FOREIGN KEY (inventory_id) REFERENCES book_inventories (id),
    CONSTRAINT fk_lease_user FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS reviews
(
    id            SERIAL PRIMARY KEY,
    status        char(1),
    creation_time BIGINT,
    mod_time      BIGINT,
    user_id int,
    book_id int,
    title     VARCHAR(255),
    content text,
    rating INT,
    start_date VARCHAR(20),
    end_date VARCHAR(20),
    shelves VARCHAR(255),
    CONSTRAINT fk_reviews_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_reviews_book FOREIGN KEY (book_id) REFERENCES books (id)
);


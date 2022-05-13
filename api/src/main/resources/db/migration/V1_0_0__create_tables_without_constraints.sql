create table "user"
(
    id          uuid primary key,
    first_name  varchar(64) not null,
    middle_name varchar(64) not null,
    last_name   varchar(64) not null,
    birth_date  timestamp   not null,
    fk_address  varchar     not null references address (id),
    login       varchar(50) not null,
    password    varchar     not null,
    created     timestamp   not null,
    updated     timestamp   not null,
    deleted     timestamp
);

create table airport
(
    id          uuid primary key,
    name        varchar   not null,
    description varchar   not null,
    location    varchar   not null,
    created     timestamp not null,
    updated     timestamp not null,
    deleted     timestamp
);

create table flight
(
    id              uuid primary key,
    name            varchar(100) not null,
    description     varchar(500),
    fk_airport_from varchar      not null references airport (id),
    fk_airport_to   varchar      not null references airport (id),
    place_amount    int2         not null,
    departure_time  timestamp    not null,
    arrival_time    timestamp    not null,
    status          varchar      not null,
    created         timestamp    not null,
    updated         timestamp    not null,
    deleted         timestamp
);

create table ticket
(
    id            uuid primary key,
    fk_flight     varchar          not null,
    fk_user       varchar          not null,
    status        varchar          not null,
    bidirectional bool             not null,
    created       timestamp        not null,
    updated       timestamp        not null,
    deleted       timestamp
);

create table address
(
    id       uuid primary key,
    country  varchar(96) not null,
    state    varchar(64),
    region   varchar(64),
    district varchar(64),
    locality varchar(64) not null,
    street   varchar(64) not null,
    home     varchar(16) not null
)
# travelbd

** Database Setup:  **

** In this project postgres database is used **

username: postgres
password: 123
port: 5432


there are four tables. below are the sql query to create them:

******************************************************************************
CREATE TABLE public.location
(
    id bigint NOT NULL DEFAULT nextval('pk_location'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Location_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.location
    OWNER to postgres;

CREATE TABLE public.privacy
(
    id integer NOT NULL DEFAULT nextval('pk_privacy'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT privacy_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.privacy
    OWNER to postgres;

CREATE TABLE public.users
(
    id bigint NOT NULL DEFAULT nextval('pk_users'::regclass),
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    phone character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;

CREATE TABLE public.status
(
    id bigint NOT NULL DEFAULT nextval('pk_status'::regclass),
    "userId" bigint,
    text character varying COLLATE pg_catalog."default",
    "locationId" bigint,
    "privacyId" bigint,
    CONSTRAINT status_pkey PRIMARY KEY (id),
    CONSTRAINT fk_location FOREIGN KEY ("locationId")
        REFERENCES public.location (id) MATCH SIMPLE,
    CONSTRAINT fk_privacy FOREIGN KEY ("privacyId")
        REFERENCES public.privacy (id) MATCH SIMPLE,
    CONSTRAINT fk_users FOREIGN KEY ("userId")
        REFERENCES public.users (id) MATCH SIMPLE
)

TABLESPACE pg_default;

ALTER TABLE public.status
    OWNER to postgres;


******************************************************************************


** How to run the project  **

*The project folder is the travelbd>travelbd folder
*From the browser hit url "http://localhost:8080/initial". username is username and password is password.
*There are three tabs. Tab 1 shows all the publicly posted statuses. 
*Tab 2 shows only user specific status (for now the user id has been kept 2 as static)
*Tab 3 gives the option to post a new status(It shows a textarea for status, Radio buttons for public private status (public 2 private 3) and dropdown for the places.)

** For the APIs **

purpose, request and response example is added with each API for better understanding

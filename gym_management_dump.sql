--
-- PostgreSQL database dump
--

-- Dumped from database version 14.18 (Homebrew)
-- Dumped by pg_dump version 14.18 (Homebrew)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: gym_merch; Type: TABLE; Schema: public; Owner: keyin
--

CREATE TABLE public.gym_merch (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    type character varying(50),
    price numeric(10,2) NOT NULL,
    stock integer NOT NULL
);


ALTER TABLE public.gym_merch OWNER TO keyin;

--
-- Name: gym_merch_id_seq; Type: SEQUENCE; Schema: public; Owner: keyin
--

CREATE SEQUENCE public.gym_merch_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gym_merch_id_seq OWNER TO keyin;

--
-- Name: gym_merch_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: keyin
--

ALTER SEQUENCE public.gym_merch_id_seq OWNED BY public.gym_merch.id;


--
-- Name: memberships; Type: TABLE; Schema: public; Owner: keyin
--

CREATE TABLE public.memberships (
    id integer NOT NULL,
    member_id integer,
    type character varying(50) NOT NULL,
    description text,
    cost numeric(10,2),
    start_date date DEFAULT CURRENT_DATE,
    end_date date
);


ALTER TABLE public.memberships OWNER TO keyin;

--
-- Name: memberships_id_seq; Type: SEQUENCE; Schema: public; Owner: keyin
--

CREATE SEQUENCE public.memberships_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.memberships_id_seq OWNER TO keyin;

--
-- Name: memberships_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: keyin
--

ALTER SEQUENCE public.memberships_id_seq OWNED BY public.memberships.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: keyin
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(20) NOT NULL,
    phone_number character varying(20),
    address text
);


ALTER TABLE public.users OWNER TO keyin;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: keyin
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO keyin;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: keyin
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: workout_classes; Type: TABLE; Schema: public; Owner: keyin
--

CREATE TABLE public.workout_classes (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    schedule character varying(100),
    trainer_id integer
);


ALTER TABLE public.workout_classes OWNER TO keyin;

--
-- Name: workout_classes_id_seq; Type: SEQUENCE; Schema: public; Owner: keyin
--

CREATE SEQUENCE public.workout_classes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.workout_classes_id_seq OWNER TO keyin;

--
-- Name: workout_classes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: keyin
--

ALTER SEQUENCE public.workout_classes_id_seq OWNED BY public.workout_classes.id;


--
-- Name: gym_merch id; Type: DEFAULT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.gym_merch ALTER COLUMN id SET DEFAULT nextval('public.gym_merch_id_seq'::regclass);


--
-- Name: memberships id; Type: DEFAULT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.memberships ALTER COLUMN id SET DEFAULT nextval('public.memberships_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: workout_classes id; Type: DEFAULT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.workout_classes ALTER COLUMN id SET DEFAULT nextval('public.workout_classes_id_seq'::regclass);


--
-- Data for Name: gym_merch; Type: TABLE DATA; Schema: public; Owner: keyin
--

COPY public.gym_merch (id, name, type, price, stock) FROM stdin;
1	Protein Bar	Snack	2.99	100
2	Shaker Bottle	Gear	9.99	50
3	Yoga Mat	Gear	19.99	30
4	Electrolyte Drink	Drink	3.49	75
\.


--
-- Data for Name: memberships; Type: TABLE DATA; Schema: public; Owner: keyin
--

COPY public.memberships (id, member_id, type, description, cost, start_date, end_date) FROM stdin;
1	3	Monthly	\N	49.99	2025-08-01	2025-08-31
2	2	Annual	\N	499.99	2025-01-01	2025-12-31
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: keyin
--

COPY public.users (id, name, email, password, role, phone_number, address) FROM stdin;
1	Alice Admin	alice@gym.com	hashedpassword1	Admin	555-0001	100 Admin Blvd
2	Tom Trainer	tom@gym.com	hashedpassword2	Trainer	555-0002	200 Trainer St
3	Megan Member	megan@gym.com	hashedpassword3	Member	555-0003	300 Member Rd
\.


--
-- Data for Name: workout_classes; Type: TABLE DATA; Schema: public; Owner: keyin
--

COPY public.workout_classes (id, name, schedule, trainer_id) FROM stdin;
1	Zumba	Mondays 5PM	2
2	Yoga Flow	Tuesdays 6PM	2
\.


--
-- Name: gym_merch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: keyin
--

SELECT pg_catalog.setval('public.gym_merch_id_seq', 4, true);


--
-- Name: memberships_id_seq; Type: SEQUENCE SET; Schema: public; Owner: keyin
--

SELECT pg_catalog.setval('public.memberships_id_seq', 2, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: keyin
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- Name: workout_classes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: keyin
--

SELECT pg_catalog.setval('public.workout_classes_id_seq', 2, true);


--
-- Name: gym_merch gym_merch_pkey; Type: CONSTRAINT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.gym_merch
    ADD CONSTRAINT gym_merch_pkey PRIMARY KEY (id);


--
-- Name: memberships memberships_pkey; Type: CONSTRAINT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.memberships
    ADD CONSTRAINT memberships_pkey PRIMARY KEY (id);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: workout_classes workout_classes_pkey; Type: CONSTRAINT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.workout_classes
    ADD CONSTRAINT workout_classes_pkey PRIMARY KEY (id);


--
-- Name: memberships memberships_member_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.memberships
    ADD CONSTRAINT memberships_member_id_fkey FOREIGN KEY (member_id) REFERENCES public.users(id) ON DELETE CASCADE;


--
-- Name: workout_classes workout_classes_trainer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: keyin
--

ALTER TABLE ONLY public.workout_classes
    ADD CONSTRAINT workout_classes_trainer_id_fkey FOREIGN KEY (trainer_id) REFERENCES public.users(id) ON DELETE SET NULL;


--
-- PostgreSQL database dump complete
--


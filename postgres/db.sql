--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-05-29 20:03:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 204 (class 1259 OID 16432)
-- Name: accounts_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.accounts_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.accounts_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16434)
-- Name: accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accounts (
    account_id integer DEFAULT nextval('public.accounts_seq'::regclass) NOT NULL,
    email character varying(100),
    password character varying(100),
    account_type character varying(30),
    user_id integer,
    last_time_active timestamp without time zone
);


ALTER TABLE public.accounts OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16408)
-- Name: courses_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.courses_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.courses_seq OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16410)
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.courses (
    course_id integer DEFAULT nextval('public.courses_seq'::regclass) NOT NULL,
    title character varying(200),
    number_of_hours integer,
    hours_for_lectures integer,
    hours_for_practice integer,
    lecturer_id integer
);


ALTER TABLE public.courses OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16416)
-- Name: realized_courses_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.realized_courses_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.realized_courses_seq OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16418)
-- Name: realized_courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.realized_courses (
    realized_course_id integer DEFAULT nextval('public.realized_courses_seq'::regclass) NOT NULL,
    course_id integer,
    start_date timestamp without time zone,
    end_date timestamp without time zone,
    exam_date timestamp without time zone,
    status character varying(30)
);


ALTER TABLE public.realized_courses OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16440)
-- Name: statuses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statuses (
    status_title character varying(30) NOT NULL
);


ALTER TABLE public.statuses OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16424)
-- Name: students_courses_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.students_courses_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.students_courses_seq OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16426)
-- Name: students_courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.students_courses (
    student_course_id integer DEFAULT nextval('public.students_courses_seq'::regclass) NOT NULL,
    student_id integer,
    realized_course_id integer,
    mark integer
);


ALTER TABLE public.students_courses OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16397)
-- Name: users_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_seq OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16399)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer DEFAULT nextval('public.users_seq'::regclass) NOT NULL,
    email character varying(100),
    password character varying(100),
    name character varying(100),
    surname character varying(100),
    date_entered timestamp without time zone,
    role character varying(50),
    token character varying(100)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16468)
-- Name: student_lecturers_view; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.student_lecturers_view AS
 SELECT sc.student_id,
    l.user_id,
    l.name,
    l.surname,
    l.date_entered,
    l.role,
    l.password,
    l.email
   FROM (((public.students_courses sc
     JOIN public.realized_courses rc USING (realized_course_id))
     JOIN public.courses c USING (course_id))
     JOIN public.users l ON ((l.user_id = c.lecturer_id)));


ALTER TABLE public.student_lecturers_view OWNER TO postgres;

--
-- TOC entry 2866 (class 0 OID 16434)
-- Dependencies: 205
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.accounts (account_id, email, password, account_type, user_id, last_time_active) FROM stdin;
\.


--
-- TOC entry 2860 (class 0 OID 16410)
-- Dependencies: 199
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.courses (course_id, title, number_of_hours, hours_for_lectures, hours_for_practice, lecturer_id) FROM stdin;
1	Economics	10	100	50	2
2	The arts	20	200	120	3
3	Math	20	200	120	3
59	newCourse	2	3	4	1
67	newCourse	2	3	4	1
75	newCourse	2	3	4	1
27	newCourse	2	3	4	1
35	newCourse	2	3	4	1
43	newCourse	2	3	4	1
51	newCourse	2	3	4	1
\.


--
-- TOC entry 2862 (class 0 OID 16418)
-- Dependencies: 201
-- Data for Name: realized_courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.realized_courses (realized_course_id, course_id, start_date, end_date, exam_date, status) FROM stdin;
1	1	2019-06-03 00:00:00	2019-08-22 00:00:00	2019-08-24 00:00:00	announced
2	3	2019-09-11 00:00:00	2020-03-09 00:00:00	2020-03-11 00:00:00	announced
3	1	2019-01-14 00:00:00	2019-05-04 00:00:00	2019-05-06 00:00:00	closed
4	2	2019-06-15 00:00:00	2019-11-30 00:00:00	2019-12-04 00:00:00	archived
55	1	1970-01-01 02:00:00.666	1970-01-01 02:00:00.555	1970-01-01 02:00:00.888	announced
64	1	1970-01-01 02:00:00.666	1970-01-01 02:00:00.555	1970-01-01 02:00:00.888	announced
73	1	1970-01-01 02:00:00.666	1970-01-01 02:00:00.555	1970-01-01 02:00:00.888	announced
28	1	1970-01-01 02:00:00.666	1970-01-01 02:00:00.555	1970-01-01 02:00:00.888	announced
82	1	1970-01-01 02:00:00.666	1970-01-01 02:00:00.555	1970-01-01 02:00:00.888	announced
37	1	1970-01-01 02:00:00.666	1970-01-01 02:00:00.555	1970-01-01 02:00:00.888	announced
46	1	1970-01-01 02:00:00.666	1970-01-01 02:00:00.555	1970-01-01 02:00:00.888	announced
\.


--
-- TOC entry 2867 (class 0 OID 16440)
-- Dependencies: 206
-- Data for Name: statuses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.statuses (status_title) FROM stdin;
announced
in progress
closed
archived
\.


--
-- TOC entry 2864 (class 0 OID 16426)
-- Dependencies: 203
-- Data for Name: students_courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.students_courses (student_course_id, student_id, realized_course_id, mark) FROM stdin;
1	4	1	\N
2	5	4	\N
4	4	3	\N
6	6	1	\N
7	6	2	\N
3	4	2	3
\.


--
-- TOC entry 2858 (class 0 OID 16399)
-- Dependencies: 197
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, email, password, name, surname, date_entered, role, token) FROM stdin;
66	danarossa14student@gmail.com	$2a$10$mA2TjINRYlV5QeoAwTMp8eS.rgpTiZ.vql4Uj/.UDNhin.Mq4X7bm	bogdanastudent	danarossastudent	2019-05-27 00:00:00	STUDENT	\N
67	danarossa@gmail.com	$2a$10$.L3L3uL8wOpFrxUKBc9MweDFfS1SdRY41ChTnYPLOdscD7moaYqd6	dana	rossa	2019-05-27 00:00:00	ADMIN	\N
1	nickfrost@gmail.com	$2a$10$ptQrJgZXktnPoMDs6XFR8.l8IFqle90iqoJo5aSwe6AUq1k1pVCqW	Nick	Frost	2019-05-14 00:00:00	TRAINER	\N
2	simonpegg@gmail.com	$2a$10$QbxQYCNloe0u/LJyGREHIuyVobSg0hGbns9MyyCzvvKMWMNq7FZ56	Simon	Pegg	2015-02-25 00:00:00	TRAINER	\N
6	tomhiddleston@gmail.com	$2a$10$Ror9e2L0G5Le1o4srkYJ9u5v0WvmbLhim6GJtdgGXZdeg2p4Uwudq	Tom	Hiddleston	2019-05-14 00:00:00	STUDENT	\N
5	benedictcumberbatch@gmail.com	$2a$10$gK4urZT1I1yEWPx1Dc8gK.LeuHIRp0Mti7RJmK4Ho5Bvfbuua23Wi	Benedict	Cumberbatch	2019-05-14 00:00:00	STUDENT	
61	nanny@gmail.com	$2a$10$Vrp6YYaFO11nqHFKND4WHeVDeTmiWlakvzMaQe5PxETDtvoEHkpk2	new 	n	2019-05-19 00:00:00	TRAINER	\N
62	new@gmail.com	$2a$10$eNcfoAQfrg1mO8dCp1rWX.kHxg3505GU5oxJly8a0yMQwni1LTGVK	new	new	2019-05-19 00:00:00	TRAINER	\N
3	edgarwright@gmail.com	$2a$10$RLEAYZGdJN.KYXjMMzodje4bqhLqIXipYOyPYrgbf/m.bzyA6zvYy	Edgar	Wright	2019-05-14 00:00:00	TRAINER	
60	benn@gmail.com	$2a$10$guBQCEXGfj.gHr7SfhnlJePJpa5q7JJwiYdlNDC28szRvBp4lOCtO	Benn	Teller	2019-05-19 00:00:00	STUDENT	[B@3682c3c9
4	martinfreeman@gmail.com	$2a$10$Wir5D4WBV12ScPzP7UIvJ.rl6JwdiXZLXuowlT07e8xghMcPgWV.G	Martin	Freeman	2019-05-14 00:00:00	STUDENT	[B@2c206365
65	newOne@gmail.com	$2a$10$21hs5zwZbMjvvg/IKiwG5Og.LBnCb0H6CrLhv854M/eQnKM5aM5g.	New	newnewnew	2019-05-14 00:00:00	TRAINER	\N
68	marko@gmail.com	$2a$10$9zehSNiyJO3eYQtZoD8aNuMf.teFrpEPaWzfD4xvSYUa5ZHBk4XNq	marko	polo	2019-05-27 22:46:52.504	STUDENT	\N
\.


--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 204
-- Name: accounts_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.accounts_seq', 1, false);


--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 198
-- Name: courses_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.courses_seq', 76, true);


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 200
-- Name: realized_courses_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.realized_courses_seq', 85, true);


--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 202
-- Name: students_courses_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.students_courses_seq', 57, true);


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 196
-- Name: users_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_seq', 68, true);


--
-- TOC entry 2732 (class 2606 OID 16439)
-- Name: accounts accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (account_id);


--
-- TOC entry 2726 (class 2606 OID 16415)
-- Name: courses courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (course_id);


--
-- TOC entry 2728 (class 2606 OID 16423)
-- Name: realized_courses realized_courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.realized_courses
    ADD CONSTRAINT realized_courses_pkey PRIMARY KEY (realized_course_id);


--
-- TOC entry 2734 (class 2606 OID 16444)
-- Name: statuses statuses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statuses
    ADD CONSTRAINT statuses_pkey PRIMARY KEY (status_title);


--
-- TOC entry 2730 (class 2606 OID 16431)
-- Name: students_courses students_courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students_courses
    ADD CONSTRAINT students_courses_pkey PRIMARY KEY (student_course_id);


--
-- TOC entry 2724 (class 2606 OID 16407)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


-- Completed on 2019-05-29 20:03:37

--
-- PostgreSQL database dump complete
--


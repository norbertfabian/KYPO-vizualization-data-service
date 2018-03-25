--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-10-23 10:17:34 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2259 (class 0 OID 47127)
-- Dependencies: 189
-- Data for Name: hardware; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO hardware VALUES (1);
INSERT INTO hardware VALUES (2);
INSERT INTO hardware VALUES (3);
INSERT INTO hardware VALUES (4);
INSERT INTO hardware VALUES (5);
INSERT INTO hardware VALUES (6);
INSERT INTO hardware VALUES (7);
INSERT INTO hardware VALUES (8);
INSERT INTO hardware VALUES (9);


--
-- TOC entry 2262 (class 0 OID 47140)
-- Dependencies: 192
-- Data for Name: logical_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO logical_role VALUES (1, 'attacker');


--
-- TOC entry 2263 (class 0 OID 47146)
-- Dependencies: 193
-- Data for Name: measurable; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO measurable VALUES (1);
INSERT INTO measurable VALUES (6);
INSERT INTO measurable VALUES (7);
INSERT INTO measurable VALUES (8);
INSERT INTO measurable VALUES (9);


--
-- TOC entry 2268 (class 0 OID 47174)
-- Dependencies: 198
-- Data for Name: physical_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO physical_role VALUES (1, 'desktop');


--
-- TOC entry 2265 (class 0 OID 47159)
-- Dependencies: 195
-- Data for Name: node; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO node VALUES ('Pc1', 1, 1);


--
-- TOC entry 2256 (class 0 OID 47114)
-- Dependencies: 186
-- Data for Name: assigned_logical_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO assigned_logical_role VALUES (1, -9223372036854775808, 9223372036854775807, 1, 1);


--
-- TOC entry 2275 (class 0 OID 0)
-- Dependencies: 185
-- Name: assigned_logical_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('assigned_logical_role_id_seq', 1, true);


--
-- TOC entry 2257 (class 0 OID 47120)
-- Dependencies: 187
-- Data for Name: connectable; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO connectable VALUES (NULL, 2);
INSERT INTO connectable VALUES (NULL, 3);
INSERT INTO connectable VALUES (NULL, 4);
INSERT INTO connectable VALUES (NULL, 5);


--
-- TOC entry 2276 (class 0 OID 0)
-- Dependencies: 188
-- Name: hardware_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hardware_id_seq', 9, true);


--
-- TOC entry 2260 (class 0 OID 47133)
-- Dependencies: 190
-- Data for Name: link; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO link VALUES ('Pc', 6, 4, 3);
INSERT INTO link VALUES ('Network1', 7, 3, 4);
INSERT INTO link VALUES ('Pc', 8, 5, 2);
INSERT INTO link VALUES ('Network2', 9, 2, 5);


--
-- TOC entry 2277 (class 0 OID 0)
-- Dependencies: 191
-- Name: logical_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('logical_role_id_seq', 1, true);


--
-- TOC entry 2264 (class 0 OID 47151)
-- Dependencies: 194
-- Data for Name: network; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO network VALUES ('150.150.1.1', NULL, NULL, NULL, 'Lan1', 4);
INSERT INTO network VALUES ('150.150.2.1', NULL, NULL, NULL, 'Lan2', 5);


--
-- TOC entry 2266 (class 0 OID 47164)
-- Dependencies: 196
-- Data for Name: node_interface; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO node_interface VALUES ('150.150.2.2', NULL, 2, 1);
INSERT INTO node_interface VALUES ('150.150.1.2', NULL, 3, 1);


--
-- TOC entry 2278 (class 0 OID 0)
-- Dependencies: 197
-- Name: physical_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('physical_role_id_seq', 1, true);


--
-- TOC entry 2270 (class 0 OID 47182)
-- Dependencies: 200
-- Data for Name: property; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO property VALUES (1, 'RAM', 'GB', '8', 1);
INSERT INTO property VALUES (2, 'Bandwidth', 'MB/s', '100', 6);
INSERT INTO property VALUES (3, 'Bandwidth', 'MB/s', '100', 7);
INSERT INTO property VALUES (4, 'Bandwidth', 'MB/s', '100', 8);
INSERT INTO property VALUES (5, 'Bandwidth', 'MB/s', '100', 9);


--
-- TOC entry 2279 (class 0 OID 0)
-- Dependencies: 199
-- Name: property_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('property_id_seq', 5, true);


-- Completed on 2017-10-23 10:17:34 CEST

--
-- PostgreSQL database dump complete
--


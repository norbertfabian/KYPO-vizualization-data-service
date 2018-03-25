--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-10-23 10:11:36 CEST

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
-- TOC entry 2259 (class 0 OID 46973)
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
INSERT INTO hardware VALUES (10);
INSERT INTO hardware VALUES (11);
INSERT INTO hardware VALUES (12);
INSERT INTO hardware VALUES (13);
INSERT INTO hardware VALUES (14);
INSERT INTO hardware VALUES (15);
INSERT INTO hardware VALUES (16);
INSERT INTO hardware VALUES (17);
INSERT INTO hardware VALUES (18);
INSERT INTO hardware VALUES (19);
INSERT INTO hardware VALUES (20);
INSERT INTO hardware VALUES (21);
INSERT INTO hardware VALUES (22);
INSERT INTO hardware VALUES (23);
INSERT INTO hardware VALUES (24);
INSERT INTO hardware VALUES (25);


--
-- TOC entry 2262 (class 0 OID 46986)
-- Dependencies: 192
-- Data for Name: logical_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO logical_role VALUES (1, 'attacker');
INSERT INTO logical_role VALUES (2, 'victim');


--
-- TOC entry 2263 (class 0 OID 46992)
-- Dependencies: 193
-- Data for Name: measurable; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO measurable VALUES (1);
INSERT INTO measurable VALUES (3);
INSERT INTO measurable VALUES (5);
INSERT INTO measurable VALUES (7);
INSERT INTO measurable VALUES (12);
INSERT INTO measurable VALUES (13);
INSERT INTO measurable VALUES (14);
INSERT INTO measurable VALUES (15);
INSERT INTO measurable VALUES (16);
INSERT INTO measurable VALUES (17);
INSERT INTO measurable VALUES (18);
INSERT INTO measurable VALUES (19);
INSERT INTO measurable VALUES (20);
INSERT INTO measurable VALUES (21);
INSERT INTO measurable VALUES (22);
INSERT INTO measurable VALUES (23);
INSERT INTO measurable VALUES (24);
INSERT INTO measurable VALUES (25);


--
-- TOC entry 2268 (class 0 OID 47020)
-- Dependencies: 198
-- Data for Name: physical_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO physical_role VALUES (1, 'desktop');
INSERT INTO physical_role VALUES (2, 'server');


--
-- TOC entry 2265 (class 0 OID 47005)
-- Dependencies: 195
-- Data for Name: node; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO node VALUES ('Pc1', 1, 1);
INSERT INTO node VALUES ('Pc2', 3, 1);
INSERT INTO node VALUES ('Pc3', 5, 1);
INSERT INTO node VALUES ('Server', 7, 2);


--
-- TOC entry 2256 (class 0 OID 46960)
-- Dependencies: 186
-- Data for Name: assigned_logical_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO assigned_logical_role VALUES (1, -9223372036854775808, 9223372036854775807, 1, 1);
INSERT INTO assigned_logical_role VALUES (2, -9223372036854775808, 9223372036854775807, 2, 3);


--
-- TOC entry 2275 (class 0 OID 0)
-- Dependencies: 185
-- Name: assigned_logical_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('assigned_logical_role_id_seq', 2, true);


--
-- TOC entry 2257 (class 0 OID 46966)
-- Dependencies: 187
-- Data for Name: connectable; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO connectable VALUES (NULL, 2);
INSERT INTO connectable VALUES (NULL, 4);
INSERT INTO connectable VALUES (NULL, 6);
INSERT INTO connectable VALUES (NULL, 8);
INSERT INTO connectable VALUES (NULL, 9);
INSERT INTO connectable VALUES (NULL, 10);
INSERT INTO connectable VALUES (NULL, 11);


--
-- TOC entry 2276 (class 0 OID 0)
-- Dependencies: 188
-- Name: hardware_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hardware_id_seq', 25, true);


--
-- TOC entry 2260 (class 0 OID 46979)
-- Dependencies: 190
-- Data for Name: link; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO link VALUES ('Pc1', 12, 9, 2);
INSERT INTO link VALUES ('Network1', 13, 2, 9);
INSERT INTO link VALUES ('Pc2', 14, 9, 4);
INSERT INTO link VALUES ('Network1', 15, 4, 9);
INSERT INTO link VALUES ('Network2', 16, 8, 10);
INSERT INTO link VALUES ('Server', 17, 10, 8);
INSERT INTO link VALUES ('Network1', 18, 10, 9);
INSERT INTO link VALUES ('Network2', 19, 9, 10);
INSERT INTO link VALUES ('Network2', 20, 11, 10);
INSERT INTO link VALUES ('Network3', 21, 10, 11);
INSERT INTO link VALUES ('network3', 22, 6, 11);
INSERT INTO link VALUES ('Pc3', 23, 11, 6);
INSERT INTO link VALUES ('Network3', 24, 9, 11);
INSERT INTO link VALUES ('Network1', 25, 11, 9);


--
-- TOC entry 2277 (class 0 OID 0)
-- Dependencies: 191
-- Name: logical_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('logical_role_id_seq', 2, true);


--
-- TOC entry 2264 (class 0 OID 46997)
-- Dependencies: 194
-- Data for Name: network; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO network VALUES ('150.150.2.1', NULL, NULL, NULL, 'Lan1', 9);
INSERT INTO network VALUES ('150.150.1.1', NULL, NULL, NULL, 'Lan2', 10);
INSERT INTO network VALUES ('150.150.3.1', NULL, NULL, NULL, 'Lan3', 11);


--
-- TOC entry 2266 (class 0 OID 47010)
-- Dependencies: 196
-- Data for Name: node_interface; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO node_interface VALUES ('150.150.2.2', NULL, 2, 1);
INSERT INTO node_interface VALUES ('150.150.2.3', NULL, 4, 3);
INSERT INTO node_interface VALUES ('150.150.3.2', NULL, 6, 5);
INSERT INTO node_interface VALUES ('150.150.1.2', NULL, 8, 7);


--
-- TOC entry 2278 (class 0 OID 0)
-- Dependencies: 197
-- Name: physical_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('physical_role_id_seq', 2, true);


--
-- TOC entry 2270 (class 0 OID 47028)
-- Dependencies: 200
-- Data for Name: property; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO property VALUES (1, 'RAM', 'GB', '8', 1);
INSERT INTO property VALUES (2, 'HDD', 'GB', '500', 1);
INSERT INTO property VALUES (3, 'HDD', 'GB', '500', 3);
INSERT INTO property VALUES (4, 'RAM', 'GB', '8', 3);
INSERT INTO property VALUES (5, 'RAM', 'GB', '8', 5);
INSERT INTO property VALUES (6, 'Ports', 'ks', '20', 7);
INSERT INTO property VALUES (7, 'Bandwidth', 'MB/s', '100', 12);
INSERT INTO property VALUES (8, 'Bandwidth', 'MB/s', '100', 13);
INSERT INTO property VALUES (9, 'Bandwidth', 'MB/s', '100', 14);
INSERT INTO property VALUES (10, 'Bandwidth', 'MB/s', '100', 15);
INSERT INTO property VALUES (11, 'Bandwidth', 'MB/s', '100', 16);
INSERT INTO property VALUES (12, 'Bandwidth', 'MB/s', '100', 17);
INSERT INTO property VALUES (13, 'Bandwidth', 'MB/s', '100', 18);
INSERT INTO property VALUES (14, 'Bandwidth', 'MB/s', '100', 19);
INSERT INTO property VALUES (15, 'Bandwidth', 'MB/s', '100', 20);
INSERT INTO property VALUES (17, NULL, NULL, NULL, 22);
INSERT INTO property VALUES (18, 'Bandwidth', 'MB/s', '100', 23);
INSERT INTO property VALUES (19, 'Bandwidth', 'MB/s', '100', 25);
INSERT INTO property VALUES (16, 'Bandwidth', 'MB/s', '100', 24);


--
-- TOC entry 2279 (class 0 OID 0)
-- Dependencies: 199
-- Name: property_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('property_id_seq', 19, true);


-- Completed on 2017-10-23 10:11:36 CEST

--
-- PostgreSQL database dump complete
--


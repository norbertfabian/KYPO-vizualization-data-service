--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-10-23 10:20:02 CEST

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
-- TOC entry 2447 (class 0 OID 47567)
-- Dependencies: 214
-- Data for Name: scenario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO scenario VALUES (5, 'Scenario', NULL);
INSERT INTO scenario VALUES (6, 'Scenario', NULL);


--
-- TOC entry 2449 (class 0 OID 47578)
-- Dependencies: 216
-- Data for Name: scenario_instance; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2419 (class 0 OID 47420)
-- Dependencies: 186
-- Data for Name: chat_room; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2467 (class 0 OID 0)
-- Dependencies: 185
-- Name: chat_room_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('chat_room_id_seq', 1, false);


--
-- TOC entry 2423 (class 0 OID 47444)
-- Dependencies: 190
-- Data for Name: disk_target; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO disk_target VALUES (1, 'sh');
INSERT INTO disk_target VALUES (2, 'hd');
INSERT INTO disk_target VALUES (3, 'vd');


--
-- TOC entry 2433 (class 0 OID 47497)
-- Dependencies: 200
-- Data for Name: image_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO image_type VALUES (1, 'SMN');
INSERT INTO image_type VALUES (2, 'LMN');
INSERT INTO image_type VALUES (3, 'HOST');


--
-- TOC entry 2442 (class 0 OID 47543)
-- Dependencies: 209
-- Data for Name: os; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2458 (class 0 OID 47623)
-- Dependencies: 225
-- Data for Name: ssh_key; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2462 (class 0 OID 47644)
-- Dependencies: 229
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users VALUES (9, 'LiferayScreenName', 'User', NULL, NULL, NULL);


--
-- TOC entry 2421 (class 0 OID 47433)
-- Dependencies: 188
-- Data for Name: disk_image; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2468 (class 0 OID 0)
-- Dependencies: 187
-- Name: disk_image_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('disk_image_id_seq', 1, false);


--
-- TOC entry 2469 (class 0 OID 0)
-- Dependencies: 189
-- Name: disk_target_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('disk_target_id_seq', 3, true);


--
-- TOC entry 2425 (class 0 OID 47452)
-- Dependencies: 192
-- Data for Name: game; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2470 (class 0 OID 0)
-- Dependencies: 191
-- Name: game_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('game_id_seq', 1, false);


--
-- TOC entry 2456 (class 0 OID 47612)
-- Dependencies: 223
-- Data for Name: script; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2439 (class 0 OID 47527)
-- Dependencies: 206
-- Data for Name: level; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2427 (class 0 OID 47465)
-- Dependencies: 194
-- Data for Name: hint; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2471 (class 0 OID 0)
-- Dependencies: 193
-- Name: hint_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hint_id_seq', 1, false);


--
-- TOC entry 2429 (class 0 OID 47476)
-- Dependencies: 196
-- Data for Name: host_role; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2472 (class 0 OID 0)
-- Dependencies: 195
-- Name: host_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('host_role_id_seq', 1, false);


--
-- TOC entry 2431 (class 0 OID 47484)
-- Dependencies: 198
-- Data for Name: idm_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2473 (class 0 OID 0)
-- Dependencies: 197
-- Name: idm_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('idm_group_id_seq', 1, false);


--
-- TOC entry 2474 (class 0 OID 0)
-- Dependencies: 199
-- Name: image_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('image_type_id_seq', 3, true);


--
-- TOC entry 2435 (class 0 OID 47505)
-- Dependencies: 202
-- Data for Name: kypo_point; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2475 (class 0 OID 0)
-- Dependencies: 201
-- Name: kypo_point_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('kypo_point_id_seq', 1, false);


--
-- TOC entry 2445 (class 0 OID 47556)
-- Dependencies: 212
-- Data for Name: sandbox; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sandbox VALUES (10, NULL, 'Sandbox1Name', 'kypodb');
INSERT INTO sandbox VALUES (11, NULL, 'Sandbox3Name', 'kypodb2');
INSERT INTO sandbox VALUES (12, NULL, 'Sandbox3Name', 'kypodb3');


--
-- TOC entry 2437 (class 0 OID 47516)
-- Dependencies: 204
-- Data for Name: kypo_point_tunnel; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2476 (class 0 OID 0)
-- Dependencies: 203
-- Name: kypo_point_tunnel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('kypo_point_tunnel_id_seq', 1, false);


--
-- TOC entry 2477 (class 0 OID 0)
-- Dependencies: 205
-- Name: level_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('level_id_seq', 1, false);


--
-- TOC entry 2440 (class 0 OID 47536)
-- Dependencies: 207
-- Data for Name: organizer; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2478 (class 0 OID 0)
-- Dependencies: 208
-- Name: os_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('os_id_seq', 1, false);


--
-- TOC entry 2443 (class 0 OID 47549)
-- Dependencies: 210
-- Data for Name: participant; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2479 (class 0 OID 0)
-- Dependencies: 211
-- Name: sandbox_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sandbox_id_seq', 15, true);


--
-- TOC entry 2480 (class 0 OID 0)
-- Dependencies: 213
-- Name: scenario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('scenario_id_seq', 6, true);


--
-- TOC entry 2481 (class 0 OID 0)
-- Dependencies: 215
-- Name: scenario_instance_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('scenario_instance_id_seq', 1, false);


--
-- TOC entry 2453 (class 0 OID 47596)
-- Dependencies: 220
-- Data for Name: scenario_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO scenario_role VALUES (5, 'scenarioRole', 5, NULL);
INSERT INTO scenario_role VALUES (6, 'scenarioRole', 6, NULL);


--
-- TOC entry 2451 (class 0 OID 47586)
-- Dependencies: 218
-- Data for Name: scenario_instance_participant; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO scenario_instance_participant VALUES (12, 9, 6, 10, 'sandbox1');
INSERT INTO scenario_instance_participant VALUES (13, 9, 6, 11, 'sandbox2');
INSERT INTO scenario_instance_participant VALUES (14, 9, 6, 12, 'sandbox3');


--
-- TOC entry 2482 (class 0 OID 0)
-- Dependencies: 217
-- Name: scenario_instance_participant_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('scenario_instance_participant_id_seq', 14, true);


--
-- TOC entry 2454 (class 0 OID 47605)
-- Dependencies: 221
-- Data for Name: scenario_role_host_access; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2483 (class 0 OID 0)
-- Dependencies: 219
-- Name: scenario_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('scenario_role_id_seq', 6, true);


--
-- TOC entry 2484 (class 0 OID 0)
-- Dependencies: 222
-- Name: script_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('script_id_seq', 1, false);


--
-- TOC entry 2485 (class 0 OID 0)
-- Dependencies: 224
-- Name: ssh_key_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ssh_key_id_seq', 1, false);


--
-- TOC entry 2459 (class 0 OID 47632)
-- Dependencies: 226
-- Data for Name: supervisor; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2460 (class 0 OID 47637)
-- Dependencies: 227
-- Data for Name: user_idm_group; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2486 (class 0 OID 0)
-- Dependencies: 228
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 10, true);


-- Completed on 2017-10-23 10:20:03 CEST

--
-- PostgreSQL database dump complete
--


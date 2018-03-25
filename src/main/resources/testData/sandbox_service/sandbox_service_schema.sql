--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-10-23 10:11:02 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12427)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2261 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 46960)
-- Name: assigned_logical_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE assigned_logical_role (
    id bigint NOT NULL,
    "from" bigint,
    "to" bigint,
    role_id bigint,
    measurable_id bigint
);


ALTER TABLE assigned_logical_role OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 46958)
-- Name: assigned_logical_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE assigned_logical_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE assigned_logical_role_id_seq OWNER TO postgres;

--
-- TOC entry 2262 (class 0 OID 0)
-- Dependencies: 185
-- Name: assigned_logical_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE assigned_logical_role_id_seq OWNED BY assigned_logical_role.id;


--
-- TOC entry 187 (class 1259 OID 46966)
-- Name: connectable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE connectable (
    firewall character varying(255),
    id bigint NOT NULL
);


ALTER TABLE connectable OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 46973)
-- Name: hardware; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE hardware (
    id bigint NOT NULL
);


ALTER TABLE hardware OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 46971)
-- Name: hardware_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hardware_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hardware_id_seq OWNER TO postgres;

--
-- TOC entry 2263 (class 0 OID 0)
-- Dependencies: 188
-- Name: hardware_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hardware_id_seq OWNED BY hardware.id;


--
-- TOC entry 190 (class 1259 OID 46979)
-- Name: link; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE link (
    src_interface character varying(255),
    id bigint NOT NULL,
    dst_connectable_id bigint,
    src_connectable_id bigint
);


ALTER TABLE link OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 46986)
-- Name: logical_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE logical_role (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE logical_role OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 46984)
-- Name: logical_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE logical_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE logical_role_id_seq OWNER TO postgres;

--
-- TOC entry 2264 (class 0 OID 0)
-- Dependencies: 191
-- Name: logical_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE logical_role_id_seq OWNED BY logical_role.id;


--
-- TOC entry 193 (class 1259 OID 46992)
-- Name: measurable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE measurable (
    id bigint NOT NULL
);


ALTER TABLE measurable OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 46997)
-- Name: network; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE network (
    cidr4 character varying(255),
    cidr6 character varying(255),
    mng_interface character varying(255),
    mng_ip_address character varying(255),
    name character varying(255),
    id bigint NOT NULL
);


ALTER TABLE network OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 47005)
-- Name: node; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE node (
    name character varying(255),
    id bigint NOT NULL,
    physical_role_id bigint
);


ALTER TABLE node OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 47010)
-- Name: node_interface; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE node_interface (
    ip4_addr character varying(255),
    ip6_addr character varying(255),
    id bigint NOT NULL,
    measurable_id bigint
);


ALTER TABLE node_interface OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 47020)
-- Name: physical_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE physical_role (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE physical_role OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 47018)
-- Name: physical_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE physical_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE physical_role_id_seq OWNER TO postgres;

--
-- TOC entry 2265 (class 0 OID 0)
-- Dependencies: 197
-- Name: physical_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE physical_role_id_seq OWNED BY physical_role.id;


--
-- TOC entry 200 (class 1259 OID 47028)
-- Name: property; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE property (
    id bigint NOT NULL,
    name character varying(255),
    unit character varying(255),
    value character varying(255),
    measurable_id bigint
);


ALTER TABLE property OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 47026)
-- Name: property_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE property_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE property_id_seq OWNER TO postgres;

--
-- TOC entry 2266 (class 0 OID 0)
-- Dependencies: 199
-- Name: property_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE property_id_seq OWNED BY property.id;


--
-- TOC entry 2090 (class 2604 OID 46963)
-- Name: assigned_logical_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY assigned_logical_role ALTER COLUMN id SET DEFAULT nextval('assigned_logical_role_id_seq'::regclass);


--
-- TOC entry 2091 (class 2604 OID 46976)
-- Name: hardware id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hardware ALTER COLUMN id SET DEFAULT nextval('hardware_id_seq'::regclass);


--
-- TOC entry 2092 (class 2604 OID 46989)
-- Name: logical_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logical_role ALTER COLUMN id SET DEFAULT nextval('logical_role_id_seq'::regclass);


--
-- TOC entry 2093 (class 2604 OID 47023)
-- Name: physical_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY physical_role ALTER COLUMN id SET DEFAULT nextval('physical_role_id_seq'::regclass);


--
-- TOC entry 2094 (class 2604 OID 47031)
-- Name: property id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY property ALTER COLUMN id SET DEFAULT nextval('property_id_seq'::regclass);


--
-- TOC entry 2096 (class 2606 OID 46965)
-- Name: assigned_logical_role assigned_logical_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY assigned_logical_role
    ADD CONSTRAINT assigned_logical_role_pkey PRIMARY KEY (id);


--
-- TOC entry 2098 (class 2606 OID 46970)
-- Name: connectable connectable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY connectable
    ADD CONSTRAINT connectable_pkey PRIMARY KEY (id);


--
-- TOC entry 2100 (class 2606 OID 46978)
-- Name: hardware hardware_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hardware
    ADD CONSTRAINT hardware_pkey PRIMARY KEY (id);


--
-- TOC entry 2102 (class 2606 OID 46983)
-- Name: link link_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY link
    ADD CONSTRAINT link_pkey PRIMARY KEY (id);


--
-- TOC entry 2104 (class 2606 OID 46991)
-- Name: logical_role logical_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logical_role
    ADD CONSTRAINT logical_role_pkey PRIMARY KEY (id);


--
-- TOC entry 2108 (class 2606 OID 46996)
-- Name: measurable measurable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY measurable
    ADD CONSTRAINT measurable_pkey PRIMARY KEY (id);


--
-- TOC entry 2110 (class 2606 OID 47004)
-- Name: network network_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY network
    ADD CONSTRAINT network_pkey PRIMARY KEY (id);


--
-- TOC entry 2118 (class 2606 OID 47017)
-- Name: node_interface node_interface_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY node_interface
    ADD CONSTRAINT node_interface_pkey PRIMARY KEY (id);


--
-- TOC entry 2114 (class 2606 OID 47009)
-- Name: node node_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY node
    ADD CONSTRAINT node_pkey PRIMARY KEY (id);


--
-- TOC entry 2120 (class 2606 OID 47025)
-- Name: physical_role physical_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY physical_role
    ADD CONSTRAINT physical_role_pkey PRIMARY KEY (id);


--
-- TOC entry 2124 (class 2606 OID 47036)
-- Name: property property_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY property
    ADD CONSTRAINT property_pkey PRIMARY KEY (id);


--
-- TOC entry 2112 (class 2606 OID 47040)
-- Name: network uk_d2llq2dbusiy1pvirtgxb86ta; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY network
    ADD CONSTRAINT uk_d2llq2dbusiy1pvirtgxb86ta UNIQUE (name);


--
-- TOC entry 2116 (class 2606 OID 47042)
-- Name: node uk_fwigxdmj6bsrpcmhcgpmlsirh; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY node
    ADD CONSTRAINT uk_fwigxdmj6bsrpcmhcgpmlsirh UNIQUE (name);


--
-- TOC entry 2106 (class 2606 OID 47038)
-- Name: logical_role uk_no6m3kvgdc547tggawvc9shv2; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logical_role
    ADD CONSTRAINT uk_no6m3kvgdc547tggawvc9shv2 UNIQUE (name);


--
-- TOC entry 2122 (class 2606 OID 47044)
-- Name: physical_role uk_t0ro76rianl5ht4a231urme7f; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY physical_role
    ADD CONSTRAINT uk_t0ro76rianl5ht4a231urme7f UNIQUE (name);


--
-- TOC entry 2129 (class 2606 OID 47065)
-- Name: link fk_1ofky1xughjx2qcfxmwbjgvap; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY link
    ADD CONSTRAINT fk_1ofky1xughjx2qcfxmwbjgvap FOREIGN KEY (src_connectable_id) REFERENCES connectable(id);


--
-- TOC entry 2132 (class 2606 OID 47080)
-- Name: network fk_6ucx9trqr9n2tjqbum7m73xov; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY network
    ADD CONSTRAINT fk_6ucx9trqr9n2tjqbum7m73xov FOREIGN KEY (id) REFERENCES connectable(id);


--
-- TOC entry 2137 (class 2606 OID 47105)
-- Name: property fk_cl5ld2dcnwme2dqan7w7becve; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY property
    ADD CONSTRAINT fk_cl5ld2dcnwme2dqan7w7becve FOREIGN KEY (measurable_id) REFERENCES measurable(id);


--
-- TOC entry 2135 (class 2606 OID 47095)
-- Name: node_interface fk_crdmb3lycyafa4mglhgg6l5mg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY node_interface
    ADD CONSTRAINT fk_crdmb3lycyafa4mglhgg6l5mg FOREIGN KEY (measurable_id) REFERENCES node(id);


--
-- TOC entry 2125 (class 2606 OID 47045)
-- Name: assigned_logical_role fk_e90hjq1ijlhggu1ecxuu4m9yy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY assigned_logical_role
    ADD CONSTRAINT fk_e90hjq1ijlhggu1ecxuu4m9yy FOREIGN KEY (role_id) REFERENCES logical_role(id);


--
-- TOC entry 2134 (class 2606 OID 47090)
-- Name: node fk_fc977bu2p0ijnsdxnd8afs14r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY node
    ADD CONSTRAINT fk_fc977bu2p0ijnsdxnd8afs14r FOREIGN KEY (id) REFERENCES measurable(id);


--
-- TOC entry 2130 (class 2606 OID 47070)
-- Name: link fk_gtc065twr5e3o87gxshsvlopy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY link
    ADD CONSTRAINT fk_gtc065twr5e3o87gxshsvlopy FOREIGN KEY (id) REFERENCES measurable(id);


--
-- TOC entry 2133 (class 2606 OID 47085)
-- Name: node fk_hbpj5aq3k6gpq2r9jxw0ge4ba; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY node
    ADD CONSTRAINT fk_hbpj5aq3k6gpq2r9jxw0ge4ba FOREIGN KEY (physical_role_id) REFERENCES physical_role(id);


--
-- TOC entry 2128 (class 2606 OID 47060)
-- Name: link fk_iqhbtslvb3sb0ai1kdja6vsn5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY link
    ADD CONSTRAINT fk_iqhbtslvb3sb0ai1kdja6vsn5 FOREIGN KEY (dst_connectable_id) REFERENCES connectable(id);


--
-- TOC entry 2131 (class 2606 OID 47075)
-- Name: measurable fk_ly6ds6900rvm7ig1aijvf9rnm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY measurable
    ADD CONSTRAINT fk_ly6ds6900rvm7ig1aijvf9rnm FOREIGN KEY (id) REFERENCES hardware(id);


--
-- TOC entry 2127 (class 2606 OID 47055)
-- Name: connectable fk_qje7kjuh6940q1qf5ol86i8lj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY connectable
    ADD CONSTRAINT fk_qje7kjuh6940q1qf5ol86i8lj FOREIGN KEY (id) REFERENCES hardware(id);


--
-- TOC entry 2136 (class 2606 OID 47100)
-- Name: node_interface fk_qtih4rm2m8n2jsywpi1kjovfa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY node_interface
    ADD CONSTRAINT fk_qtih4rm2m8n2jsywpi1kjovfa FOREIGN KEY (id) REFERENCES connectable(id);


--
-- TOC entry 2126 (class 2606 OID 47050)
-- Name: assigned_logical_role fk_s1dve7p3570gljufrktjqnhiy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY assigned_logical_role
    ADD CONSTRAINT fk_s1dve7p3570gljufrktjqnhiy FOREIGN KEY (measurable_id) REFERENCES node(id);


-- Completed on 2017-10-23 10:11:02 CEST

--
-- PostgreSQL database dump complete
--


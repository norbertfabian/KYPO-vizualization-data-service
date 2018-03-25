--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-10-23 10:19:25 CEST

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
-- TOC entry 2424 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 47420)
-- Name: chat_room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE chat_room (
    id bigint NOT NULL,
    scenario_instance_id bigint NOT NULL,
    type character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE chat_room OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 47418)
-- Name: chat_room_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE chat_room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE chat_room_id_seq OWNER TO postgres;

--
-- TOC entry 2425 (class 0 OID 0)
-- Dependencies: 185
-- Name: chat_room_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE chat_room_id_seq OWNED BY chat_room.id;


--
-- TOC entry 188 (class 1259 OID 47433)
-- Name: disk_image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE disk_image (
    id bigint NOT NULL,
    ssh_key_id bigint,
    os_id bigint NOT NULL,
    disk_target_id bigint NOT NULL,
    user_id bigint,
    image_type_id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    date_uploaded timestamp without time zone NOT NULL,
    opennebula_id bigint
);


ALTER TABLE disk_image OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 47431)
-- Name: disk_image_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE disk_image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE disk_image_id_seq OWNER TO postgres;

--
-- TOC entry 2426 (class 0 OID 0)
-- Dependencies: 187
-- Name: disk_image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE disk_image_id_seq OWNED BY disk_image.id;


--
-- TOC entry 190 (class 1259 OID 47444)
-- Name: disk_target; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE disk_target (
    id bigint NOT NULL,
    value character varying(255)
);


ALTER TABLE disk_target OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 47442)
-- Name: disk_target_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE disk_target_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE disk_target_id_seq OWNER TO postgres;

--
-- TOC entry 2427 (class 0 OID 0)
-- Dependencies: 189
-- Name: disk_target_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE disk_target_id_seq OWNED BY disk_target.id;


--
-- TOC entry 192 (class 1259 OID 47452)
-- Name: game; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE game (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    introduction character varying(4096) NOT NULL,
    rules character varying(4096) NOT NULL,
    scenario_id bigint
);


ALTER TABLE game OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 47450)
-- Name: game_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE game_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_id_seq OWNER TO postgres;

--
-- TOC entry 2428 (class 0 OID 0)
-- Dependencies: 191
-- Name: game_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE game_id_seq OWNED BY game.id;


--
-- TOC entry 194 (class 1259 OID 47465)
-- Name: hint; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE hint (
    id integer NOT NULL,
    level_id integer NOT NULL,
    hint_index integer NOT NULL,
    text character varying(4096) NOT NULL,
    penalty integer NOT NULL
);


ALTER TABLE hint OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 47463)
-- Name: hint_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hint_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hint_id_seq OWNER TO postgres;

--
-- TOC entry 2429 (class 0 OID 0)
-- Dependencies: 193
-- Name: hint_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hint_id_seq OWNED BY hint.id;


--
-- TOC entry 196 (class 1259 OID 47476)
-- Name: host_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE host_role (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    scenario_id bigint NOT NULL
);


ALTER TABLE host_role OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 47474)
-- Name: host_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE host_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE host_role_id_seq OWNER TO postgres;

--
-- TOC entry 2430 (class 0 OID 0)
-- Dependencies: 195
-- Name: host_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE host_role_id_seq OWNED BY host_role.id;


--
-- TOC entry 198 (class 1259 OID 47484)
-- Name: idm_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE idm_group (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    status character varying(255),
    external_id bigint
);


ALTER TABLE idm_group OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 47482)
-- Name: idm_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE idm_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE idm_group_id_seq OWNER TO postgres;

--
-- TOC entry 2431 (class 0 OID 0)
-- Dependencies: 197
-- Name: idm_group_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE idm_group_id_seq OWNED BY idm_group.id;


--
-- TOC entry 200 (class 1259 OID 47497)
-- Name: image_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE image_type (
    id bigint NOT NULL,
    value character varying(255)
);


ALTER TABLE image_type OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 47495)
-- Name: image_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE image_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE image_type_id_seq OWNER TO postgres;

--
-- TOC entry 2432 (class 0 OID 0)
-- Dependencies: 199
-- Name: image_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE image_type_id_seq OWNED BY image_type.id;


--
-- TOC entry 202 (class 1259 OID 47505)
-- Name: kypo_point; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE kypo_point (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    name character varying(255),
    subject_dn character varying(255) NOT NULL,
    issuer_dn character varying(255) NOT NULL
);


ALTER TABLE kypo_point OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 47503)
-- Name: kypo_point_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE kypo_point_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE kypo_point_id_seq OWNER TO postgres;

--
-- TOC entry 2433 (class 0 OID 0)
-- Dependencies: 201
-- Name: kypo_point_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE kypo_point_id_seq OWNED BY kypo_point.id;


--
-- TOC entry 204 (class 1259 OID 47516)
-- Name: kypo_point_tunnel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE kypo_point_tunnel (
    id bigint NOT NULL,
    sandbox_id bigint,
    kypo_point_id bigint NOT NULL,
    lmn_ip inet,
    sandbox_port integer,
    state integer NOT NULL
);


ALTER TABLE kypo_point_tunnel OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 47514)
-- Name: kypo_point_tunnel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE kypo_point_tunnel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE kypo_point_tunnel_id_seq OWNER TO postgres;

--
-- TOC entry 2434 (class 0 OID 0)
-- Dependencies: 203
-- Name: kypo_point_tunnel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE kypo_point_tunnel_id_seq OWNED BY kypo_point_tunnel.id;


--
-- TOC entry 206 (class 1259 OID 47527)
-- Name: level; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE level (
    id integer NOT NULL,
    level_index integer,
    game_id integer NOT NULL,
    title character varying(255) NOT NULL,
    text character varying(4096),
    helptext character varying(4096),
    points integer,
    flag character varying(255),
    "time" integer,
    password character varying(255),
    entry_script_id integer,
    skip_script_id integer,
    exit_script_id integer
);


ALTER TABLE level OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 47525)
-- Name: level_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE level_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE level_id_seq OWNER TO postgres;

--
-- TOC entry 2435 (class 0 OID 0)
-- Dependencies: 205
-- Name: level_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE level_id_seq OWNED BY level.id;


--
-- TOC entry 207 (class 1259 OID 47536)
-- Name: organizer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE organizer (
    scenario_id bigint NOT NULL,
    group_id bigint NOT NULL
);


ALTER TABLE organizer OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 47543)
-- Name: os; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE os (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE os OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 47541)
-- Name: os_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE os_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE os_id_seq OWNER TO postgres;

--
-- TOC entry 2436 (class 0 OID 0)
-- Dependencies: 208
-- Name: os_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE os_id_seq OWNED BY os.id;


--
-- TOC entry 210 (class 1259 OID 47549)
-- Name: participant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE participant (
    scenario_instance_id bigint NOT NULL,
    group_id bigint NOT NULL
);


ALTER TABLE participant OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 47556)
-- Name: sandbox; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sandbox (
    id bigint NOT NULL,
    scenario_instance_id bigint,
    name character varying(255),
    url character varying(255)
);


ALTER TABLE sandbox OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 47554)
-- Name: sandbox_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sandbox_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sandbox_id_seq OWNER TO postgres;

--
-- TOC entry 2437 (class 0 OID 0)
-- Dependencies: 211
-- Name: sandbox_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sandbox_id_seq OWNED BY sandbox.id;


--
-- TOC entry 214 (class 1259 OID 47567)
-- Name: scenario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE scenario (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    json text
);


ALTER TABLE scenario OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 47565)
-- Name: scenario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE scenario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE scenario_id_seq OWNER TO postgres;

--
-- TOC entry 2438 (class 0 OID 0)
-- Dependencies: 213
-- Name: scenario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE scenario_id_seq OWNED BY scenario.id;


--
-- TOC entry 216 (class 1259 OID 47578)
-- Name: scenario_instance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE scenario_instance (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    "time" timestamp without time zone,
    scenario_id bigint NOT NULL
);


ALTER TABLE scenario_instance OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 47576)
-- Name: scenario_instance_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE scenario_instance_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE scenario_instance_id_seq OWNER TO postgres;

--
-- TOC entry 2439 (class 0 OID 0)
-- Dependencies: 215
-- Name: scenario_instance_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE scenario_instance_id_seq OWNED BY scenario_instance.id;


--
-- TOC entry 218 (class 1259 OID 47586)
-- Name: scenario_instance_participant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE scenario_instance_participant (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    scenario_role_id bigint NOT NULL,
    sandbox_id bigint NOT NULL,
    site_id character varying(255) NOT NULL
);


ALTER TABLE scenario_instance_participant OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 47584)
-- Name: scenario_instance_participant_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE scenario_instance_participant_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE scenario_instance_participant_id_seq OWNER TO postgres;

--
-- TOC entry 2440 (class 0 OID 0)
-- Dependencies: 217
-- Name: scenario_instance_participant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE scenario_instance_participant_id_seq OWNED BY scenario_instance_participant.id;


--
-- TOC entry 220 (class 1259 OID 47596)
-- Name: scenario_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE scenario_role (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    scenario_id bigint NOT NULL,
    site_template_id character varying(255)
);


ALTER TABLE scenario_role OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 47605)
-- Name: scenario_role_host_access; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE scenario_role_host_access (
    host_role_id bigint NOT NULL,
    scenario_role_id bigint NOT NULL
);


ALTER TABLE scenario_role_host_access OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 47594)
-- Name: scenario_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE scenario_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE scenario_role_id_seq OWNER TO postgres;

--
-- TOC entry 2441 (class 0 OID 0)
-- Dependencies: 219
-- Name: scenario_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE scenario_role_id_seq OWNED BY scenario_role.id;


--
-- TOC entry 223 (class 1259 OID 47612)
-- Name: script; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE script (
    id integer NOT NULL,
    type character varying(255) NOT NULL,
    port integer NOT NULL,
    script character varying(256) NOT NULL
);


ALTER TABLE script OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 47610)
-- Name: script_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE script_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE script_id_seq OWNER TO postgres;

--
-- TOC entry 2442 (class 0 OID 0)
-- Dependencies: 222
-- Name: script_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE script_id_seq OWNED BY script.id;


--
-- TOC entry 225 (class 1259 OID 47623)
-- Name: ssh_key; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ssh_key (
    id bigint NOT NULL,
    private character varying(255) NOT NULL,
    public character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE ssh_key OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 47621)
-- Name: ssh_key_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ssh_key_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ssh_key_id_seq OWNER TO postgres;

--
-- TOC entry 2443 (class 0 OID 0)
-- Dependencies: 224
-- Name: ssh_key_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ssh_key_id_seq OWNED BY ssh_key.id;


--
-- TOC entry 226 (class 1259 OID 47632)
-- Name: supervisor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE supervisor (
    scenario_instance_id bigint NOT NULL,
    group_id bigint NOT NULL
);


ALTER TABLE supervisor OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 47637)
-- Name: user_idm_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_idm_group (
    user_id bigint NOT NULL,
    idm_group_id bigint NOT NULL
);


ALTER TABLE user_idm_group OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 47644)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id bigint NOT NULL,
    liferay_sn character varying(255) NOT NULL,
    display_name character varying(255),
    mail character varying(255),
    status character varying(255),
    external_id bigint
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 47642)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- TOC entry 2444 (class 0 OID 0)
-- Dependencies: 228
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 2187 (class 2604 OID 47423)
-- Name: chat_room id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY chat_room ALTER COLUMN id SET DEFAULT nextval('chat_room_id_seq'::regclass);


--
-- TOC entry 2188 (class 2604 OID 47436)
-- Name: disk_image id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_image ALTER COLUMN id SET DEFAULT nextval('disk_image_id_seq'::regclass);


--
-- TOC entry 2189 (class 2604 OID 47447)
-- Name: disk_target id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_target ALTER COLUMN id SET DEFAULT nextval('disk_target_id_seq'::regclass);


--
-- TOC entry 2190 (class 2604 OID 47455)
-- Name: game id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY game ALTER COLUMN id SET DEFAULT nextval('game_id_seq'::regclass);


--
-- TOC entry 2191 (class 2604 OID 47468)
-- Name: hint id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hint ALTER COLUMN id SET DEFAULT nextval('hint_id_seq'::regclass);


--
-- TOC entry 2192 (class 2604 OID 47479)
-- Name: host_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY host_role ALTER COLUMN id SET DEFAULT nextval('host_role_id_seq'::regclass);


--
-- TOC entry 2193 (class 2604 OID 47487)
-- Name: idm_group id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY idm_group ALTER COLUMN id SET DEFAULT nextval('idm_group_id_seq'::regclass);


--
-- TOC entry 2194 (class 2604 OID 47500)
-- Name: image_type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image_type ALTER COLUMN id SET DEFAULT nextval('image_type_id_seq'::regclass);


--
-- TOC entry 2195 (class 2604 OID 47508)
-- Name: kypo_point id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kypo_point ALTER COLUMN id SET DEFAULT nextval('kypo_point_id_seq'::regclass);


--
-- TOC entry 2196 (class 2604 OID 47519)
-- Name: kypo_point_tunnel id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kypo_point_tunnel ALTER COLUMN id SET DEFAULT nextval('kypo_point_tunnel_id_seq'::regclass);


--
-- TOC entry 2197 (class 2604 OID 47530)
-- Name: level id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level ALTER COLUMN id SET DEFAULT nextval('level_id_seq'::regclass);


--
-- TOC entry 2198 (class 2604 OID 47546)
-- Name: os id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY os ALTER COLUMN id SET DEFAULT nextval('os_id_seq'::regclass);


--
-- TOC entry 2199 (class 2604 OID 47559)
-- Name: sandbox id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sandbox ALTER COLUMN id SET DEFAULT nextval('sandbox_id_seq'::regclass);


--
-- TOC entry 2200 (class 2604 OID 47570)
-- Name: scenario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario ALTER COLUMN id SET DEFAULT nextval('scenario_id_seq'::regclass);


--
-- TOC entry 2201 (class 2604 OID 47581)
-- Name: scenario_instance id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance ALTER COLUMN id SET DEFAULT nextval('scenario_instance_id_seq'::regclass);


--
-- TOC entry 2202 (class 2604 OID 47589)
-- Name: scenario_instance_participant id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance_participant ALTER COLUMN id SET DEFAULT nextval('scenario_instance_participant_id_seq'::regclass);


--
-- TOC entry 2203 (class 2604 OID 47599)
-- Name: scenario_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_role ALTER COLUMN id SET DEFAULT nextval('scenario_role_id_seq'::regclass);


--
-- TOC entry 2204 (class 2604 OID 47615)
-- Name: script id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY script ALTER COLUMN id SET DEFAULT nextval('script_id_seq'::regclass);


--
-- TOC entry 2205 (class 2604 OID 47626)
-- Name: ssh_key id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ssh_key ALTER COLUMN id SET DEFAULT nextval('ssh_key_id_seq'::regclass);


--
-- TOC entry 2206 (class 2604 OID 47647)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2208 (class 2606 OID 47430)
-- Name: chat_room chat_room_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY chat_room
    ADD CONSTRAINT chat_room_name_key UNIQUE (name);


--
-- TOC entry 2210 (class 2606 OID 47428)
-- Name: chat_room chat_room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY chat_room
    ADD CONSTRAINT chat_room_pkey PRIMARY KEY (id);


--
-- TOC entry 2212 (class 2606 OID 47441)
-- Name: disk_image disk_image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_image
    ADD CONSTRAINT disk_image_pkey PRIMARY KEY (id);


--
-- TOC entry 2214 (class 2606 OID 47449)
-- Name: disk_target disk_target_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_target
    ADD CONSTRAINT disk_target_pkey PRIMARY KEY (id);


--
-- TOC entry 2216 (class 2606 OID 47462)
-- Name: game game_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY game
    ADD CONSTRAINT game_name_key UNIQUE (name);


--
-- TOC entry 2218 (class 2606 OID 47460)
-- Name: game game_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY game
    ADD CONSTRAINT game_pkey PRIMARY KEY (id);


--
-- TOC entry 2220 (class 2606 OID 47473)
-- Name: hint hint_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hint
    ADD CONSTRAINT hint_pkey PRIMARY KEY (id);


--
-- TOC entry 2222 (class 2606 OID 47481)
-- Name: host_role host_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY host_role
    ADD CONSTRAINT host_role_pkey PRIMARY KEY (id);


--
-- TOC entry 2224 (class 2606 OID 47494)
-- Name: idm_group idm_group_external_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY idm_group
    ADD CONSTRAINT idm_group_external_id_key UNIQUE (external_id);


--
-- TOC entry 2226 (class 2606 OID 47492)
-- Name: idm_group idm_group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY idm_group
    ADD CONSTRAINT idm_group_pkey PRIMARY KEY (id);


--
-- TOC entry 2228 (class 2606 OID 47502)
-- Name: image_type image_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY image_type
    ADD CONSTRAINT image_type_pkey PRIMARY KEY (id);


--
-- TOC entry 2230 (class 2606 OID 47513)
-- Name: kypo_point kypo_point_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kypo_point
    ADD CONSTRAINT kypo_point_pkey PRIMARY KEY (id);


--
-- TOC entry 2232 (class 2606 OID 47524)
-- Name: kypo_point_tunnel kypo_point_tunnel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kypo_point_tunnel
    ADD CONSTRAINT kypo_point_tunnel_pkey PRIMARY KEY (id);


--
-- TOC entry 2234 (class 2606 OID 47535)
-- Name: level level_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level
    ADD CONSTRAINT level_pkey PRIMARY KEY (id);


--
-- TOC entry 2236 (class 2606 OID 47540)
-- Name: organizer organizer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY organizer
    ADD CONSTRAINT organizer_pkey PRIMARY KEY (scenario_id, group_id);


--
-- TOC entry 2238 (class 2606 OID 47548)
-- Name: os os_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY os
    ADD CONSTRAINT os_pkey PRIMARY KEY (id);


--
-- TOC entry 2240 (class 2606 OID 47553)
-- Name: participant participant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY participant
    ADD CONSTRAINT participant_pkey PRIMARY KEY (scenario_instance_id, group_id);


--
-- TOC entry 2242 (class 2606 OID 47564)
-- Name: sandbox sandbox_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sandbox
    ADD CONSTRAINT sandbox_pkey PRIMARY KEY (id);


--
-- TOC entry 2248 (class 2606 OID 47591)
-- Name: scenario_instance_participant scenario_instance_participant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance_participant
    ADD CONSTRAINT scenario_instance_participant_pkey PRIMARY KEY (id);


--
-- TOC entry 2250 (class 2606 OID 47593)
-- Name: scenario_instance_participant scenario_instance_participant_site_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance_participant
    ADD CONSTRAINT scenario_instance_participant_site_id_key UNIQUE (site_id);


--
-- TOC entry 2246 (class 2606 OID 47583)
-- Name: scenario_instance scenario_instance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance
    ADD CONSTRAINT scenario_instance_pkey PRIMARY KEY (id);


--
-- TOC entry 2244 (class 2606 OID 47575)
-- Name: scenario scenario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario
    ADD CONSTRAINT scenario_pkey PRIMARY KEY (id);


--
-- TOC entry 2254 (class 2606 OID 47609)
-- Name: scenario_role_host_access scenario_role_host_access_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_role_host_access
    ADD CONSTRAINT scenario_role_host_access_pkey PRIMARY KEY (host_role_id, scenario_role_id);


--
-- TOC entry 2252 (class 2606 OID 47604)
-- Name: scenario_role scenario_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_role
    ADD CONSTRAINT scenario_role_pkey PRIMARY KEY (id);


--
-- TOC entry 2256 (class 2606 OID 47620)
-- Name: script script_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY script
    ADD CONSTRAINT script_pkey PRIMARY KEY (id);


--
-- TOC entry 2258 (class 2606 OID 47631)
-- Name: ssh_key ssh_key_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ssh_key
    ADD CONSTRAINT ssh_key_pkey PRIMARY KEY (id);


--
-- TOC entry 2260 (class 2606 OID 47636)
-- Name: supervisor supervisor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY supervisor
    ADD CONSTRAINT supervisor_pkey PRIMARY KEY (scenario_instance_id, group_id);


--
-- TOC entry 2262 (class 2606 OID 47641)
-- Name: user_idm_group user_idm_group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_idm_group
    ADD CONSTRAINT user_idm_group_pkey PRIMARY KEY (user_id, idm_group_id);


--
-- TOC entry 2264 (class 2606 OID 47656)
-- Name: users users_external_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_external_id_key UNIQUE (external_id);


--
-- TOC entry 2266 (class 2606 OID 47654)
-- Name: users users_liferay_sn_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_liferay_sn_key UNIQUE (liferay_sn);


--
-- TOC entry 2268 (class 2606 OID 47652)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2281 (class 2606 OID 47782)
-- Name: level entryscript; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level
    ADD CONSTRAINT entryscript FOREIGN KEY (entry_script_id) REFERENCES script(id);


--
-- TOC entry 2282 (class 2606 OID 47787)
-- Name: level exitscript; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level
    ADD CONSTRAINT exitscript FOREIGN KEY (exit_script_id) REFERENCES script(id);


--
-- TOC entry 2269 (class 2606 OID 47657)
-- Name: chat_room fkchat_room442000; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY chat_room
    ADD CONSTRAINT fkchat_room442000 FOREIGN KEY (scenario_instance_id) REFERENCES scenario_instance(id);


--
-- TOC entry 2271 (class 2606 OID 47667)
-- Name: disk_image fkdisk_image180118; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_image
    ADD CONSTRAINT fkdisk_image180118 FOREIGN KEY (os_id) REFERENCES os(id);


--
-- TOC entry 2270 (class 2606 OID 47662)
-- Name: disk_image fkdisk_image220012; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_image
    ADD CONSTRAINT fkdisk_image220012 FOREIGN KEY (image_type_id) REFERENCES image_type(id);


--
-- TOC entry 2273 (class 2606 OID 47677)
-- Name: disk_image fkdisk_image226437; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_image
    ADD CONSTRAINT fkdisk_image226437 FOREIGN KEY (ssh_key_id) REFERENCES ssh_key(id);


--
-- TOC entry 2272 (class 2606 OID 47672)
-- Name: disk_image fkdisk_image875298; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_image
    ADD CONSTRAINT fkdisk_image875298 FOREIGN KEY (disk_target_id) REFERENCES disk_target(id);


--
-- TOC entry 2275 (class 2606 OID 47682)
-- Name: game fkgame543243; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY game
    ADD CONSTRAINT fkgame543243 FOREIGN KEY (scenario_id) REFERENCES scenario(id);


--
-- TOC entry 2277 (class 2606 OID 47737)
-- Name: host_role fkhost_role943689; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY host_role
    ADD CONSTRAINT fkhost_role943689 FOREIGN KEY (scenario_id) REFERENCES scenario(id);


--
-- TOC entry 2279 (class 2606 OID 47687)
-- Name: kypo_point_tunnel fkkypo_point277883; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kypo_point_tunnel
    ADD CONSTRAINT fkkypo_point277883 FOREIGN KEY (sandbox_id) REFERENCES sandbox(id);


--
-- TOC entry 2280 (class 2606 OID 47692)
-- Name: kypo_point_tunnel fkkypo_point378460; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kypo_point_tunnel
    ADD CONSTRAINT fkkypo_point378460 FOREIGN KEY (kypo_point_id) REFERENCES kypo_point(id);


--
-- TOC entry 2285 (class 2606 OID 47752)
-- Name: organizer fkorganizer229144; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY organizer
    ADD CONSTRAINT fkorganizer229144 FOREIGN KEY (scenario_id) REFERENCES scenario(id);


--
-- TOC entry 2286 (class 2606 OID 47757)
-- Name: organizer fkorganizer996741; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY organizer
    ADD CONSTRAINT fkorganizer996741 FOREIGN KEY (group_id) REFERENCES idm_group(id);


--
-- TOC entry 2287 (class 2606 OID 47772)
-- Name: participant fkparticipan69844; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY participant
    ADD CONSTRAINT fkparticipan69844 FOREIGN KEY (scenario_instance_id) REFERENCES scenario_instance(id);


--
-- TOC entry 2288 (class 2606 OID 47777)
-- Name: participant fkparticipan944607; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY participant
    ADD CONSTRAINT fkparticipan944607 FOREIGN KEY (group_id) REFERENCES idm_group(id);


--
-- TOC entry 2289 (class 2606 OID 47742)
-- Name: sandbox fksandbox909001; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sandbox
    ADD CONSTRAINT fksandbox909001 FOREIGN KEY (scenario_instance_id) REFERENCES scenario_instance(id);


--
-- TOC entry 2291 (class 2606 OID 47722)
-- Name: scenario_instance_participant fkscenario_i294356; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance_participant
    ADD CONSTRAINT fkscenario_i294356 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2292 (class 2606 OID 47732)
-- Name: scenario_instance_participant fkscenario_i309401; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance_participant
    ADD CONSTRAINT fkscenario_i309401 FOREIGN KEY (scenario_role_id) REFERENCES scenario_role(id);


--
-- TOC entry 2290 (class 2606 OID 47717)
-- Name: scenario_instance fkscenario_i322112; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance
    ADD CONSTRAINT fkscenario_i322112 FOREIGN KEY (scenario_id) REFERENCES scenario(id);


--
-- TOC entry 2293 (class 2606 OID 47747)
-- Name: scenario_instance_participant fkscenario_i478374; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_instance_participant
    ADD CONSTRAINT fkscenario_i478374 FOREIGN KEY (sandbox_id) REFERENCES sandbox(id);


--
-- TOC entry 2295 (class 2606 OID 47707)
-- Name: scenario_role_host_access fkscenario_r646835; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_role_host_access
    ADD CONSTRAINT fkscenario_r646835 FOREIGN KEY (host_role_id) REFERENCES host_role(id);


--
-- TOC entry 2294 (class 2606 OID 47727)
-- Name: scenario_role fkscenario_r879101; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_role
    ADD CONSTRAINT fkscenario_r879101 FOREIGN KEY (scenario_id) REFERENCES scenario(id);


--
-- TOC entry 2296 (class 2606 OID 47712)
-- Name: scenario_role_host_access fkscenario_r907574; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scenario_role_host_access
    ADD CONSTRAINT fkscenario_r907574 FOREIGN KEY (scenario_role_id) REFERENCES scenario_role(id);


--
-- TOC entry 2297 (class 2606 OID 47762)
-- Name: supervisor fksupervisor247047; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY supervisor
    ADD CONSTRAINT fksupervisor247047 FOREIGN KEY (scenario_instance_id) REFERENCES scenario_instance(id);


--
-- TOC entry 2298 (class 2606 OID 47767)
-- Name: supervisor fksupervisor372283; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY supervisor
    ADD CONSTRAINT fksupervisor372283 FOREIGN KEY (group_id) REFERENCES idm_group(id);


--
-- TOC entry 2299 (class 2606 OID 47697)
-- Name: user_idm_group fkuser_idm_g192649; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_idm_group
    ADD CONSTRAINT fkuser_idm_g192649 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2300 (class 2606 OID 47702)
-- Name: user_idm_group fkuser_idm_g351385; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_idm_group
    ADD CONSTRAINT fkuser_idm_g351385 FOREIGN KEY (idm_group_id) REFERENCES idm_group(id);


--
-- TOC entry 2276 (class 2606 OID 47792)
-- Name: hint hints; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hint
    ADD CONSTRAINT hints FOREIGN KEY (level_id) REFERENCES level(id);


--
-- TOC entry 2274 (class 2606 OID 47797)
-- Name: disk_image image owner; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY disk_image
    ADD CONSTRAINT "image owner" FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2283 (class 2606 OID 47802)
-- Name: level levels; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level
    ADD CONSTRAINT levels FOREIGN KEY (game_id) REFERENCES game(id);


--
-- TOC entry 2278 (class 2606 OID 47807)
-- Name: kypo_point owner; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY kypo_point
    ADD CONSTRAINT owner FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2284 (class 2606 OID 47812)
-- Name: level skipscript; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY level
    ADD CONSTRAINT skipscript FOREIGN KEY (skip_script_id) REFERENCES script(id);


-- Completed on 2017-10-23 10:19:25 CEST

--
-- PostgreSQL database dump complete
--


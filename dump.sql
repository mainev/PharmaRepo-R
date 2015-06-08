--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: main; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA main;


ALTER SCHEMA main OWNER TO postgres;

--
-- Name: SCHEMA main; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA main IS 'standard public schema';


--
-- Name: mbr; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA mbr;


ALTER SCHEMA mbr OWNER TO postgres;

--
-- Name: SCHEMA mbr; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA mbr IS 'table grouping for mbr';


--
-- Name: mmd_tolling; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA mmd_tolling;


ALTER SCHEMA mmd_tolling OWNER TO postgres;

--
-- Name: SCHEMA mmd_tolling; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA mmd_tolling IS 'UNUSED';


--
-- Name: rdr; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA rdr;


ALTER SCHEMA rdr OWNER TO postgres;

--
-- Name: SCHEMA rdr; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA rdr IS 'UNUSED';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = main, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: area; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE area (
    id smallint NOT NULL,
    description character varying(50)
);


ALTER TABLE main.area OWNER TO postgres;

--
-- Name: area_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE area_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.area_id_seq OWNER TO postgres;

--
-- Name: area_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE area_id_seq OWNED BY area.id;


--
-- Name: classification; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE classification (
    id smallint NOT NULL,
    name character varying(15)
);


ALTER TABLE main.classification OWNER TO postgres;

--
-- Name: classification_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE classification_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.classification_id_seq OWNER TO postgres;

--
-- Name: classification_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE classification_id_seq OWNED BY classification.id;


--
-- Name: client; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE client (
    id smallint NOT NULL,
    name character varying(10)
);


ALTER TABLE main.client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE client_id_seq OWNED BY client.id;


--
-- Name: container; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE container (
    id smallint NOT NULL,
    name character varying(20)
);


ALTER TABLE main.container OWNER TO postgres;

--
-- Name: container_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE container_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.container_id_seq OWNER TO postgres;

--
-- Name: container_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE container_id_seq OWNED BY container.id;


--
-- Name: equipment; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE equipment (
    id smallint NOT NULL,
    code character varying(15),
    name character varying(100)
);


ALTER TABLE main.equipment OWNER TO postgres;

--
-- Name: COLUMN equipment.code; Type: COMMENT; Schema: main; Owner: postgres
--

COMMENT ON COLUMN equipment.code IS 'equivalent to id_no';


--
-- Name: equipment_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE equipment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.equipment_id_seq OWNER TO postgres;

--
-- Name: equipment_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE equipment_id_seq OWNED BY equipment.id;


--
-- Name: packaging_material; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE packaging_material (
    id integer NOT NULL,
    code character varying(15),
    description character varying(100),
    client_id smallint
);


ALTER TABLE main.packaging_material OWNER TO postgres;

--
-- Name: packaging_material_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE packaging_material_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.packaging_material_id_seq OWNER TO postgres;

--
-- Name: packaging_material_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE packaging_material_id_seq OWNED BY packaging_material.id;


--
-- Name: product; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE product (
    id integer NOT NULL,
    code character varying(5),
    brand_name character varying(200),
    generic_name character varying(200),
    client_id smallint,
    vr_no character varying(10),
    shelf_life smallint,
    area_id smallint,
    classification_id smallint
);


ALTER TABLE main.product OWNER TO postgres;

--
-- Name: product_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.product_id_seq OWNER TO postgres;

--
-- Name: product_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE product_id_seq OWNED BY product.id;


--
-- Name: raw_material; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE raw_material (
    id integer NOT NULL,
    code character varying(15),
    name character varying(100),
    description character varying(100),
    client_id smallint,
    classification_id smallint
);


ALTER TABLE main.raw_material OWNER TO postgres;

--
-- Name: raw_material_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE raw_material_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.raw_material_id_seq OWNER TO postgres;

--
-- Name: raw_material_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE raw_material_id_seq OWNED BY raw_material.id;


--
-- Name: unit; Type: TABLE; Schema: main; Owner: postgres; Tablespace: 
--

CREATE TABLE unit (
    id smallint NOT NULL,
    name character varying(15)
);


ALTER TABLE main.unit OWNER TO postgres;

--
-- Name: unit_id_seq; Type: SEQUENCE; Schema: main; Owner: postgres
--

CREATE SEQUENCE unit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main.unit_id_seq OWNER TO postgres;

--
-- Name: unit_id_seq; Type: SEQUENCE OWNED BY; Schema: main; Owner: postgres
--

ALTER SEQUENCE unit_id_seq OWNED BY unit.id;


SET search_path = mbr, pg_catalog;

--
-- Name: bottle_and_cbox_page; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE bottle_and_cbox_page (
    id integer NOT NULL,
    bottle_id integer,
    cbox_id integer,
    product_id integer
);


ALTER TABLE mbr.bottle_and_cbox_page OWNER TO postgres;

--
-- Name: bottle_and_cbox_page_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE bottle_and_cbox_page_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.bottle_and_cbox_page_id_seq OWNER TO postgres;

--
-- Name: bottle_and_cbox_page_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE bottle_and_cbox_page_id_seq OWNED BY bottle_and_cbox_page.id;


--
-- Name: compounding_procedure; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE compounding_procedure (
    id integer NOT NULL,
    step_number smallint,
    procedure_head character varying(500),
    done_by character varying(100),
    checked_by character varying(100),
    manufacturing_procedure_id integer,
    footer boolean
);


ALTER TABLE mbr.compounding_procedure OWNER TO postgres;

--
-- Name: compounding_procedure_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE compounding_procedure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.compounding_procedure_id_seq OWNER TO postgres;

--
-- Name: compounding_procedure_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE compounding_procedure_id_seq OWNED BY compounding_procedure.id;


--
-- Name: dosage_in_procedure; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE dosage_in_procedure (
    id integer NOT NULL,
    raw_material_requirements_id integer,
    quantity double precision,
    percent_multiplier double precision,
    compounding_procedure_id integer,
    unit_id smallint
);


ALTER TABLE mbr.dosage_in_procedure OWNER TO postgres;

--
-- Name: dosage_in_procedure_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE dosage_in_procedure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.dosage_in_procedure_id_seq OWNER TO postgres;

--
-- Name: dosage_in_procedure_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE dosage_in_procedure_id_seq OWNED BY dosage_in_procedure.id;


--
-- Name: equipment_requirements_coding; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE equipment_requirements_coding (
    id integer NOT NULL,
    manufacturing_procedure_id integer,
    equipment_id smallint
);


ALTER TABLE mbr.equipment_requirements_coding OWNER TO postgres;

--
-- Name: equipment_requirements_coding_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE equipment_requirements_coding_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.equipment_requirements_coding_id_seq OWNER TO postgres;

--
-- Name: equipment_requirements_coding_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE equipment_requirements_coding_id_seq OWNED BY equipment_requirements_coding.id;


--
-- Name: equipment_requirements_compounding; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE equipment_requirements_compounding (
    id integer NOT NULL,
    manufacturing_procedure_id integer,
    equipment_id integer
);


ALTER TABLE mbr.equipment_requirements_compounding OWNER TO postgres;

--
-- Name: equipment_requirements_compounding_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE equipment_requirements_compounding_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.equipment_requirements_compounding_id_seq OWNER TO postgres;

--
-- Name: equipment_requirements_compounding_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE equipment_requirements_compounding_id_seq OWNED BY equipment_requirements_compounding.id;


--
-- Name: equipment_requirements_encapsulation; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE equipment_requirements_encapsulation (
    id integer NOT NULL,
    manufacturing_procedure_id integer,
    equipment_id integer
);


ALTER TABLE mbr.equipment_requirements_encapsulation OWNER TO postgres;

--
-- Name: equipment_requirements_encapsulation_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE equipment_requirements_encapsulation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.equipment_requirements_encapsulation_id_seq OWNER TO postgres;

--
-- Name: equipment_requirements_encapsulation_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE equipment_requirements_encapsulation_id_seq OWNED BY equipment_requirements_encapsulation.id;


--
-- Name: equipment_requirements_packaging_procedure; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE equipment_requirements_packaging_procedure (
    id integer NOT NULL,
    packaging_procedure_id integer,
    equipment_id smallint
);


ALTER TABLE mbr.equipment_requirements_packaging_procedure OWNER TO postgres;

--
-- Name: equipment_requirements_packaging_procedure_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE equipment_requirements_packaging_procedure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.equipment_requirements_packaging_procedure_id_seq OWNER TO postgres;

--
-- Name: equipment_requirements_packaging_procedure_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE equipment_requirements_packaging_procedure_id_seq OWNED BY equipment_requirements_packaging_procedure.id;


--
-- Name: manufacturing_procedure; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE manufacturing_procedure (
    id integer NOT NULL,
    product_id integer,
    is_active boolean
);


ALTER TABLE mbr.manufacturing_procedure OWNER TO postgres;

--
-- Name: manufacturing_procedure_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE manufacturing_procedure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.manufacturing_procedure_id_seq OWNER TO postgres;

--
-- Name: manufacturing_procedure_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE manufacturing_procedure_id_seq OWNED BY manufacturing_procedure.id;


--
-- Name: manufacturing_procedure_product_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE manufacturing_procedure_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.manufacturing_procedure_product_id_seq OWNER TO postgres;

--
-- Name: manufacturing_procedure_product_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE manufacturing_procedure_product_id_seq OWNED BY manufacturing_procedure.product_id;


--
-- Name: mbr; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE mbr (
    id integer NOT NULL,
    batch_size double precision,
    batch_no character varying(10),
    mfg_date date,
    exp_date date,
    po_no character varying(15),
    unit_id smallint,
    product_pack_size_id integer
);


ALTER TABLE mbr.mbr OWNER TO postgres;

--
-- Name: mbr_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE mbr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.mbr_id_seq OWNER TO postgres;

--
-- Name: mbr_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE mbr_id_seq OWNED BY mbr.id;


--
-- Name: pack_size; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE pack_size (
    id integer NOT NULL,
    quantity double precision,
    unit_id smallint,
    container_id smallint
);


ALTER TABLE mbr.pack_size OWNER TO postgres;

--
-- Name: pack_size_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE pack_size_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.pack_size_id_seq OWNER TO postgres;

--
-- Name: pack_size_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE pack_size_id_seq OWNED BY pack_size.id;


--
-- Name: packaging_material_requirements; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE packaging_material_requirements (
    id integer NOT NULL,
    packaging_material_id integer,
    quantity double precision,
    udf_id integer,
    unit_id smallint
);


ALTER TABLE mbr.packaging_material_requirements OWNER TO postgres;

--
-- Name: packaging_material_requirements_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE packaging_material_requirements_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.packaging_material_requirements_id_seq OWNER TO postgres;

--
-- Name: packaging_material_requirements_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE packaging_material_requirements_id_seq OWNED BY packaging_material_requirements.id;


--
-- Name: packaging_procedure; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE packaging_procedure (
    id integer NOT NULL,
    step_number smallint,
    procedure_head character varying(200),
    product_pack_size_id integer
);


ALTER TABLE mbr.packaging_procedure OWNER TO postgres;

--
-- Name: packaging_procedure_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE packaging_procedure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.packaging_procedure_id_seq OWNER TO postgres;

--
-- Name: packaging_procedure_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE packaging_procedure_id_seq OWNED BY packaging_procedure.id;


--
-- Name: packaging_procedure_operation; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE packaging_procedure_operation (
    id integer NOT NULL,
    procedure character varying(200),
    step_number smallint,
    product_pack_size_id integer
);


ALTER TABLE mbr.packaging_procedure_operation OWNER TO postgres;

--
-- Name: packaging_procedure_operation_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE packaging_procedure_operation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.packaging_procedure_operation_id_seq OWNER TO postgres;

--
-- Name: packaging_procedure_operation_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE packaging_procedure_operation_id_seq OWNED BY packaging_procedure_operation.id;


--
-- Name: product_pack_size; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE product_pack_size (
    id integer NOT NULL,
    product_id integer,
    pack_size_id smallint
);


ALTER TABLE mbr.product_pack_size OWNER TO postgres;

--
-- Name: product_pack_size_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE product_pack_size_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.product_pack_size_id_seq OWNER TO postgres;

--
-- Name: product_pack_size_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE product_pack_size_id_seq OWNED BY product_pack_size.id;


--
-- Name: raw_material_requirements; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE raw_material_requirements (
    id integer NOT NULL,
    raw_material_id integer,
    quantity double precision,
    udf_id integer,
    unit_id smallint
);


ALTER TABLE mbr.raw_material_requirements OWNER TO postgres;

--
-- Name: raw_material_requirements_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE raw_material_requirements_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.raw_material_requirements_id_seq OWNER TO postgres;

--
-- Name: raw_material_requirements_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE raw_material_requirements_id_seq OWNED BY raw_material_requirements.id;


--
-- Name: udf; Type: TABLE; Schema: mbr; Owner: postgres; Tablespace: 
--

CREATE TABLE udf (
    id integer NOT NULL,
    content double precision,
    product_id integer,
    unit_id smallint,
    is_active boolean
);


ALTER TABLE mbr.udf OWNER TO postgres;

--
-- Name: udf_id_seq; Type: SEQUENCE; Schema: mbr; Owner: postgres
--

CREATE SEQUENCE udf_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mbr.udf_id_seq OWNER TO postgres;

--
-- Name: udf_id_seq; Type: SEQUENCE OWNED BY; Schema: mbr; Owner: postgres
--

ALTER SEQUENCE udf_id_seq OWNED BY udf.id;


SET search_path = mmd_tolling, pg_catalog;

--
-- Name: issued_packaging_material; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE issued_packaging_material (
    id integer NOT NULL,
    quantity double precision,
    product_id integer,
    batch_no character varying(10),
    issued_by character varying(50),
    received_packaging_material_id integer,
    date_issued timestamp without time zone,
    unit smallint
);


ALTER TABLE mmd_tolling.issued_packaging_material OWNER TO postgres;

--
-- Name: issued_raw_material; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE issued_raw_material (
    id integer NOT NULL,
    quantity double precision,
    batch_no character varying(10),
    po_no character varying(10),
    issued_by character varying(100),
    dispensed_by character varying(100),
    received_raw_material_id integer,
    product_id integer,
    date_issued timestamp with time zone,
    unit smallint
);


ALTER TABLE mmd_tolling.issued_raw_material OWNER TO postgres;

--
-- Name: issued_raw_material_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE issued_raw_material_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.issued_raw_material_id_seq OWNER TO postgres;

--
-- Name: issued_raw_material_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE issued_raw_material_id_seq OWNED BY issued_raw_material.id;


--
-- Name: raw_material_request; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE raw_material_request (
    id integer NOT NULL,
    batch_no character varying(15),
    po_no character varying(15),
    issued_by character varying(100),
    dispensed_by character varying(100),
    date_issued timestamp with time zone
);


ALTER TABLE mmd_tolling.raw_material_request OWNER TO postgres;

--
-- Name: raw_material_request_entry; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE raw_material_request_entry (
    id integer NOT NULL,
    quantity double precision,
    unit_id smallint,
    raw_material_request_id integer,
    raw_material_id integer
);


ALTER TABLE mmd_tolling.raw_material_request_entry OWNER TO postgres;

--
-- Name: raw_material_request_entry_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE raw_material_request_entry_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.raw_material_request_entry_id_seq OWNER TO postgres;

--
-- Name: raw_material_request_entry_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE raw_material_request_entry_id_seq OWNED BY raw_material_request_entry.id;


--
-- Name: raw_material_request_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE raw_material_request_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.raw_material_request_id_seq OWNER TO postgres;

--
-- Name: raw_material_request_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE raw_material_request_id_seq OWNED BY raw_material_request.id;


--
-- Name: raw_material_request_transaction; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE raw_material_request_transaction (
    id integer NOT NULL,
    quantity double precision,
    unit_id smallint,
    raw_material_request_entry_id integer,
    received_raw_material_id integer
);


ALTER TABLE mmd_tolling.raw_material_request_transaction OWNER TO postgres;

--
-- Name: raw_material_request_transaction_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE raw_material_request_transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.raw_material_request_transaction_id_seq OWNER TO postgres;

--
-- Name: raw_material_request_transaction_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE raw_material_request_transaction_id_seq OWNED BY raw_material_request_transaction.id;


--
-- Name: received_packaging_material; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE received_packaging_material (
    id integer NOT NULL,
    packaging_material_id integer,
    date_received timestamp without time zone,
    rr_no character varying(10),
    quantity double precision,
    qc_control_no character varying(15),
    received_by character varying(50),
    unit smallint
);


ALTER TABLE mmd_tolling.received_packaging_material OWNER TO postgres;

--
-- Name: received_packaging_material_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE received_packaging_material_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.received_packaging_material_id_seq OWNER TO postgres;

--
-- Name: received_packaging_material_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE received_packaging_material_id_seq OWNED BY received_packaging_material.id;


--
-- Name: received_raw_material; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE received_raw_material (
    id integer NOT NULL,
    date_received timestamp without time zone,
    quantity double precision,
    batch_no character varying(10),
    qc_control_no character varying(15),
    manufacturing_date date,
    exp_date date,
    rr_no character varying(10),
    received_by character varying(50),
    raw_material_id integer,
    unit smallint
);


ALTER TABLE mmd_tolling.received_raw_material OWNER TO postgres;

--
-- Name: received_raw_material_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE received_raw_material_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.received_raw_material_id_seq OWNER TO postgres;

--
-- Name: received_raw_material_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE received_raw_material_id_seq OWNED BY received_raw_material.id;


--
-- Name: transaction; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE transaction (
    id integer NOT NULL,
    transaction_type_id smallint,
    quantity double precision,
    product_id integer,
    batch_no character varying(10),
    transacted_by character varying(100),
    received_packaging_material_id integer,
    date_of_transaction timestamp without time zone,
    unit smallint
);


ALTER TABLE mmd_tolling.transaction OWNER TO postgres;

--
-- Name: transaction_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.transaction_id_seq OWNER TO postgres;

--
-- Name: transaction_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE transaction_id_seq OWNED BY transaction.id;


--
-- Name: transaction_type; Type: TABLE; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

CREATE TABLE transaction_type (
    id integer NOT NULL,
    description character varying(10),
    subtype character varying(10)
);


ALTER TABLE mmd_tolling.transaction_type OWNER TO postgres;

--
-- Name: transaction_type_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE transaction_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.transaction_type_id_seq OWNER TO postgres;

--
-- Name: transaction_type_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE transaction_type_id_seq OWNED BY transaction_type.id;


--
-- Name: transferred_packaging_material_id_seq; Type: SEQUENCE; Schema: mmd_tolling; Owner: postgres
--

CREATE SEQUENCE transferred_packaging_material_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mmd_tolling.transferred_packaging_material_id_seq OWNER TO postgres;

--
-- Name: transferred_packaging_material_id_seq; Type: SEQUENCE OWNED BY; Schema: mmd_tolling; Owner: postgres
--

ALTER SEQUENCE transferred_packaging_material_id_seq OWNED BY issued_packaging_material.id;


SET search_path = rdr, pg_catalog;

--
-- Name: received_packaging_material; Type: TABLE; Schema: rdr; Owner: postgres; Tablespace: 
--

CREATE TABLE received_packaging_material (
    id integer NOT NULL,
    rr_no character varying(10),
    control_no character varying(15),
    po_no character varying(15),
    quantity integer,
    quantity_per_bundle integer,
    date_received date,
    supplier character varying(20),
    dr_no character varying(20),
    packaging_material_id integer,
    unit_cost double precision,
    unit smallint
);


ALTER TABLE rdr.received_packaging_material OWNER TO postgres;

--
-- Name: received_pm_id_seq; Type: SEQUENCE; Schema: rdr; Owner: postgres
--

CREATE SEQUENCE received_pm_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rdr.received_pm_id_seq OWNER TO postgres;

--
-- Name: received_pm_id_seq; Type: SEQUENCE OWNED BY; Schema: rdr; Owner: postgres
--

ALTER SEQUENCE received_pm_id_seq OWNED BY received_packaging_material.id;


--
-- Name: received_raw_material; Type: TABLE; Schema: rdr; Owner: postgres; Tablespace: 
--

CREATE TABLE received_raw_material (
    batch_no character varying(10),
    rr_no character varying(10),
    date_received date,
    exp_date date,
    quantity double precision,
    amount_per_container double precision,
    id integer NOT NULL,
    raw_material_id integer,
    unit_cost double precision,
    unit smallint
);


ALTER TABLE rdr.received_raw_material OWNER TO postgres;

--
-- Name: received_rm_id_seq; Type: SEQUENCE; Schema: rdr; Owner: postgres
--

CREATE SEQUENCE received_rm_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rdr.received_rm_id_seq OWNER TO postgres;

--
-- Name: received_rm_id_seq; Type: SEQUENCE OWNED BY; Schema: rdr; Owner: postgres
--

ALTER SEQUENCE received_rm_id_seq OWNED BY received_raw_material.id;


--
-- Name: transferred_packaging_material; Type: TABLE; Schema: rdr; Owner: postgres; Tablespace: 
--

CREATE TABLE transferred_packaging_material (
    date_transferred date,
    ts_no character varying(10),
    purpose character varying(100),
    quantity integer,
    bundle_no smallint,
    status character varying(15),
    is_transferred boolean,
    id integer NOT NULL,
    received_pm_id integer
);


ALTER TABLE rdr.transferred_packaging_material OWNER TO postgres;

--
-- Name: transferred_pm_id_seq; Type: SEQUENCE; Schema: rdr; Owner: postgres
--

CREATE SEQUENCE transferred_pm_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rdr.transferred_pm_id_seq OWNER TO postgres;

--
-- Name: transferred_pm_id_seq; Type: SEQUENCE OWNED BY; Schema: rdr; Owner: postgres
--

ALTER SEQUENCE transferred_pm_id_seq OWNED BY transferred_packaging_material.id;


--
-- Name: transferred_raw_material; Type: TABLE; Schema: rdr; Owner: postgres; Tablespace: 
--

CREATE TABLE transferred_raw_material (
    is_transferred boolean,
    ts_no character varying(10),
    so_no character varying(10),
    date_transferred date,
    quantity double precision,
    container_no smallint,
    id integer NOT NULL,
    product_id integer,
    received_rm_id integer,
    status character varying(15),
    unit smallint
);


ALTER TABLE rdr.transferred_raw_material OWNER TO postgres;

--
-- Name: transferred_rm_id_seq; Type: SEQUENCE; Schema: rdr; Owner: postgres
--

CREATE SEQUENCE transferred_rm_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rdr.transferred_rm_id_seq OWNER TO postgres;

--
-- Name: transferred_rm_id_seq; Type: SEQUENCE OWNED BY; Schema: rdr; Owner: postgres
--

ALTER SEQUENCE transferred_rm_id_seq OWNED BY transferred_raw_material.id;


SET search_path = main, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY area ALTER COLUMN id SET DEFAULT nextval('area_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY classification ALTER COLUMN id SET DEFAULT nextval('classification_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY container ALTER COLUMN id SET DEFAULT nextval('container_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY equipment ALTER COLUMN id SET DEFAULT nextval('equipment_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY packaging_material ALTER COLUMN id SET DEFAULT nextval('packaging_material_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY product ALTER COLUMN id SET DEFAULT nextval('product_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY raw_material ALTER COLUMN id SET DEFAULT nextval('raw_material_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY unit ALTER COLUMN id SET DEFAULT nextval('unit_id_seq'::regclass);


SET search_path = mbr, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY bottle_and_cbox_page ALTER COLUMN id SET DEFAULT nextval('bottle_and_cbox_page_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY compounding_procedure ALTER COLUMN id SET DEFAULT nextval('compounding_procedure_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY dosage_in_procedure ALTER COLUMN id SET DEFAULT nextval('dosage_in_procedure_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_coding ALTER COLUMN id SET DEFAULT nextval('equipment_requirements_coding_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_compounding ALTER COLUMN id SET DEFAULT nextval('equipment_requirements_compounding_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_encapsulation ALTER COLUMN id SET DEFAULT nextval('equipment_requirements_encapsulation_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_packaging_procedure ALTER COLUMN id SET DEFAULT nextval('equipment_requirements_packaging_procedure_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY manufacturing_procedure ALTER COLUMN id SET DEFAULT nextval('manufacturing_procedure_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY mbr ALTER COLUMN id SET DEFAULT nextval('mbr_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY pack_size ALTER COLUMN id SET DEFAULT nextval('pack_size_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_material_requirements ALTER COLUMN id SET DEFAULT nextval('packaging_material_requirements_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_procedure ALTER COLUMN id SET DEFAULT nextval('packaging_procedure_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_procedure_operation ALTER COLUMN id SET DEFAULT nextval('packaging_procedure_operation_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY product_pack_size ALTER COLUMN id SET DEFAULT nextval('product_pack_size_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY raw_material_requirements ALTER COLUMN id SET DEFAULT nextval('raw_material_requirements_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY udf ALTER COLUMN id SET DEFAULT nextval('udf_id_seq'::regclass);


SET search_path = mmd_tolling, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_packaging_material ALTER COLUMN id SET DEFAULT nextval('transferred_packaging_material_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_raw_material ALTER COLUMN id SET DEFAULT nextval('issued_raw_material_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request ALTER COLUMN id SET DEFAULT nextval('raw_material_request_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_entry ALTER COLUMN id SET DEFAULT nextval('raw_material_request_entry_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_transaction ALTER COLUMN id SET DEFAULT nextval('raw_material_request_transaction_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY received_packaging_material ALTER COLUMN id SET DEFAULT nextval('received_packaging_material_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY received_raw_material ALTER COLUMN id SET DEFAULT nextval('received_raw_material_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY transaction ALTER COLUMN id SET DEFAULT nextval('transaction_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY transaction_type ALTER COLUMN id SET DEFAULT nextval('transaction_type_id_seq'::regclass);


SET search_path = rdr, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY received_packaging_material ALTER COLUMN id SET DEFAULT nextval('received_pm_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY received_raw_material ALTER COLUMN id SET DEFAULT nextval('received_rm_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY transferred_packaging_material ALTER COLUMN id SET DEFAULT nextval('transferred_pm_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY transferred_raw_material ALTER COLUMN id SET DEFAULT nextval('transferred_rm_id_seq'::regclass);


SET search_path = main, pg_catalog;

--
-- Data for Name: area; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO area VALUES (1, 'LIQUID VET');
INSERT INTO area VALUES (2, 'LIQUID HUMAN');
INSERT INTO area VALUES (3, 'POWDER AREA');
INSERT INTO area VALUES (4, 'TABLET HUMAN');
INSERT INTO area VALUES (5, 'TABLET VET');


--
-- Name: area_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('area_id_seq', 5, true);


--
-- Data for Name: classification; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO classification VALUES (1, 'LIQUID');
INSERT INTO classification VALUES (2, 'POWDER');
INSERT INTO classification VALUES (3, 'CAPSULE');


--
-- Name: classification_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('classification_id_seq', 3, true);


--
-- Data for Name: client; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO client VALUES (1, 'APT-HEALTH');
INSERT INTO client VALUES (2, 'DERMCLINIC');


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('client_id_seq', 2, true);


--
-- Data for Name: container; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO container VALUES (1, 'bottle');


--
-- Name: container_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('container_id_seq', 1, true);


--
-- Data for Name: equipment; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO equipment VALUES (2, 'NEQ-039', 'Paddle Mixer');
INSERT INTO equipment VALUES (3, 'NEQ-130', 'Encapsulating Machine');
INSERT INTO equipment VALUES (4, NULL, 'Scoops');
INSERT INTO equipment VALUES (5, NULL, 'Spatula');
INSERT INTO equipment VALUES (6, NULL, 'Weighing Balance');
INSERT INTO equipment VALUES (7, NULL, 'PE Bag');
INSERT INTO equipment VALUES (8, NULL, 'Mesh Screen #20');
INSERT INTO equipment VALUES (9, 'NQC-LAB-021', 'Analytical Weighing Balance');


--
-- Name: equipment_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('equipment_id_seq', 9, true);


--
-- Data for Name: packaging_material; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO packaging_material VALUES (1, 'pm1', 'laptop', 1);
INSERT INTO packaging_material VALUES (2, 'pm001', 'HDPE Bottle with cap, (Glutathione)', 2);
INSERT INTO packaging_material VALUES (3, 'PM002', 'Paper Lean', 2);
INSERT INTO packaging_material VALUES (4, 'PM003', 'Moisture Adsorbent (0.50g)', 2);
INSERT INTO packaging_material VALUES (5, 'PM004', 'Labels', 2);
INSERT INTO packaging_material VALUES (6, 'PM005', 'Corrugated Box', 2);
INSERT INTO packaging_material VALUES (7, 'PM006', 'Packaging Tape (PLAIN)', 2);


--
-- Name: packaging_material_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('packaging_material_id_seq', 7, true);


--
-- Data for Name: product; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO product VALUES (4, 'P25', 'NUDERM ADVANCE', 'L-Glutathione+ALA+Collagen+Vit.C 650mg/150mg/50mg/150mg', 2, 'N/A', 2, 4, NULL);


--
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('product_id_seq', 5, true);


--
-- Data for Name: raw_material; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO raw_material VALUES (8, 'DC006', 'L-Glutathione Powder', 'White crystalline powder.', 2, 2);
INSERT INTO raw_material VALUES (9, 'DC002', 'Alpha-lipoic Acid', 'Yellow crystalline powder.', 2, 2);
INSERT INTO raw_material VALUES (10, 'DC003', 'Collagen', 'White or light yellow powder.', 2, 2);
INSERT INTO raw_material VALUES (11, 'DC004', 'Vitamin C (Coated)', 'White or slightly yellow crystals or powder gradually darkens in exposure to light.', 2, 2);
INSERT INTO raw_material VALUES (12, 'DC005', 'Hard Empty Gelatin Capsule #00 (White/white)', NULL, 2, 3);
INSERT INTO raw_material VALUES (13, 'DC001', 'Silica Gels (100g)', NULL, 2, 3);


--
-- Name: raw_material_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('raw_material_id_seq', 13, true);


--
-- Data for Name: unit; Type: TABLE DATA; Schema: main; Owner: postgres
--

INSERT INTO unit VALUES (1, 'mL');
INSERT INTO unit VALUES (2, 'L');
INSERT INTO unit VALUES (4, 'mcg');
INSERT INTO unit VALUES (5, 'mg');
INSERT INTO unit VALUES (6, 'g');
INSERT INTO unit VALUES (7, 'kg');
INSERT INTO unit VALUES (8, 'roll');
INSERT INTO unit VALUES (9, 'pcs');
INSERT INTO unit VALUES (10, 'capsules');
INSERT INTO unit VALUES (3, 'mcL');
INSERT INTO unit VALUES (11, 'boxes');


--
-- Name: unit_id_seq; Type: SEQUENCE SET; Schema: main; Owner: postgres
--

SELECT pg_catalog.setval('unit_id_seq', 11, true);


SET search_path = mbr, pg_catalog;

--
-- Data for Name: bottle_and_cbox_page; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO bottle_and_cbox_page VALUES (1, 2, 6, 4);


--
-- Name: bottle_and_cbox_page_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('bottle_and_cbox_page_id_seq', 1, true);


--
-- Data for Name: compounding_procedure; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO compounding_procedure VALUES (2, 1, 'Ensure all the equipment, including manufacturing area cleaned and cleared from all traces of the previous batch tree from moisture.', NULL, NULL, 1, true);
INSERT INTO compounding_procedure VALUES (4, 3, 'Passing thru mesh #20 load Collage, Alpha-lipoic Acid and Vitamin C coated into the paddle mixer and mix for 3 minutes.', NULL, NULL, 1, true);
INSERT INTO compounding_procedure VALUES (5, 4, 'Add 1st part of L-Glutathione Powder to the bulk passing thru mesh #20 and mix for 5 minutes.', NULL, NULL, 1, true);
INSERT INTO compounding_procedure VALUES (6, 5, 'Load 2nd part of L-Glutathione Powder to the bulk passing thru mesh #20 and mix for 30 minutes.', NULL, NULL, 1, true);
INSERT INTO compounding_procedure VALUES (7, 6, 'QC to collect samples from the bulk for In-Process Analysis. 
   a. Homogeneity Test
       -Top: 10g
       -Middle: 10g
       -Bottom: 10g
   b. Bulk Density: 10g
   c. Moisture Content: 10g
   d. Microbial Test: 5g', NULL, NULL, 1, true);
INSERT INTO compounding_procedure VALUES (8, 7, 'Compute for the yield of the bulk.
   Theoretical Weight: _____
   Actual Weight: _____
   QC Samples: 55 g
   %Recovery: _____', NULL, NULL, 1, true);
INSERT INTO compounding_procedure VALUES (3, 2, 'Monitor RH (NMT 50%) and Temperature (NMT 25°C) every 15 minutes. Fill up form NF-QA-011-01-01. ', NULL, NULL, 1, false);
INSERT INTO compounding_procedure VALUES (9, 8, 'Store the bulk in a double-lined PE bag with silica gel in between PE bags and place inside the blue drum. Attach quarantine sticker and store in a room with controlled temperature (NMT 25°C) while waiting for QC disposition for encapsulation.', NULL, NULL, 1, true);


--
-- Name: compounding_procedure_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('compounding_procedure_id_seq', 9, true);


--
-- Data for Name: dosage_in_procedure; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO dosage_in_procedure VALUES (6, 11, 0, 1, 4, 7);
INSERT INTO dosage_in_procedure VALUES (7, 10, 0, 1, 4, 7);
INSERT INTO dosage_in_procedure VALUES (8, 12, 0, 1, 4, 7);
INSERT INTO dosage_in_procedure VALUES (9, 8, 0, 1, 5, 7);
INSERT INTO dosage_in_procedure VALUES (10, 9, 0, 1, 6, 7);


--
-- Name: dosage_in_procedure_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('dosage_in_procedure_id_seq', 10, true);


--
-- Data for Name: equipment_requirements_coding; Type: TABLE DATA; Schema: mbr; Owner: postgres
--



--
-- Name: equipment_requirements_coding_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('equipment_requirements_coding_id_seq', 1, false);


--
-- Data for Name: equipment_requirements_compounding; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO equipment_requirements_compounding VALUES (2, 1, 2);
INSERT INTO equipment_requirements_compounding VALUES (3, 1, 4);
INSERT INTO equipment_requirements_compounding VALUES (4, 1, 5);
INSERT INTO equipment_requirements_compounding VALUES (5, 1, 6);
INSERT INTO equipment_requirements_compounding VALUES (6, 1, 7);
INSERT INTO equipment_requirements_compounding VALUES (7, 1, 8);


--
-- Name: equipment_requirements_compounding_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('equipment_requirements_compounding_id_seq', 7, true);


--
-- Data for Name: equipment_requirements_encapsulation; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO equipment_requirements_encapsulation VALUES (2, 1, 3);
INSERT INTO equipment_requirements_encapsulation VALUES (3, 1, 9);


--
-- Name: equipment_requirements_encapsulation_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('equipment_requirements_encapsulation_id_seq', 3, true);


--
-- Data for Name: equipment_requirements_packaging_procedure; Type: TABLE DATA; Schema: mbr; Owner: postgres
--



--
-- Name: equipment_requirements_packaging_procedure_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('equipment_requirements_packaging_procedure_id_seq', 1, false);


--
-- Data for Name: manufacturing_procedure; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO manufacturing_procedure VALUES (1, 4, true);


--
-- Name: manufacturing_procedure_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('manufacturing_procedure_id_seq', 1, true);


--
-- Name: manufacturing_procedure_product_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('manufacturing_procedure_product_id_seq', 1, false);


--
-- Data for Name: mbr; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO mbr VALUES (42, 66, '66', '2015-05-22', '2015-05-22', '66', 4, 18);
INSERT INTO mbr VALUES (43, 30, '9099', '2015-05-23', '2015-05-30', 'opo0', 7, 19);
INSERT INTO mbr VALUES (44, 1000, 'qwerty', '2015-05-29', '2015-05-30', 'oop', 7, 18);
INSERT INTO mbr VALUES (45, 30, '2wd', '2015-06-19', '2015-06-26', 'tgh', 7, 19);
INSERT INTO mbr VALUES (46, 15, 'asdd', '2015-06-12', '2015-06-19', '222', 7, 19);
INSERT INTO mbr VALUES (47, 8, '514001', '2015-06-27', '2016-06-25', 'po09', 7, 19);
INSERT INTO mbr VALUES (48, 100, '908907', '2015-06-20', '2016-06-17', 'po08', 7, 19);


--
-- Name: mbr_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('mbr_id_seq', 48, true);


--
-- Data for Name: pack_size; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO pack_size VALUES (18, 50, 10, 1);
INSERT INTO pack_size VALUES (19, 30, 10, 1);


--
-- Name: pack_size_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('pack_size_id_seq', 19, true);


--
-- Data for Name: packaging_material_requirements; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO packaging_material_requirements VALUES (7, 2, 34, 1, 9);
INSERT INTO packaging_material_requirements VALUES (12, 7, 0.16700000000000001, 1, 8);
INSERT INTO packaging_material_requirements VALUES (8, 3, 34, 1, 9);
INSERT INTO packaging_material_requirements VALUES (9, 4, 34, 1, 9);
INSERT INTO packaging_material_requirements VALUES (11, 6, 0.67000000000000004, 1, 11);
INSERT INTO packaging_material_requirements VALUES (10, 5, 34.670000000000002, 1, 9);


--
-- Name: packaging_material_requirements_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('packaging_material_requirements_id_seq', 12, true);


--
-- Data for Name: packaging_procedure; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO packaging_procedure VALUES (1, 1, 'SAMPLE', 18);


--
-- Name: packaging_procedure_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('packaging_procedure_id_seq', 1, true);


--
-- Data for Name: packaging_procedure_operation; Type: TABLE DATA; Schema: mbr; Owner: postgres
--



--
-- Name: packaging_procedure_operation_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('packaging_procedure_operation_id_seq', 1, false);


--
-- Data for Name: product_pack_size; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO product_pack_size VALUES (18, 4, 18);
INSERT INTO product_pack_size VALUES (19, 4, 19);


--
-- Name: product_pack_size_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('product_pack_size_id_seq', 19, true);


--
-- Data for Name: raw_material_requirements; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO raw_material_requirements VALUES (8, 8, 333, 1, 5);
INSERT INTO raw_material_requirements VALUES (9, 8, 317, 1, 5);
INSERT INTO raw_material_requirements VALUES (10, 9, 150, 1, 5);
INSERT INTO raw_material_requirements VALUES (11, 10, 50, 1, 5);
INSERT INTO raw_material_requirements VALUES (12, 11, 150, 1, 5);
INSERT INTO raw_material_requirements VALUES (13, 12, 1, 1, 9);
INSERT INTO raw_material_requirements VALUES (14, 13, 20, 1, 9);


--
-- Name: raw_material_requirements_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('raw_material_requirements_id_seq', 14, true);


--
-- Data for Name: udf; Type: TABLE DATA; Schema: mbr; Owner: postgres
--

INSERT INTO udf VALUES (1, 1, 4, 6, true);


--
-- Name: udf_id_seq; Type: SEQUENCE SET; Schema: mbr; Owner: postgres
--

SELECT pg_catalog.setval('udf_id_seq', 1, true);


SET search_path = mmd_tolling, pg_catalog;

--
-- Data for Name: issued_packaging_material; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Data for Name: issued_raw_material; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Name: issued_raw_material_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('issued_raw_material_id_seq', 1, false);


--
-- Data for Name: raw_material_request; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Data for Name: raw_material_request_entry; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Name: raw_material_request_entry_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('raw_material_request_entry_id_seq', 1, false);


--
-- Name: raw_material_request_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('raw_material_request_id_seq', 1, false);


--
-- Data for Name: raw_material_request_transaction; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Name: raw_material_request_transaction_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('raw_material_request_transaction_id_seq', 1, false);


--
-- Data for Name: received_packaging_material; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Name: received_packaging_material_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('received_packaging_material_id_seq', 17, true);


--
-- Data for Name: received_raw_material; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Name: received_raw_material_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('received_raw_material_id_seq', 13, true);


--
-- Data for Name: transaction; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Name: transaction_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('transaction_id_seq', 1, false);


--
-- Data for Name: transaction_type; Type: TABLE DATA; Schema: mmd_tolling; Owner: postgres
--



--
-- Name: transaction_type_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('transaction_type_id_seq', 4, true);


--
-- Name: transferred_packaging_material_id_seq; Type: SEQUENCE SET; Schema: mmd_tolling; Owner: postgres
--

SELECT pg_catalog.setval('transferred_packaging_material_id_seq', 1, true);


SET search_path = rdr, pg_catalog;

--
-- Data for Name: received_packaging_material; Type: TABLE DATA; Schema: rdr; Owner: postgres
--



--
-- Name: received_pm_id_seq; Type: SEQUENCE SET; Schema: rdr; Owner: postgres
--

SELECT pg_catalog.setval('received_pm_id_seq', 11, true);


--
-- Data for Name: received_raw_material; Type: TABLE DATA; Schema: rdr; Owner: postgres
--



--
-- Name: received_rm_id_seq; Type: SEQUENCE SET; Schema: rdr; Owner: postgres
--

SELECT pg_catalog.setval('received_rm_id_seq', 14, true);


--
-- Data for Name: transferred_packaging_material; Type: TABLE DATA; Schema: rdr; Owner: postgres
--



--
-- Name: transferred_pm_id_seq; Type: SEQUENCE SET; Schema: rdr; Owner: postgres
--

SELECT pg_catalog.setval('transferred_pm_id_seq', 31, true);


--
-- Data for Name: transferred_raw_material; Type: TABLE DATA; Schema: rdr; Owner: postgres
--



--
-- Name: transferred_rm_id_seq; Type: SEQUENCE SET; Schema: rdr; Owner: postgres
--

SELECT pg_catalog.setval('transferred_rm_id_seq', 34, true);


SET search_path = main, pg_catalog;

--
-- Name: area_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY area
    ADD CONSTRAINT area_pkey PRIMARY KEY (id);


--
-- Name: classification_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classification
    ADD CONSTRAINT classification_pkey PRIMARY KEY (id);


--
-- Name: client_name_key; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_name_key UNIQUE (name);


--
-- Name: client_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: container_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY container
    ADD CONSTRAINT container_pkey PRIMARY KEY (id);


--
-- Name: equipment_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipment
    ADD CONSTRAINT equipment_pkey PRIMARY KEY (id);


--
-- Name: packaging_material_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY packaging_material
    ADD CONSTRAINT packaging_material_pkey PRIMARY KEY (id);


--
-- Name: product_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: raw_material_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY raw_material
    ADD CONSTRAINT raw_material_pkey PRIMARY KEY (id);


--
-- Name: unit_pkey; Type: CONSTRAINT; Schema: main; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY unit
    ADD CONSTRAINT unit_pkey PRIMARY KEY (id);


SET search_path = mbr, pg_catalog;

--
-- Name: bottle_and_cbox_page_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bottle_and_cbox_page
    ADD CONSTRAINT bottle_and_cbox_page_pkey PRIMARY KEY (id);


--
-- Name: compounding_procedure_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY compounding_procedure
    ADD CONSTRAINT compounding_procedure_pkey PRIMARY KEY (id);


--
-- Name: dosage_in_procedure_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dosage_in_procedure
    ADD CONSTRAINT dosage_in_procedure_pkey PRIMARY KEY (id);


--
-- Name: equipment_requirements_coding_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipment_requirements_coding
    ADD CONSTRAINT equipment_requirements_coding_pkey PRIMARY KEY (id);


--
-- Name: equipment_requirements_compounding_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipment_requirements_compounding
    ADD CONSTRAINT equipment_requirements_compounding_pkey PRIMARY KEY (id);


--
-- Name: equipment_requirements_encapsulation_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipment_requirements_encapsulation
    ADD CONSTRAINT equipment_requirements_encapsulation_pkey PRIMARY KEY (id);


--
-- Name: equipment_requirements_packaging_procedure_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipment_requirements_packaging_procedure
    ADD CONSTRAINT equipment_requirements_packaging_procedure_pkey PRIMARY KEY (id);


--
-- Name: manufacturing_procedure_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY manufacturing_procedure
    ADD CONSTRAINT manufacturing_procedure_pkey PRIMARY KEY (id);


--
-- Name: mbr_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbr
    ADD CONSTRAINT mbr_pkey PRIMARY KEY (id);


--
-- Name: pack_size_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pack_size
    ADD CONSTRAINT pack_size_pkey PRIMARY KEY (id);


--
-- Name: packaging_material_requirements_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY packaging_material_requirements
    ADD CONSTRAINT packaging_material_requirements_pkey PRIMARY KEY (id);


--
-- Name: packaging_procedure_operation_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY packaging_procedure_operation
    ADD CONSTRAINT packaging_procedure_operation_pkey PRIMARY KEY (id);


--
-- Name: packaging_procedure_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY packaging_procedure
    ADD CONSTRAINT packaging_procedure_pkey PRIMARY KEY (id);


--
-- Name: product_pack_size_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY product_pack_size
    ADD CONSTRAINT product_pack_size_pkey PRIMARY KEY (id);


--
-- Name: raw_material_requirements_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY raw_material_requirements
    ADD CONSTRAINT raw_material_requirements_pkey PRIMARY KEY (id);


--
-- Name: udf_pkey; Type: CONSTRAINT; Schema: mbr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY udf
    ADD CONSTRAINT udf_pkey PRIMARY KEY (id);


SET search_path = mmd_tolling, pg_catalog;

--
-- Name: issued_raw_material_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY issued_raw_material
    ADD CONSTRAINT issued_raw_material_pkey PRIMARY KEY (id);


--
-- Name: raw_material_request_entry_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY raw_material_request_entry
    ADD CONSTRAINT raw_material_request_entry_pkey PRIMARY KEY (id);


--
-- Name: raw_material_request_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY raw_material_request
    ADD CONSTRAINT raw_material_request_pkey PRIMARY KEY (id);


--
-- Name: raw_material_request_transaction_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY raw_material_request_transaction
    ADD CONSTRAINT raw_material_request_transaction_pkey PRIMARY KEY (id);


--
-- Name: received_packaging_material_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY received_packaging_material
    ADD CONSTRAINT received_packaging_material_pkey PRIMARY KEY (id);


--
-- Name: received_raw_material_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY received_raw_material
    ADD CONSTRAINT received_raw_material_pkey PRIMARY KEY (id);


--
-- Name: transaction_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id);


--
-- Name: transaction_type_description_subtype_key; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transaction_type
    ADD CONSTRAINT transaction_type_description_subtype_key UNIQUE (description, subtype);


--
-- Name: transaction_type_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transaction_type
    ADD CONSTRAINT transaction_type_pkey PRIMARY KEY (id);


--
-- Name: transferred_packaging_material_pkey; Type: CONSTRAINT; Schema: mmd_tolling; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY issued_packaging_material
    ADD CONSTRAINT transferred_packaging_material_pkey PRIMARY KEY (id);


SET search_path = rdr, pg_catalog;

--
-- Name: received_pm_pkey; Type: CONSTRAINT; Schema: rdr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY received_packaging_material
    ADD CONSTRAINT received_pm_pkey PRIMARY KEY (id);


--
-- Name: received_rm_pkey; Type: CONSTRAINT; Schema: rdr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY received_raw_material
    ADD CONSTRAINT received_rm_pkey PRIMARY KEY (id);


--
-- Name: transferred_pm_pkey; Type: CONSTRAINT; Schema: rdr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transferred_packaging_material
    ADD CONSTRAINT transferred_pm_pkey PRIMARY KEY (id);


--
-- Name: transferred_rm_pkey; Type: CONSTRAINT; Schema: rdr; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY transferred_raw_material
    ADD CONSTRAINT transferred_rm_pkey PRIMARY KEY (id);


SET search_path = main, pg_catalog;

--
-- Name: packaging_material_client_id_fkey; Type: FK CONSTRAINT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY packaging_material
    ADD CONSTRAINT packaging_material_client_id_fkey FOREIGN KEY (client_id) REFERENCES client(id);


--
-- Name: product_area_id_fkey; Type: FK CONSTRAINT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_area_id_fkey FOREIGN KEY (area_id) REFERENCES area(id);


--
-- Name: product_classification_id_fkey; Type: FK CONSTRAINT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_classification_id_fkey FOREIGN KEY (classification_id) REFERENCES classification(id);


--
-- Name: product_client_id_fkey; Type: FK CONSTRAINT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_client_id_fkey FOREIGN KEY (client_id) REFERENCES client(id);


--
-- Name: raw_material_classification_id_fkey; Type: FK CONSTRAINT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY raw_material
    ADD CONSTRAINT raw_material_classification_id_fkey FOREIGN KEY (classification_id) REFERENCES classification(id);


--
-- Name: raw_material_client_id_fkey; Type: FK CONSTRAINT; Schema: main; Owner: postgres
--

ALTER TABLE ONLY raw_material
    ADD CONSTRAINT raw_material_client_id_fkey FOREIGN KEY (client_id) REFERENCES client(id);


SET search_path = mbr, pg_catalog;

--
-- Name: bottle_and_cbox_page_bottle_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY bottle_and_cbox_page
    ADD CONSTRAINT bottle_and_cbox_page_bottle_id_fkey FOREIGN KEY (bottle_id) REFERENCES main.packaging_material(id);


--
-- Name: bottle_and_cbox_page_cbox_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY bottle_and_cbox_page
    ADD CONSTRAINT bottle_and_cbox_page_cbox_id_fkey FOREIGN KEY (cbox_id) REFERENCES main.packaging_material(id);


--
-- Name: bottle_and_cbox_page_product_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY bottle_and_cbox_page
    ADD CONSTRAINT bottle_and_cbox_page_product_id_fkey FOREIGN KEY (product_id) REFERENCES main.product(id);


--
-- Name: compounding_procedure_manufacturing_procedure_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY compounding_procedure
    ADD CONSTRAINT compounding_procedure_manufacturing_procedure_id_fkey FOREIGN KEY (manufacturing_procedure_id) REFERENCES manufacturing_procedure(id);


--
-- Name: dosage_in_procedure_compounding_procedure_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY dosage_in_procedure
    ADD CONSTRAINT dosage_in_procedure_compounding_procedure_id_fkey FOREIGN KEY (compounding_procedure_id) REFERENCES compounding_procedure(id);


--
-- Name: dosage_in_procedure_raw_material_requirements_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY dosage_in_procedure
    ADD CONSTRAINT dosage_in_procedure_raw_material_requirements_id_fkey FOREIGN KEY (raw_material_requirements_id) REFERENCES raw_material_requirements(id);


--
-- Name: dosage_in_procedure_unit_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY dosage_in_procedure
    ADD CONSTRAINT dosage_in_procedure_unit_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


--
-- Name: equipment_requirements_coding_equipment_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_coding
    ADD CONSTRAINT equipment_requirements_coding_equipment_id_fkey FOREIGN KEY (equipment_id) REFERENCES main.equipment(id);


--
-- Name: equipment_requirements_coding_manufacturing_procedure_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_coding
    ADD CONSTRAINT equipment_requirements_coding_manufacturing_procedure_id_fkey FOREIGN KEY (manufacturing_procedure_id) REFERENCES manufacturing_procedure(id);


--
-- Name: equipment_requirements_compound_manufacturing_procedure_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_compounding
    ADD CONSTRAINT equipment_requirements_compound_manufacturing_procedure_id_fkey FOREIGN KEY (manufacturing_procedure_id) REFERENCES manufacturing_procedure(id);


--
-- Name: equipment_requirements_compounding_equipment_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_compounding
    ADD CONSTRAINT equipment_requirements_compounding_equipment_id_fkey FOREIGN KEY (equipment_id) REFERENCES main.equipment(id);


--
-- Name: equipment_requirements_encapsul_manufacturing_procedure_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_encapsulation
    ADD CONSTRAINT equipment_requirements_encapsul_manufacturing_procedure_id_fkey FOREIGN KEY (manufacturing_procedure_id) REFERENCES manufacturing_procedure(id);


--
-- Name: equipment_requirements_encapsulation_equipment_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_encapsulation
    ADD CONSTRAINT equipment_requirements_encapsulation_equipment_id_fkey FOREIGN KEY (equipment_id) REFERENCES main.equipment(id);


--
-- Name: equipment_requirements_packaging_pr_packaging_procedure_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_packaging_procedure
    ADD CONSTRAINT equipment_requirements_packaging_pr_packaging_procedure_id_fkey FOREIGN KEY (packaging_procedure_id) REFERENCES packaging_procedure(id);


--
-- Name: equipment_requirements_packaging_procedure_equipment_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY equipment_requirements_packaging_procedure
    ADD CONSTRAINT equipment_requirements_packaging_procedure_equipment_id_fkey FOREIGN KEY (equipment_id) REFERENCES main.equipment(id);


--
-- Name: manufacturing_procedure_product_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY manufacturing_procedure
    ADD CONSTRAINT manufacturing_procedure_product_id_fkey FOREIGN KEY (product_id) REFERENCES main.product(id);


--
-- Name: mbr_product_with_pack_size_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY mbr
    ADD CONSTRAINT mbr_product_with_pack_size_fkey FOREIGN KEY (product_pack_size_id) REFERENCES product_pack_size(id);


--
-- Name: mbr_unit_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY mbr
    ADD CONSTRAINT mbr_unit_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


--
-- Name: pack_size_container_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY pack_size
    ADD CONSTRAINT pack_size_container_id_fkey FOREIGN KEY (container_id) REFERENCES main.container(id);


--
-- Name: pack_size_unit_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY pack_size
    ADD CONSTRAINT pack_size_unit_id_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


--
-- Name: packaging_material_requirements_packaging_material_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_material_requirements
    ADD CONSTRAINT packaging_material_requirements_packaging_material_id_fkey FOREIGN KEY (packaging_material_id) REFERENCES main.packaging_material(id);


--
-- Name: packaging_material_requirements_udf_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_material_requirements
    ADD CONSTRAINT packaging_material_requirements_udf_id_fkey FOREIGN KEY (udf_id) REFERENCES udf(id);


--
-- Name: packaging_material_requirements_unit_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_material_requirements
    ADD CONSTRAINT packaging_material_requirements_unit_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


--
-- Name: packaging_procedure_operation_product_pack_size_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_procedure_operation
    ADD CONSTRAINT packaging_procedure_operation_product_pack_size_id_fkey FOREIGN KEY (product_pack_size_id) REFERENCES product_pack_size(id);


--
-- Name: packaging_procedure_product_pack_size_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY packaging_procedure
    ADD CONSTRAINT packaging_procedure_product_pack_size_id_fkey FOREIGN KEY (product_pack_size_id) REFERENCES product_pack_size(id);


--
-- Name: product_pack_size_pack_size_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY product_pack_size
    ADD CONSTRAINT product_pack_size_pack_size_id_fkey FOREIGN KEY (pack_size_id) REFERENCES pack_size(id);


--
-- Name: product_pack_size_product_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY product_pack_size
    ADD CONSTRAINT product_pack_size_product_id_fkey FOREIGN KEY (product_id) REFERENCES main.product(id);


--
-- Name: raw_material_requirements_raw_material_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY raw_material_requirements
    ADD CONSTRAINT raw_material_requirements_raw_material_id_fkey FOREIGN KEY (raw_material_id) REFERENCES main.raw_material(id);


--
-- Name: raw_material_requirements_udf_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY raw_material_requirements
    ADD CONSTRAINT raw_material_requirements_udf_id_fkey FOREIGN KEY (udf_id) REFERENCES udf(id);


--
-- Name: raw_material_requirements_unit_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY raw_material_requirements
    ADD CONSTRAINT raw_material_requirements_unit_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


--
-- Name: udf_product_id_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY udf
    ADD CONSTRAINT udf_product_id_fkey FOREIGN KEY (product_id) REFERENCES main.product(id);


--
-- Name: udf_unit_fkey; Type: FK CONSTRAINT; Schema: mbr; Owner: postgres
--

ALTER TABLE ONLY udf
    ADD CONSTRAINT udf_unit_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


SET search_path = mmd_tolling, pg_catalog;

--
-- Name: issued_packaging_material_product_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_packaging_material
    ADD CONSTRAINT issued_packaging_material_product_id_fkey FOREIGN KEY (product_id) REFERENCES main.product(id);


--
-- Name: issued_packaging_material_received_packaging_material_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_packaging_material
    ADD CONSTRAINT issued_packaging_material_received_packaging_material_id_fkey FOREIGN KEY (received_packaging_material_id) REFERENCES received_packaging_material(id);


--
-- Name: issued_packaging_material_unit_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_packaging_material
    ADD CONSTRAINT issued_packaging_material_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


--
-- Name: issued_raw_material_product_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_raw_material
    ADD CONSTRAINT issued_raw_material_product_id_fkey FOREIGN KEY (product_id) REFERENCES main.product(id);


--
-- Name: issued_raw_material_received_raw_material_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_raw_material
    ADD CONSTRAINT issued_raw_material_received_raw_material_id_fkey FOREIGN KEY (received_raw_material_id) REFERENCES received_raw_material(id);


--
-- Name: issued_raw_material_unit_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY issued_raw_material
    ADD CONSTRAINT issued_raw_material_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


--
-- Name: raw_material_request_entry_raw_material_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_entry
    ADD CONSTRAINT raw_material_request_entry_raw_material_id_fkey FOREIGN KEY (raw_material_id) REFERENCES main.raw_material(id);


--
-- Name: raw_material_request_entry_raw_material_request_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_entry
    ADD CONSTRAINT raw_material_request_entry_raw_material_request_id_fkey FOREIGN KEY (raw_material_request_id) REFERENCES raw_material_request(id);


--
-- Name: raw_material_request_entry_unit_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_entry
    ADD CONSTRAINT raw_material_request_entry_unit_id_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


--
-- Name: raw_material_request_transact_raw_material_request_entry_i_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_transaction
    ADD CONSTRAINT raw_material_request_transact_raw_material_request_entry_i_fkey FOREIGN KEY (raw_material_request_entry_id) REFERENCES raw_material_request_entry(id);


--
-- Name: raw_material_request_transaction_received_raw_material_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_transaction
    ADD CONSTRAINT raw_material_request_transaction_received_raw_material_id_fkey FOREIGN KEY (received_raw_material_id) REFERENCES received_raw_material(id);


--
-- Name: raw_material_request_transaction_unit_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY raw_material_request_transaction
    ADD CONSTRAINT raw_material_request_transaction_unit_id_fkey FOREIGN KEY (unit_id) REFERENCES main.unit(id);


--
-- Name: received_packaging_material_packaging_material_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY received_packaging_material
    ADD CONSTRAINT received_packaging_material_packaging_material_id_fkey FOREIGN KEY (packaging_material_id) REFERENCES main.packaging_material(id);


--
-- Name: received_packaging_material_unit_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY received_packaging_material
    ADD CONSTRAINT received_packaging_material_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


--
-- Name: received_raw_material_raw_material_id_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY received_raw_material
    ADD CONSTRAINT received_raw_material_raw_material_id_fkey FOREIGN KEY (raw_material_id) REFERENCES main.raw_material(id);


--
-- Name: received_raw_material_unit_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY received_raw_material
    ADD CONSTRAINT received_raw_material_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


--
-- Name: transaction_unit_fkey; Type: FK CONSTRAINT; Schema: mmd_tolling; Owner: postgres
--

ALTER TABLE ONLY transaction
    ADD CONSTRAINT transaction_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


SET search_path = rdr, pg_catalog;

--
-- Name: received_packaging_material_unit_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY received_packaging_material
    ADD CONSTRAINT received_packaging_material_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


--
-- Name: received_pm_packaging_material_id_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY received_packaging_material
    ADD CONSTRAINT received_pm_packaging_material_id_fkey FOREIGN KEY (packaging_material_id) REFERENCES main.packaging_material(id);


--
-- Name: received_raw_material_unit_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY received_raw_material
    ADD CONSTRAINT received_raw_material_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


--
-- Name: received_rm_raw_material_id_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY received_raw_material
    ADD CONSTRAINT received_rm_raw_material_id_fkey FOREIGN KEY (raw_material_id) REFERENCES main.raw_material(id);


--
-- Name: transferred_pm_received_pm_id_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY transferred_packaging_material
    ADD CONSTRAINT transferred_pm_received_pm_id_fkey FOREIGN KEY (received_pm_id) REFERENCES received_packaging_material(id);


--
-- Name: transferred_raw_material_unit_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY transferred_raw_material
    ADD CONSTRAINT transferred_raw_material_unit_fkey FOREIGN KEY (unit) REFERENCES main.unit(id);


--
-- Name: transferred_rm_product_id_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY transferred_raw_material
    ADD CONSTRAINT transferred_rm_product_id_fkey FOREIGN KEY (product_id) REFERENCES main.product(id);


--
-- Name: transferred_rm_received_rm_id_fkey; Type: FK CONSTRAINT; Schema: rdr; Owner: postgres
--

ALTER TABLE ONLY transferred_raw_material
    ADD CONSTRAINT transferred_rm_received_rm_id_fkey FOREIGN KEY (received_rm_id) REFERENCES received_raw_material(id);


--
-- Name: main; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA main FROM PUBLIC;
REVOKE ALL ON SCHEMA main FROM postgres;
GRANT ALL ON SCHEMA main TO postgres;
GRANT ALL ON SCHEMA main TO PUBLIC;


--
-- PostgreSQL database dump complete
--


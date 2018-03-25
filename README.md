/*
 *  Project   : Cybernetic Proving Ground
 *
 *  Tool      : KYPO2 Sandbox Service
 *
 *  Author(s) : Norbert Fábián 396035@mail.muni.cz
 *
 *  Date      : 23.11.2017
 *
 *  (c) Copyright 2016 MASARYK UNIVERSITY
 *  All rights reserved.
 *
 *  This software is freely available for non-commercial use under license
 *  specified in following license agreement in LICENSE file. Please review the terms
 *  of the license agreement before using this software. If you are interested in
 *  using this software commercially orin ways not allowed in aforementioned
 *  license, feel free to contact Technology transfer office of the Masaryk university
 *  in order to negotiate ad-hoc license agreement.
 */

Installing by maven:

mvn install -Dpath.to.db.config.file={path/to/config/file}

The path must be set otherwise service will not be able to find properties for Hibernate.
The path is exact path to config file which should be on server, e.g. in folder /etc/
The file should have these properties:

----------------- examplpe of property file  ------------------------------------
```
#Database settings

# **************************************************
# ****************** Common props ******************
# **************************************************

jdbc.driverClassName = org.postgresql.Driver
hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
jdbc.username = postgres
jdbc.password = postgre

# **************************************************
# ************* Topology service props *************
# **************************************************

# default host is used, when no tenant is specified. For example during the start up.
topology.jdbc.defaultHost = localhost
topology.jdbc.dynamicUrl = jdbc:postgresql://{host}:5432/kypodb
topology.hibernate.show_sql = true
topology.hibernate.format_sql = true
#Must be true when using multi-tenant connection
topology.hibernate.enable_lazy_load_no_trans = true
#Must be none when using multi-tenant connection
topology.hibernate.hbm2ddl.auto = none

# **************************************************
# ************** KYPO management props *************
# **************************************************

jdbc.url = jdbc:postgresql://localhost:5432/dbmodel
hibernate.show_sql = true
hibernate.format_sql = true
hibernate.enable_lazy_load_no_trans = false
hibernate.hbm2ddl.auto = none
sandbox.api.server = kypo-devel.ics.muni.cz
sandbox.api.port = 5000
perun.use = true
```
The war file cannot be deployed through Liferay.
To deploy the service, copy the war file to the {tomcat-installation}/webapp.
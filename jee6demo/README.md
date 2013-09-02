1. nadanie praw plikom
chmod 755 ./scripts/*.sh
2. run HSQLDB server (TCP, in memory mode)
./scripts/runHSQLDBServer.sh
3. run HSQLDB GUI Client (optional but strongly recommended)
./scripts/runHSQLDBClient.sh
4. stop GlassFish if it's running (w eclipsie)
5. skopiowac hsqldb-2.2.4.jar do glassfish
cp ./scripts/hsqldb-2.2.4.jar /opt/devel/as/glassfish3/glassfish/domains/domain1/lib/ext/
6. Dodac w pliku na koniec <resource>
<jdbc-connection-pool driver-classname="" datasource-classname="org.hsqldb.jdbc.JDBCDataSource" res-type="javax.sql.DataSource" description="" name="HSQLPool" ping="true">
	<property name="DatabaseName" value="jdbc:hsqldb:hsql://localhost/workdb"></property>
	<property name="User" value="SA"></property>
	<property name="Password" value=""></property>
	<property name="connectionAttributes" value=";ifexists=true"></property>
</jdbc-connection-pool>
<jdbc-resource pool-name="HSQLPool" description="DataSource for demo apps with HSQLDB" jndi-name="jdbc/demoapps"></jdbc-resource>
7. odpalamy GlassFish
8. wchodzimy na http://localhost:4848
9. pingujemy SQL, jak nie dziala to spierdoliles(as)
10. wchodzimy w Update Tool i instalujemy hibrnate
11. resetujemy GlassFish i mozemy robic stronke
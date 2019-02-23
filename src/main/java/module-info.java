
module se.p950tes.publictransport.app {

	requires org.apache.commons.io;
	requires gson;
	requires java.sql;
	requires java.net.http;
	requires spring.web;
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.context;
	requires spring.beans;
	requires spring.core;
	opens se.p950tes.publictransport.app.repository.parsing;
	opens se.p950tes.publictransport.app.repository.parsing.ultypes;
	opens se.p950tes.publictransport.app.web;
}

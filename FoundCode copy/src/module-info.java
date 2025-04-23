module FoundationCode {
	requires javafx.controls;
	requires java.sql;
	requires jdk.incubator.vector;
	requires junit;
	requires org.junit.jupiter.api;
	requires com.h2database;
	
	opens application to javafx.graphics, javafx.fxml;
}

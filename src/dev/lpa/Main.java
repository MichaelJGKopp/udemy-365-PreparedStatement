package dev.lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
  
  public static void main(String[] args) {
  
    var dataSource = new MysqlDataSource();
    
    dataSource.setServerName("localhost");
    dataSource.setPort(3306);
    dataSource.setDatabaseName("music");
    
    try {
      dataSource.setContinueBatchOnError(false);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
    try (Connection connection = dataSource.getConnection(
      System.getenv("MYSQL_USER"),
      System.getenv("MYSQL_PASS"))) {

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

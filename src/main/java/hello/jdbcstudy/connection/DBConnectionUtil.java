package hello.jdbcstudy.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbcstudy.connection.ConnectionConst.*;
@Slf4j
public class DBConnectionUtil {
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // JDBC가 제공하는 라이브러리
            // DB 드라이버를 찾아서 해당 드라이버가 제공하는 커넥션을 반환해준다.
            log.info("connection={}, class={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package hello.jdbcstudy.connection;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

class DBConnectionUtilTest {

    @Test
    void connectionTest() {
        Connection connection = DBConnectionUtil.getConnection();
        assertThat(connection).isNotNull();
    }

}
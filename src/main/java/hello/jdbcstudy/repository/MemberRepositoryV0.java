package hello.jdbcstudy.repository;

import hello.jdbcstudy.connection.DBConnectionUtil;
import hello.jdbcstudy.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;


@Slf4j
public class MemberRepositoryV0 {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql); // 전달할 sql을 넣어준다.
            // ?에 바인딩하기
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate(); // 실행할 sql 전달
            return member;
        } catch (SQLException e) {
            log.error("db error");
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("rs close error");
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("stmt close error");
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("con close error");
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}

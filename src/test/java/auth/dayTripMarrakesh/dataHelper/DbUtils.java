package auth.dayTripMarrakesh.dataHelper;

import lombok.SneakyThrows;
import lombok.var;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {

    private static QueryRunner runner = new QueryRunner();

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection(System.getProperty("db.url"), "user", "password");
    }

    @SneakyThrows
    public static void cleanDB() {
        String credit = "DELETE FROM credit_request_entity";
        String order = "DELETE FROM order_entity";
        String payment = "DELETE FROM payment_entity";
        try (var conn = getConn()) {
            runner.execute(conn, credit);
            runner.execute(conn, order);
            runner.execute(conn, payment);
        }
    }

    @SneakyThrows
    public String getVerificationCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1;";
        var runner = new QueryRunner();

        try (var conn = getConn()) {
            var code = runner.query(conn, codeSQL, new ScalarHandler<String>());
            return String.valueOf(Integer.parseInt(code));
        }
    }
}
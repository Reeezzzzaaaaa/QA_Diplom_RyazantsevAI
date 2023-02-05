package auth.dayTripMarrakesh.dataHelper;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.*;

public class DbUtils {

    private static final QueryRunner runner = new QueryRunner();

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection(System.getProperty("db.url"), "app", "pass");
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
    public String getStatusEntity() {
        var statusSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        var runner = new QueryRunner();

        try (var conn = getConn()) {
            var status = runner.query(conn, statusSQL, new ScalarHandler<>());
            return (String) status;
        }
    }

    @SneakyThrows
    public String getAmountEntity() {
        var amountSQL = "SELECT amount FROM payment_entity ORDER BY created DESC LIMIT 1;";
        var runner = new QueryRunner();

        try (var conn = getConn()) {
            var amount = runner.query(conn, amountSQL, new ScalarHandler<>());
            return (String) amount;
        }
    }
}
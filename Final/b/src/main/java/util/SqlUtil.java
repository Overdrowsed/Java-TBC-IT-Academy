package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.InternalServerErrorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.Payment;
import wsdl.Transaction;

public class SqlUtil {
    private static final Logger logger = LogManager.getLogger("service_B");

    private static DataSource dataSource;
    private static Connection connection;

    static{
        try{
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/service_bDS");
            connection = dataSource.getConnection();
        }
        catch(NamingException exception){
            logger.fatal("Unable to find datasource");
        }
        catch(SQLException exception){
            logger.fatal("Unable to connect to the database");
        }
    }

    public static void storeTransaction(long systemTransactionId, Transaction transactionInfo, Timestamp requestDate, Timestamp responseDate, int code, int status) {
        try{
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO payments (payment_id, user_id, amount, tran_id, request_date, response_date, code, status)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            statement.setString(1, transactionInfo.getAgentTransactionId());
            statement.setInt(2, transactionInfo.getUserId());
            statement.setFloat(3, transactionInfo.getAmount());

            if(status == 0){
                statement.setLong(4, systemTransactionId);
            }
            else{
                statement.setNull(4, Types.BIGINT);
            }

            statement.setTimestamp(5, requestDate);
            statement.setTimestamp(6, responseDate);
            statement.setShort(7, (short) code);
            statement.setShort(8, (short) status);
                
            statement.executeUpdate();
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalServerErrorException();
        }
    }

    public static void updateRetriedTransaction(long systemTransactionId, String paymentId){
        try{
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE payments SET tran_id = ?, code = 200, status = 0 WHERE payment_id = ?"
            );

            statement.setLong(1, systemTransactionId);
            statement.setString(2, paymentId);

            statement.executeUpdate();
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalServerErrorException();
        }
    }

    public static List<Transaction> getRetriableTransactions() {
        try{
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM payments WHERE status = 1"
            );

            ResultSet result = statement.executeQuery();

            List<Transaction> payments = new ArrayList<>();

            while(result.next()){
                Transaction payment = new Transaction();

                payment.setAgentTransactionId(result.getString("payment_id"));
                payment.setUserId(result.getInt("user_id"));
                payment.setAmount(result.getFloat("amount"));

                payments.add(payment);
            }

            return payments;
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalServerErrorException();
        }
    }
    
    public static Payment getPayment(String paymentId){
        try{
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM payments WHERE payment_id = ?"
            );

            statement.setString(1, paymentId);

            ResultSet result = statement.executeQuery();

            if(result.next()){
                return new Payment(
                    result.getInt("user_id"),
                    result.getString("payment_id"),
                    result.getFloat("amount"),
                    result.getShort("code"),
                    result.getShort("status")
                );
            }
            else{
                return null;
            }
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalServerErrorException();
        }
    }

    //#region utility methods
    public static void refreshConnection(){
        try{
            if(connection == null || connection.isClosed()){
                connection = dataSource.getConnection();
            }
        }
        catch(SQLException exception){
            logger.fatal("Unable to connect to the database");
            throw new InternalServerErrorException();
        }
    }
    //#endregion
}


package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.Agent;
import beans.Transaction;
import beans.User;
import fault.AgentAccessDenied;
import fault.AgentAuthFailed;
import fault.InternalError;
import fault.TransactionNotFound;
import fault.UserNotFound;

public class SqlUtil {
    private static final Logger logger = LogManager.getLogger("service_A");

    private static DataSource dataSource;
    private static Connection connection;

    static{
        try{
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/service_aDS");
            connection = dataSource.getConnection();
        }
        catch(NamingException exception){
            logger.fatal("Unable to find datasource");
        }
        catch(SQLException exception){
            logger.fatal("Unable to connect to the database");
        }
    }

    public static void performPayment(int agentId, Transaction transactionInfo) throws UserNotFound, InternalError{
        try{
            connection.setAutoCommit(false);

            User user = getUser(transactionInfo.getUserId());
            
            PreparedStatement payStatement = connection.prepareStatement(
                "UPDATE users SET balance = balance + ? WHERE id = ?"
            );

            payStatement.setFloat(1, transactionInfo.getAmount());
            payStatement.setInt(2, user.getId());
            
            payStatement.executeUpdate();

            PreparedStatement insertTransactionStatement = connection.prepareStatement(
                "INSERT INTO transactions (agent_id, agent_tran_id, user_id, amount, date)" +
                "VALUES (?, ?, ?, ?, ?)"
            );

            insertTransactionStatement.setInt(1, agentId);
            insertTransactionStatement.setString(2, transactionInfo.getAgentTransactionId());
            insertTransactionStatement.setInt(3, transactionInfo.getUserId());
            insertTransactionStatement.setFloat(4, transactionInfo.getAmount());
            insertTransactionStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            insertTransactionStatement.executeUpdate();

            connection.commit();

            logger.info("Transaction successful");
        }
        catch(SQLException exception){
            try{
                connection.rollback();
            }
            catch(SQLException exception2){
                logger.fatal(exception2.getMessage());

                throw new InternalError();
            }
            
            logger.fatal(exception.getMessage());
            throw new InternalError();
        }
        finally{
            try{
                connection.setAutoCommit(true);
            }
            catch(SQLException exception){
                logger.fatal(exception.getMessage());
                throw new InternalError();
            }
        }
    }

    public static Agent getAgent(int id) throws AgentAuthFailed, AgentAccessDenied, InternalError {
        try{
            PreparedStatement statement = connection.prepareStatement(
                "SELECT id, password FROM agents WHERE id = ?"
            );

            statement.setInt(1, id);
            
            ResultSet agentResult = statement.executeQuery();

            if(agentResult.next()){
                return new Agent(
                    agentResult.getInt("id"),
                    agentResult.getString("password")
                );
            }
            else{
                throw new AgentAuthFailed();
            }
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalError();
        }
    }

    public static List<String> getAllowedIps(int agentId) throws AgentAccessDenied, InternalError{
        try{
            PreparedStatement statement = connection.prepareStatement(
                "SELECT allowed_ip FROM agent_access WHERE agent_id = ?"
            );
    
            statement.setInt(1, agentId);
    
            ResultSet allowedIpResult = statement.executeQuery();
    
            List<String> allowedIps = new ArrayList<>();
    
            while(allowedIpResult.next()){
                allowedIps.add(allowedIpResult.getString("allowed_ip"));
            }
    
            if(allowedIps.size() == 0){
                throw new AgentAccessDenied();
            }
    
            return allowedIps;
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalError();
        }
    }

    public static User getUser(int id) throws UserNotFound, InternalError{
        try{
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM users WHERE id = ?"
            );
    
            statement.setInt(1, id);
    
            ResultSet result = statement.executeQuery();
    
            if(result.next()){
                return new User(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("surname"),
                    result.getString("personal_id"),
                    result.getFloat("balance")
                );
            }
            else{
                logger.error("User with id {} not found", id);

                throw new UserNotFound();
            }
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalError();
        }
    }

    public static Transaction getTransaction(int agentId, String agentTransactionId) throws TransactionNotFound, InternalError {
        try{
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM transactions WHERE agent_id = ? AND agent_tran_id = ?"
            );

            statement.setInt(1, agentId);
            statement.setString(2, agentTransactionId);

            ResultSet result = statement.executeQuery();

            if(result.next()){
                return new Transaction(
                    result.getLong("sys_tran_id"),
                    result.getInt("agent_id"),
                    result.getInt("user_id"),
                    result.getString("agent_tran_id"),
                    result.getFloat("amount"),
                    result.getTimestamp("date")
                );
            }
            else{
                logger.error("Transaction with with agent id {} and agent transaction id {} not found", agentId, agentTransactionId);

                throw new TransactionNotFound();
            }
        }
        catch(SQLException exception){
            logger.fatal(exception.getMessage());

            throw new InternalError();
        }
    }

    //#region utility methods
    public static void refreshConnection() throws InternalError{
        try{
            if(connection == null || connection.isClosed()){
                connection = dataSource.getConnection();
            }
        }
        catch(SQLException exception){
            logger.fatal("Unable to connect to the database");
            throw new InternalError();
        }
    }
    //#endregion
}


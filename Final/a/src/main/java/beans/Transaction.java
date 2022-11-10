package beans;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {
    private transient long systemTransactionId;
    private transient int agentId;
    private int userId;
    private String agentTransactionId;
    private float amount;
    private transient Timestamp transactionDate;

    public Transaction(){}

    public Transaction(
        long systemTransactionId,
        int agentId,
        int userId,
        String agentTransactionId,
        float amount,
        Timestamp transactionDate
    ) {
        this.systemTransactionId = systemTransactionId;
        this.agentId = agentId;
        this.userId = userId;
        this.agentTransactionId = agentTransactionId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public long getSystemTransactionId() {
        return systemTransactionId;
    }

    public void setSystemTransactionId(long systemTransactionId) {
        this.systemTransactionId = systemTransactionId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAgentTransactionId() {
        return agentTransactionId;
    }

    public void setAgentTransactionId(String agentTransactionId) {
        this.agentTransactionId = agentTransactionId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Transaction))
            return false;
        Transaction other = (Transaction) obj;
        if (userId != other.userId)
            return false;
        if (agentTransactionId == null) {
            if (other.agentTransactionId != null)
                return false;
        } else if (!agentTransactionId.equals(other.agentTransactionId))
            return false;
        if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
            return false;
        return true;
    }
}

package beans;

import wsdl.Transaction;

public class Payment {
    private int userId;
    private String agentTransactionId;
    private float amount;
    private short code;

    public Payment(int userId, String agentTransactionId, float amount, short code) {
        this.userId = userId;
        this.agentTransactionId = agentTransactionId;
        this.amount = amount;
        this.code = code;
    }

    public Payment(Transaction transaction) {
        this.userId = transaction.getUserId();
        this.agentTransactionId = transaction.getAgentTransactionId();
        this.amount = transaction.getAmount();
        this.code = -1;
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

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Payment))
            return false;
        Payment other = (Payment) obj;
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

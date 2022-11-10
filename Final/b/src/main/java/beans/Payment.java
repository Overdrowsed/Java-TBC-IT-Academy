package beans;

import wsdl.Transaction;

public class Payment {
    private int userId;
    private String paymentId;
    private float amount;
    private short code;
    private short status;

    public Payment(int userId, String agentTransactionId, float amount, short code, short status) {
        this.userId = userId;
        this.paymentId = agentTransactionId;
        this.amount = amount;
        this.code = code;
        this.status = status;
    }

    public Payment(Transaction transaction) {
        this.userId = transaction.getUserId();
        this.paymentId = transaction.getAgentTransactionId();
        this.amount = transaction.getAmount();
        this.code = -1;
        this.status = -1;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAgentTransactionId() {
        return paymentId;
    }

    public void setAgentTransactionId(String agentTransactionId) {
        this.paymentId = agentTransactionId;
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

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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
        if (paymentId == null) {
            if (other.paymentId != null)
                return false;
        } else if (!paymentId.equals(other.paymentId))
            return false;
        if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Payment [userId=" + userId + ", paymentId=" + paymentId + ", amount=" + amount + "]";
    }
}

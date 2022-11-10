package ge.ufc.project.beans;

import com.google.gson.annotations.SerializedName;

public class Payment {
    @SerializedName("user_id")
    int userId;
    @SerializedName("payment_id")
    String paymentId;
    float amount;
    
    public Payment(int userId, String paymentId, float amount) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}

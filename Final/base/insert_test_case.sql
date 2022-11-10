connect 'jdbc:derby://localhost:1527/service_bDB';

INSERT INTO payments (payment_id, user_id, amount, tran_id, request_date, response_date, code, status) VALUES ('123', 1, 10, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 408, 1);
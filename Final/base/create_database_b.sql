connect 'jdbc:derby://localhost:1527/service_bDB;create=true';

CREATE TABLE payments (
  payment_id VARCHAR(255) PRIMARY KEY,
  user_id INT,
  amount DECIMAL(31,2),
  tran_id BIGINT,
  request_date TIMESTAMP,
  response_date TIMESTAMP,
  code SMALLINT,
  status SMALLINT,
  CHECK (status in (0, 1, 2))
);
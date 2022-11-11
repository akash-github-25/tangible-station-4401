package com.masai.service.payment;

import com.masai.bean.PayementDetails;
import com.masai.exception.PaymentsDetailsException;

public interface PaymentService {
public PayementDetails addPayement(PayementDetails payement) throws PaymentsDetailsException;
}

package com.masai.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.bean.PayementDetails;
import com.masai.exception.PaymentsDetailsException;
import com.masai.repository.PaymentsDetailsRepo;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
   public PaymentsDetailsRepo pr;
	@Override
	public PayementDetails addPayement(PayementDetails payment) throws PaymentsDetailsException {
		// TODO Auto-generated method stub
		PayementDetails v=pr.save(payment);
		if(v!=null) {
			return v;
		}else {
			throw new PaymentsDetailsException("payment failed");
		}
		
	}

}

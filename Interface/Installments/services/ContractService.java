package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

// ContractService cria cada parcela do contrato como um objeto. Ou seja, receba um contrato e divida esse contrato criando outro objeto que é cada parcela
public class ContractService {
	
	//private Contract contract;
	private PaymentService paymentService;
	
	private int months;
	
	public ContractService (PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void processContract(Contract contract, int months){
		double basicQuota = contract.getTotalValue() / months;
		
		for (int i=1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = paymentService.interest(basicQuota, i);
			double fee = paymentService.paymentFee(basicQuota + interest);
			double quota = basicQuota + interest + fee;
			contract.getInstallment().add(new Installment(dueDate, quota));
		}
	}
}

package services;
import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {
	
	// princípio da INVERSÃO DE CONTROLE: esta classe não controla a instância. Quem controla dá o new do objeto é outra classe (INJEÇÃO DE DEPENDÊNCIA).
	// declarar o tipo da interface
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService (OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	// instanciar parcelas em objeto dos contratos
	public void processContract(Contract contract, Integer months) {
		double basicQuota = contract.getTotalValue() / months; // parcela sem juros
		
		for (int i=1; i <= months; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i); // somar o juros 1% à parcela por mês
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota); // somar o juros 2% à parcela total por mês
			
			Date dueDate = addMonths(contract.getDate(), i); // adicionar i meses à data de vencimento a partir da data inicial. A cada iteração tenho que atualizar a data de vencimento do contrato
			contract.getInstallment().add(new Installment(dueDate, fullQuota)); // juntar a data de vencimento e juros final num objeto Contract
		}
		
		
	}
	
	// acrescentar meses a uma data
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance(); // obter contrato
		calendar.setTime(date); // salvar data atual
		
		calendar.add(Calendar.MONTH, N); // adicionar ao mês atual o número de meses da iteração atual
		return calendar.getTime(); // retornar data atual
	}
	
}

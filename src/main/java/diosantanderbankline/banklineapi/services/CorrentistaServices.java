package diosantanderbankline.banklineapi.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diosantanderbankline.banklineapi.dtos.CorrentistaDto;
import diosantanderbankline.banklineapi.model.Conta;
import diosantanderbankline.banklineapi.model.Correntista;
import diosantanderbankline.banklineapi.repository.CorrentistaRepository;

//Service é a camada de toda a regra de negócio da aplicacao
//Vai ser um componente do tipo service @Service
//Set determina e o get recebe a informação
@Service
public class CorrentistaServices {
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(CorrentistaDto correntistaDto) {
		Correntista correntista = new Correntista();
		correntista.setCpf(correntistaDto.getCpf( ));
		correntista.setNome(correntistaDto.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		correntista.setConta(conta);
		correntistaRepository.save(correntista);
		
	}

	public void delete(Integer id) {
		correntistaRepository.deleteById(id);
		
	}
}


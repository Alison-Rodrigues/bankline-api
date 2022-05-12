package diosantanderbankline.banklineapi.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diosantanderbankline.banklineapi.dtos.MovimentacaoDto;
import diosantanderbankline.banklineapi.model.Correntista;
import diosantanderbankline.banklineapi.model.Movimentacao;
import diosantanderbankline.banklineapi.model.MovimentacaoTipo;
import diosantanderbankline.banklineapi.repository.CorrentistaRepository;
import diosantanderbankline.banklineapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(MovimentacaoDto movimentacaoDto) {
		Movimentacao movimentacao = new Movimentacao();
		Double valor = movimentacaoDto.getValor();
		if(movimentacaoDto.getTipo() == MovimentacaoTipo.DESPESA)
			valor = valor * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(movimentacaoDto.getDescricao());
		movimentacao.setValor(valor);
		movimentacao.setId_conta(movimentacaoDto.getId_conta());
		movimentacao.setTipo(movimentacaoDto.getTipo());
		
		Correntista correntista = correntistaRepository.findById(movimentacaoDto.getId_conta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		movimentacaoRepository.save(movimentacao);
		
	}

	public void deleleById(Integer id) {
		movimentacaoRepository.deleteById(id);
		
	}
}

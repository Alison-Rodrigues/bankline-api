package diosantanderbankline.banklineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diosantanderbankline.banklineapi.dtos.MovimentacaoDto;
import diosantanderbankline.banklineapi.model.Movimentacao;
import diosantanderbankline.banklineapi.repository.MovimentacaoRepository;
import diosantanderbankline.banklineapi.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping
	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody MovimentacaoDto movimentacaoDto) {
		movimentacaoService.save(movimentacaoDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		movimentacaoService.deleleById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}

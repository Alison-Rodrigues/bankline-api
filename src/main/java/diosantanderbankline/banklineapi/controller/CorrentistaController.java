package diosantanderbankline.banklineapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diosantanderbankline.banklineapi.dtos.CorrentistaDto;
import diosantanderbankline.banklineapi.model.Correntista;
import diosantanderbankline.banklineapi.repository.CorrentistaRepository;
import diosantanderbankline.banklineapi.services.CorrentistaServices;

//Mapeamento dos métodos
@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	@Autowired
	private CorrentistaServices correntistaServices;
	
	//retorna todos os dados do banco
	@GetMapping
	public List<Correntista> findAll() {
		return correntistaRepository.findAll();
	}
	
	//retorna informações do banco a partir de um id
	@GetMapping("/{id}")
	public Optional<Correntista> findById(@PathVariable Integer id) {
		return correntistaRepository.findById(id);
	}
	
	//cria novos registros no banco
	//Passa um novo correntista como parâmetro
	@PostMapping
	public void save(@RequestBody CorrentistaDto correntista) {
		 correntistaServices.save(correntista);
	}
	
	//deleta um correntista a partir do id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		correntistaServices.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}

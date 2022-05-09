package diosantanderbankline.banklineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diosantanderbankline.banklineapi.model.Correntista;

//Salva os correntista

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}

package diosantanderbankline.banklineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diosantanderbankline.banklineapi.model.Correntista;

//Salva os correntista

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}

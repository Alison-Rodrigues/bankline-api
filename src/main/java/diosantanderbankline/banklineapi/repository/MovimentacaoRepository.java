package diosantanderbankline.banklineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diosantanderbankline.banklineapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}

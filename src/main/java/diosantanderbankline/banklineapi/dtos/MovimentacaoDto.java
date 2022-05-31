package diosantanderbankline.banklineapi.dtos;


import diosantanderbankline.banklineapi.model.MovimentacaoTipo;

//criação de novas movimentações
public class MovimentacaoDto {
	private String descricao;
	private Double valor;
	private Integer id_conta;
	private MovimentacaoTipo tipo;
	
	//getters and setters 
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getId_conta() {
		return id_conta;
	}
	public void setId_conta(Integer id_conta) {
		this.id_conta = id_conta;
	}
	public MovimentacaoTipo getTipo() {
		return tipo;
	}
	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}
	
	
}

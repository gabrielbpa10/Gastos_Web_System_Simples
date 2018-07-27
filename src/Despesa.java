import java.sql.Date;

public class Despesa {

	private Integer id;
	private String nome;
	private double valor;
	private Date data_dia;

	
	
	@Override
	public String toString() {
		return "Despesa [id=" + id + ", nome=" + nome + ", valor=" + valor + ", data_dia=" + data_dia + "]";
	}
	public Date getData_dia() {
		return data_dia;
	}
	public void setData_dia(Date data_dia) {
		this.data_dia = data_dia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}

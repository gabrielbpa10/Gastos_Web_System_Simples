import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@ViewScoped
public class DespesaBean {

	private static String CADASTRANDO = "CADASTRANDO";
	private static String EDITANDO = "EDITANDO";
	private static String SEARCHING = "SEARCHING";
	
	private DespesaDao despesaDao;
	private Despesa despesa;
	private List<Despesa> despesas;
	private String state;
	private String parametro;
	@PostConstruct
	public void init() {
		despesaDao = new DespesaDao();
		despesa = new Despesa();
		despesas = despesaDao.getDespesas();
		state = SEARCHING;
	}
	
	public List<Despesa> getDespesas(){
		return despesas;
	}
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public void salvar() {
		despesaDao.salvar(despesa);
		despesa = new Despesa();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Remédio salvo com sucesso!") );
	}
	
	public void prepareSave() {
		despesa = new Despesa();
		state = CADASTRANDO;
	}
	
	public void prepareUpdate(Despesa despesas) {
		setDespesa( despesas);
		state = EDITANDO;
	}
	public void filtro(Despesa despesas) {//Filtro
		despesaDao.getDespesas2(parametro);
	}
	
	public void remover(Despesa despesa) {
		despesaDao.remover(despesa.getId());
		setDespesas(despesaDao.getDespesas());
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Remédio removido com sucesso!") );
	}
	
	public void editar() {
		despesaDao.editar(despesa);
		state = SEARCHING;
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Remédio atualizado com sucesso!") );
	}
	
	public boolean isCadastrando() {
		return state.equals(CADASTRANDO);
	}
	
	public boolean isEditando() {
		return state.equals(EDITANDO);
	}
	
	public boolean isSearching() {
		return state.equals(SEARCHING);
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}

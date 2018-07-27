
public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Despesa d = new Despesa();
		DespesaDao dao = new DespesaDao();
		
		dao.remover(1);
		
		System.out.println(dao.getDespesas());


	}

}

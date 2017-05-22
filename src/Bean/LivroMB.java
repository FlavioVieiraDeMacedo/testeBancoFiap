package Bean;

import javax.faces.bean.ManagedBean;
import DAO.LivroDAO;
import Model.Livro;

@ManagedBean
public class LivroMB {
	private Livro livro;
	public LivroMB(){
		livro=new Livro();
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public String abrirCadastroIncluir(){
			return "cadastro";
	}
public String incluir(){
		livro.setId(0);
		livro.setNome("flavio");;
		livro.setDescricao("testeee");;
		try{
			LivroDAO dao = new LivroDAO();
			dao.insert(livro);
			
			return null;
		}
		catch(Exception e){
			//erro = e.getMessage();
			return "erro";
		}
	}
	/*
	public String listar(){
		try{
			LivroDAO dao = new LivroDAO();
			listaLivros = dao.getAll();
			
			return "visualizar";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}*/
}

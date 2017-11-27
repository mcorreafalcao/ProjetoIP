package pacoteClassesProduto;

import pacoteClassesUsuario.Usuario;

public class Demo extends Produto {
	
	public Demo(String nome, String descricao, Usuario dev) {
		super(nome, descricao, dev);
		
	}

	@Override
	public String getInfo() {
		String info = "Tísulo: "+this.getNome()+
				"\nDescrição: "+this.getDescricao()+
				"\nDesenvolvedor: "+this.getDev().getNick()+
				"\n(Demo Gratuita)\n";
		
		return info;
	}

	@Override
	public String rodar(Usuario usuarioLogado) {
		return "Voce jogou a demo: " + this.getNome();
	}

	

}

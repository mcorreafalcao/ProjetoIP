package pacoteClassesProduto;

import pacoteExcecoes.PJCException;
import pacoteExcecoes.PNCException;
import pacoteExcecoes.SMPCException;

/**
 * "Interface negocio-dados". Interface implementada em RepositrioUsuariosJogos
 * e RepositorioUsuariosJogos.
 * 
 * @author Gabriel
 *
 */
public interface RepositorioProdutos {// interface negocio_dados
	public void inserir(Produto produto) throws PJCException, SMPCException;

	public void remover(String nomeProduto) throws PNCException;

	public void atualizar(Produto produto) throws PNCException;

	public boolean existe(String nomeProduto);
	
	public String listarProdutos();
}

package br.com.cotiinformatica.entities;

public class Contato {

	private Integer idContato;
	private String nome;
	private String telefone;
	private String email;
	private String observacoes;
	private Integer idUsuario;
	private Usuario usuario; // composição

	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public Contato(Integer idContato, String nome, String telefone, String email, String observacoes, Integer idUsuario,
			Usuario usuario) {
		super();
		this.idContato = idContato;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.observacoes = observacoes;
		this.idUsuario = idUsuario;
		this.usuario = usuario;
	}

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", observacoes=" + observacoes + ", idUsuario=" + idUsuario + ", usuario=" + usuario + "]";
	}

}

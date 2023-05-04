<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agenda de Contatos</title>
  
  <!-- Incluindo o componente para controle de cache -->
  <jsp:include page="/WEB-INF/views/components/cache-control.jsp"/>
  
  <!-- Adicionar os arquivos CSS do Bootstrap -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css"/>
  
  <!-- Adicionar o arquivo CSS para o JQuery DataTables -->
  <link rel="stylesheet" href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"/>

</head>
<body>
  
  <!-- Incluindo o componente navbar -->
  <jsp:include page="/WEB-INF/views/components/navbar.jsp"/>

  <!-- Cards -->
  <div class="container mt-4">
  
  	<div class="mt-4 mb-4">
  	
  		<h5>Consulta de Contatos</h5>
  		<p>Listagem de contatos cadastrados em sua agenda</p>
  		<hr/>
  		
  		<div class="text-success mb-2">
      		<h5>${mensagem_sucesso}</h5>
      	</div>
      	
      	<div class="text-danger mb-2">
      		<h5>${mensagem_erro}</h5>
      	</div>
  		
  		<div class="table-responsive">
  		
  			<%@page import="br.com.cotiinformatica.entities.Contato" %>
  			<%@page import="java.util.List" %>
  			<%
  				List<Contato> contatos = (List<Contato>) request.getAttribute("contatos");
  			%>
  		
  			<table id="tabela-contatos" class="table table-sm">
  				<thead>
  					<tr>
  						<th>Nome do contato</th>
  						<th>Telefone</th>
  						<th>Email</th>
  						<th>Observações</th>
  						<th>Operações</th>
  					</tr>
  				</thead>
  				<tbody>
  				
  					<% for(Contato contato : contatos) { %>
  				
  					<tr>
  						<td><%= contato.getNome() %></td>
  						<td><%= contato.getTelefone() %></td>
  						<td><%= contato.getEmail() %></td>
  						<td><%= contato.getObservacoes() %></td>
  						<td>
  							<a href="/agendacontatos/admin/edicao-contatos?id=<%= contato.getIdContato() %>" 
  								class="btn btn-outline-primary btn-sm">
  								Editar
  							</a>
  							<a href="/agendacontatos/admin/exclusao-contatos?id=<%= contato.getIdContato() %>"
  								onclick="return confirm('Deseja realmente excluir o contato selecionado?');" 
  								class="btn btn-outline-danger btn-sm">
  								Excluir
  							</a>
  						</td>
  					</tr>
  					
  					<% } %>
  					
  				</tbody>
  			</table>
  		
  		</div>
  		
  	</div>
  	
  </div>  
    
  <!-- Adicionar os arquivos JavaScript do Bootstrap -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.min.js"></script>
  
  <!-- Adicionar os arquivos JavaScript do JQuery -->
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  <script src="//cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
  
  <script>
  
  	$(document).ready(function(){
  		$("#tabela-contatos").DataTable({
  			language: {
  		        url: '//cdn.datatables.net/plug-ins/1.13.4/i18n/pt-BR.json'
  		    }
  		});
  	})
  
  </script>
  
 </body>
 </html>
 
 
 
 
 
 
 
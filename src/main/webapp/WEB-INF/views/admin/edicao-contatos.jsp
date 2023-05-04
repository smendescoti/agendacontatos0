<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agenda de Contatos</title>
  
  <!-- Incluindo o componente para controle de cache -->
  <jsp:include page="/WEB-INF/views/components/cache-control.jsp"/>
  
  <!-- Adiciona os arquivos CSS do Bootstrap -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css"/>

</head>
<body>
  
  <!-- Incluindo o componente navbar -->
  <jsp:include page="/WEB-INF/views/components/navbar.jsp"/>

  <!-- Cards -->
  <div class="container mt-4">
  
  	<div class="mt-4 mb-4">
  	
  		<h5>Edição de Contatos</h5>
  		<p>Utilize o formulário para alterar os dados de um contato em sua agenda.</p>
  		<hr/>
  		
  		<div class="text-success mb-2">
      		<h5>${mensagem_sucesso}</h5>
      	</div>
      	
      	<div class="text-danger mb-2">
      		<h5>${mensagem_erro}</h5>
      	</div>
  		
  		<form method="post" action="atualizar-contato">
  		
  			<!-- campo oculto -->
  			<input type="hidden" name="idContato" value="${contato.idContato}"/>
  		
  			<div class="mb-2 row">
  				<div class="col-md-6">
  					<label>Nome do contato:</label>
  					<input type="text"
  						name="nome"
  						class="form-control"
  						placeholder="Digite o nome do contato"
  						pattern="[A-Za-zÀ-Üà-ü\s]{8,150}"
            			title="Por favor, informe um nome válido de 8 a 100 caracteres."
  						required
  						value="${contato.nome}"
  					/>
  				</div>
  				<div class="col-md-3">
  					<label>Email:</label>
  					<input type="email"
  						name="email"
  						class="form-control"
  						placeholder="Digite o email do contato"
  						required
  						value="${contato.email}"
  					/>
  				</div>
  				<div class="col-md-3">
  					<label>Telefone:</label>
  					<input type="text"
  						name="telefone"
  						class="form-control"
  						placeholder="Digite o telefone do contato"
  						pattern="[0-9]{11,20}"
            			title="Por favor, informe somente números."
  						required
  						value="${contato.telefone}"
  					/>
  				</div>
  			</div>
  			
  			<div class="mb-2 row">
  				<div class="col-md-12">
  					<label>Observações do contato</label>
  					<textarea name="observacoes" 
  						class="form-control"
  						placeholder="Digite as observações do contato"
            			title="Por favor, informe as observações de 8 a 250 caracteres."
  						required>${contato.observacoes}</textarea>
  				</div>
  			</div>
  			
  			<div class="mb-2 row">
  				<div class="col-md-12">
  					<input type="submit" class="btn btn-primary" value="Salvar Alterações"/>
  					<a href="/agendacontatos/admin/consulta-contatos" class="btn btn-light">
  						Voltar para a consulta
  					</a>
  				</div>
  			</div>
  		
  		</form>
  		
  	</div>
  	
  </div>  
    
  <!-- Adiciona os arquivos JavaScript do Bootstrap -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.min.js"></script>

 </body>
 </html>
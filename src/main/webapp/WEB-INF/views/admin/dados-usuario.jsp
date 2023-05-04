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
  	
  		<h5>Dados do Usuário</h5>
  		<p>Informações do usuário autenticado.</p>
  		<hr/>
  		
  		<table class="table table-sm table-bordered">
  			<thead>
  				<tr>
  					<th>Código</th>
  					<th>Nome do usuário</th>
  					<th>Email</th>
  				</tr>
  			</thead>
  			<tbody>
  				<tr>
  					<td>${usuario.idUsuario}</td>
  					<td>${usuario.nome}</td>
  					<td>${usuario.email}</td>
  				</tr>
  			</tbody>
  		</table>
  		      	
      	<h5 class="mt-3">Alterar Senha de acesso</h5>
      	
      	<div class="text-success mb-2">
      		<h5>${mensagem_sucesso}</h5>
      	</div>
      	
      	<div class="text-danger mb-2">
      		<h5>${mensagem_erro}</h5>
      	</div>
  		
  		<form method="post" action="alterar-senha" onsubmit="return validarSenhas()">
  		
  			<div class="mt-2 mb-2 row">
  				<div class="col-md-3">
  					<label>Nova senha:</label>
  					<input type="password"
  						id="novaSenha"
  						name="novaSenha"
  						class="form-control"
  						placeholder="Digite a nova senha"
  						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}"
            			title="A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial. Além disso, deve ter de 8 a 16 caracteres."
            			required 
  					/>
  				</div>
  				<div class="col-md-3">
  					<label>Confirme a nova senha:</label>
  					<input type="password"
  						id="novaSenhaConfirmacao"
  						name="novaSenhaConfirmacao"
  						class="form-control"
  						placeholder="Confirme a nova senha"
            			required 
  					/>
  				</div>
  			</div>  			
  		  			
  			<div class="mb-2 row">
  				<div class="col-md-12">
  					<input type="submit" class="btn btn-success" value="Alterar Senha de acesso"/>
  				</div>
  			</div>
  		
  		</form>
  		
  	</div>
  	
  </div>  
    
  <!-- Adiciona os arquivos JavaScript do Bootstrap -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.min.js"></script>
  
  <!-- Bloco de código JavaScript -->
  <script>
  	function validarSenhas() {
  		
  		//capturar o campo 'novaSenha'
  		var novaSenha = document.getElementById('novaSenha');
  		
  		//capturar o campo 'novaSenhaConfirmacao'
  		var novaSenhaConfirmacao = document.getElementById('novaSenhaConfirmacao');
  		
  		//verificar se as senhas estão iguais
  		if(novaSenha.value == novaSenhaConfirmacao.value) {
  			return true;
  		}
  		else {
  			alert('Senhas não conferem, por favor verifique.');
  			return false;
  		}
  	}
  </script>

 </body>
 </html>
 
 
 
 
 
 
 
 
 
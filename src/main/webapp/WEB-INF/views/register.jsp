<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Criar Conta - Agenda de Contatos</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css">
</head>
<body class="bg-secondary">
  <div class="container col-md-4 col-offset-4 mt-5">
    <div class="card">
      <div class="card-header">
        <h3 class="text-center">Agenda de Contatos</h3>
        <h5 class="text-center">Cria sua conta de usuário</h5>
      </div>
      <div class="card-body">
      	<p class="text-center">
      		Para criar sua conta de usuário na agenda de contatos,<br/>preencha todos os campos abaixo:
      	</p>
      	<hr/>
      	
      	<div class="text-success text-center">
      		<h5>${mensagem_sucesso}</h5>
      	</div>
      	
      	<div class="text-danger text-center">
      		<h5>${mensagem_erro}</h5>
      	</div>
      	
        <form method="post" action="cadastrar-usuario">
        
        <div class="mb-3">
            <label for="nome" class="form-label">
            	Entre com o seu nome:
            </label>
            <input 
            	type="text" 
            	class="form-control" 
            	id="nome" 
            	name="nome" 
            	pattern="[A-Za-zÀ-Üà-ü\s]{8,150}"
            	title="Por favor, informe um nome válido de 8 a 150 caracteres."
            	required 
            	/>
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">
            	Entre com o seu email:
            </label>
            <input 
            	type="email" 
            	class="form-control" 
            	id="email" 
            	name="email" 
            	required 
            	/>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">
            	Entre com a sua senha:
            </label>
            <input 
            	type="password" 
            	class="form-control" 
            	id="senha" 
            	name="senha" 
            	pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}"
            	title="A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial. Além disso, deve ter de 8 a 16 caracteres."
            	required 
            	/>
          </div>
          <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary">
            	Realizar Cadastro
            </button>
          </div>
          
        </form>
        
        <div class="text-center mt-3">
          <a href="/agendacontatos/">Voltar para página inicial</a>
        </div>
        <div class="mt-2 mb-1 text-center">
    		<small>COTI Informática - Java WebDeveloper</small>
      	</div>
      </div>      
    </div>    
  </div>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
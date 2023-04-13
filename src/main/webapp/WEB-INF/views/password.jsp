<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Esqueci minha senha - Agenda de Contatos</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css">
</head>
<body class="bg-secondary">
  <div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card">
      <div class="card-header">
        <h3 class="text-center">Agenda de Contatos</h3>
        <h5 class="text-center">Esqueci minha senha</h5>
      </div>
      <div class="card-body">
      	<p class="text-center">
      		Para recuperar sua senha de usuário, preencha os campos:
      	</p>
      	<hr/>
        <form>
          <div class="mb-3">
            <label for="email" class="form-label">Entre com o seu email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
          </div>
          <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary">Realizar Recuperação da Senha</button>
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
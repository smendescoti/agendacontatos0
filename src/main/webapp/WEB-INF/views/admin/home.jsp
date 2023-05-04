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
  		<h5>Seja bem vindo a agenda de contatos!</h5>
  		<p>Acesse a opção desejada</p>
  	</div>
  
    <div class="row">
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Cadastrar Contatos</h5>
            <p class="card-text">Clique aqui para cadastrar novos contatos.</p>
            <a href="/agendacontatos/admin/cadastro-contatos" class="btn btn-outline-primary">Acessar</a>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Consultar Contatos</h5>
            <p class="card-text">Clique aqui para consultar os contatos já cadastrados.</p>
            <a href="/agendacontatos/admin/consulta-contatos" class="btn btn-outline-primary">Acessar</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Adiciona os arquivos JavaScript do Bootstrap -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.min.js"></script>

 </body>
 </html>
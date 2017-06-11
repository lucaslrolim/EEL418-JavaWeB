<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="site da disciplina EEL418 - temática CAD" content="">
    <meta name="Lucas Rolim" content="">
    <title>Sistema CAD</title>

    <!-- CSS padrão do Bootstrap-->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- CSS customizado -->
    <link href="css/customStyles.css" rel="stylesheet">


  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">CAD -  Sistema de Automação Doméstico</a>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="/EEL418-CAD/">Minha casa</a></li>
            <li><a href="/EEL418-CAD/rooms.jsp">Meus ambientes</a></li>
            <li class="active"><a href="/EEL418-CAD/devices.jsp">Meus dispositivos <span class="sr-only">(current)</span></a></li>
          </ul>
        </div>

        <div class="col-sm-1 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Cadastrar Dispositivo</h1>
        </div>


          <div class="row">

    <div class="col-md-4 col-md-offset-4">
      <form class="form-horizontal" role="form" method="GET" action="controller">
              <input type="hidden"
                   name="handlerName"
                   value="Handlers.DevicesHandler" />
        <fieldset>

          <!-- Form Name -->


          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">Nome</label>
            <div class="col-sm-10">
              <input type="text" placeholder="Nome do dispositivo" class="form-control" name="device_name" >
              <input type="text" placeholder="ID do ambiente" class="form-control" name="device_roomId" >
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <div class="pull-right">
                <button type="submit" name="action" value= "register" class="btn btn-primary">Cadastrar ambiente</button>
                <button type="submit" name="action" value= "reload" class="btn btn-success">Atualizar tabela</button>
              </div>
            </div>
          </div>

        </fieldset>
      </form>
    </div><!-- /.col-lg-12 -->
    <div style="margin-left:200px;">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Ambiente</th>
            <th class="text-center">Ações</th>
        </tr>
    </thead>
<c:forEach var="current" items="${sessionScope.devicesList}" >
<tr>
        <td>${current.getId()}</td>
        <td>${current.getName()}</td>
        <td>${current.getrId()}</td>
              <form class="form-horizontal" role="form" method="GET" action="controller">
              <input type="hidden"
                   name="handlerName"
                   value="Handlers.DevicesHandler" />
        <td> <center><button type="submit" name="action" value="${current.getId()}" class="btn btn-danger">Deletar</button> </center></td>
              </form>
</tr>       
 </c:forEach>

    </table>
    </div>
 <div class="col-md-4 col-md-offset-3  ">     
 <form class="form-horizontal" role="form" method="GET" action="controller">
              <input type="hidden"
                   name="handlerName"
                   value="Handlers.DevicesHandler" />
          <div class="form-group">
            <label class="col-sm-1 control-label" for="textinput">ID</label>
            <div class="col-sm-4">
              <input type="text" placeholder="ID do dispositivo" class="form-control" name="idToChange">
            </div>

            <label class="col-sm-3 control-label" for="textinput">Novo Nome</label>
            <div class="col-sm-4">
              <input type="text" placeholder="Novo nome" class="form-control" name="newName">
            </div>
          </div>
              <center><button type="submit" name="action" value= "edit" class="btn btn-warning">Alterar nome</button></center>
      </form>
</div>
</div>
</div><!-- /.row -->
      </div>
    </div>
</div><!-- /.row -->
      </div>
    </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
       
       <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  </head>

  <body>

  <!-- Trecho que adiciona uma barra de navegação com o título do projeto no topo da página -->
  <!-- Usamos a subclasse navbar inverse para deixar ela preta, ao contrário do branco padrão do Bootstrap -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">CAD -  Sistema de Automação Doméstico</a>
        </div>
    </nav>

    <!-- Para a exibição do conteúdo usamos a div de classe conteiner-fluid. Essa div faz com que o conteúdo ocupe por todo espaço disponível na viewport-->

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="/EEL418-CAD/">Minha casa <span class="sr-only">(current)</span></a></li>
            <li><a href="/EEL418-CAD/rooms.jsp">Meus ambientes</a></li>
            <li><a href="/EEL418-CAD/devices.jsp">Meus dispositivos</a></li>
          </ul>
        </div>
          
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">${sessionScope.homeName}</h1>
        <form class="form-horizontal" role="form" method="GET" action="controller">
                          <input type="hidden"
                   name="handlerName"
                   value="Handlers.SelectionHandler" />
          <!-- Select Basic -->
          <div class="form-group">
            <label class="col-md-4 control-label" for="roomName">Ambiente</label>
            <div class="col-md-4">
              <select id="selectRoom" name="selectRoom" class="form-control" onchange="submit()">
                  <option selected="selected"> ${sessionScope.roomName}</option>
                  <c:forEach var="current" items="${sessionScope.roomsList}" > 
                      <option value = "${current.getId()}">${current.getName()}</option>
                  </c:forEach>
              </select>
            </div>
          </div>

          <!-- Select Basic -->
          <div class="form-group">
            <label class="col-md-4 control-label" name="deviceName">Dispositivo</label>
            <div class="col-md-4">
              <select id="selectbasicCountry" name="deviceName" class="form-control">
                <c:forEach var="current" items="${sessionScope.roomDevices}" > 
                      <option>${current.getName()}</option> 
                  </c:forEach>
              </select>
            </div>
          </div>
          </fieldset>
          </form>
          <form class="form-horizontal" role="form" method="GET" action="controller">
                          <input type="hidden"
                   name="handlerName"
                   value="Handlers.ObjectsHandler" />
          <label class="col-md-4 control-label" for="buttonSelect"></label>
            <div class="col-md-8">
              <button id="buttonSelect" name="buttonSelect" class="btn btn-info">Controlar</button>
            </div>
          </div>                          
              
          </form>       
       
        </div>

     
 <form class="form-horizontal" role="form" method="GET" action="controller">
              <input type="hidden"
                   name="handlerName"
                   value="Handlers.IndexHandler" />
            <label class="col-sm-4 control-label" for="textinput">Alterar nome da casa</label>
            <div class="col-sm-4">
              <input type="text" placeholder="Novo nome" class="form-control" name="newName">
            </div>
          </div>
          <br></br>
              <center><button type="submit" name="action" value= "edit" class="btn btn-warning">Alterar nome</button></center>
      </form>

      </div>
        
    </div>
    sss
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/custom.js"></script>
  </body>
</html>
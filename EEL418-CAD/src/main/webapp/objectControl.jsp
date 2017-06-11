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
       
       <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  </head><p><i class="icon-camera-retro icon-large"></i> icon-camera-retro</p>

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
          <h1 class="page-header">Controlar ${sessionScope.deviceName} no ambiente ${sessionScope.roomName}</h1>
          
 <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-cogs fa-2x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div>Controlar X</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">Controlar</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                             <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-exchange fa-2x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div>Alterar Y</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">Controlar</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                             <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-wrench fa-2x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div>Mudar Z</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">Controlar</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
          <div class="col-lg-3 col-md-6">

              <img src="images/google_home.png" alt="Google Home" style="width:=350px;height:350px;" />

          </div>
        </div>
          
      </div>
        
        
    </div>


        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
  </body>
</html>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/custom.js"></script>
    <body>

        <!-- Trecho que adiciona uma barra de navegação com o título do projeto no topo da página -->
        <!-- Usamos a subclasse navbar inverse para deixar ela preta, ao contrário do branco padrão do Bootstrap -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">CAD -  Sistema de Automação Doméstico</a>
            </div>
        </nav>

        <!-- Para a exibição do conteúdo usamos a div de classe conteiner-fluid. Essa div faz com que o conteúdo ocupe por todo espaço disponível na viewport-->



        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/EEL418-CAD/">Minha casa <span class="sr-only">(current)</span></a></li>
            </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header" name="HomeName" id="homeName"></h1>

            <form class="form-horizontal" role="form">
                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label">Ambiente</label>
                    <div class="col-md-4">
                        <select id="selectRoom" name="roomName" class="form-control" onchange="populateDevices()">
                            <option value="" disabled selected>Selecione um ambiente</option>
                        </select>
                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label">Dispositivo</label>
                    <div class="col-md-4">
                        <select id="selectDevice" name="deviceName" class="form-control">                
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label">Alterar nome da casa</label> 
                    <div class="col-md-4">
                        <input type="text" placeholder="Novo nome" class="form-control" name="newHomeName">
                        <br>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <center>
                        <button type="submit" name="action" value= "edit" class="btn btn-warning" onclick="changeHomeName();">Alterar nome</button>
                        <button id="buttonSelect" name="buttonSelect" class="btn btn-info" onclick="showModal('deviceInfo');">Controlar dispositivo</button>
                    </center>
                </div>

                <div class="selectedDevice" style="display:none" id="deviceInfo">
                    <center>
                        <h2 name="HomeName" id="deviceNameModal"></h1>
                            <!-- Device Informations -->
                            <div id="deviceImageModal">
                                <img id="myImage" onclick="toggleDeviceState()" src="images/no-image.png" width="150" height="180">
                            </div>

                            <!-- Button to Close Modal Window -->
                            <div id="buttons">
                            </div>
                            <div>
                                <br></br>
                                <a id="on_off" onclick="toggleDeviceState('deviceInfo');"></a>
                                <br></br>
                                <a class="btn btn-danger" onclick="hideModal('deviceInfo');">Fechar dispositivo</a>
                            </div>

                    </center>
                </div>
            </div>
        </div>
    </body>
</html>
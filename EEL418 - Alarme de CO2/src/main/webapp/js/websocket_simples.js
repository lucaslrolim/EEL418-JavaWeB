/* global alarmeAtivo */

window.onload = main;
var audio = new Audio('sounds/alarm.mp3');
function main(){
    conectar();
}

var websocket;
var alarteAtivo = true;
//------------------------------------------------------------------------------
function conectar() {
    var wsUri = "ws://localhost:8084/terceiro_trabalho/input";
    alarmeAtivo = true;
    $('#ativado').css('display', 'block');
    $('#desativado').css('display', 'none');
    
    
    try {
        websocket = new WebSocket(wsUri);
    } catch (erro) {
        $('#idMensagens').html('Erro: ' + erro);
        return;
    }
    websocket.binaryType = "arraybuffer";

    websocket.onopen = function(ev){console.log('=== Conectou');};
    
    websocket.onmessage = function (evt) {
        var json = JSON.parse(evt.data);
        if (typeof evt.data === "string") {
            if(json.alarme==="true" && alarmeAtivo){
                var image = document.getElementById('alarmPic');
                image.src = "images/AlarmON.png";
                audio.play();
                $('#CO2Danger').css('display', 'block');

            }
            if(json.alarme==="false" && alarmeAtivo){
                var image = document.getElementById('alarmPic');
                image.src = "images/AlarmOFF.png";
                audio.pause();
                $('#CO2Danger').css('display', 'none');
            }
            if(!alarmeAtivo){
                var image = document.getElementById('none');
                image.src = "images/AlarmOFF.png";
            }
            
        } else {
            console.log('Recebeu dados binários! E agora?');
        }
    };
    websocket.onerror = function (evt) {
        $('#idMensagens').html('Erro: ' + evt);
    };
}
//------------------------------------------------------------------------------
function desconectar() {
    websocket.close();
    $('#idMensagens').html('DESCONECTOU!');
}
//------------------------------------------------------------------------------

function desativarAlarme(){
    alarmeAtivo = false;
    console.log("entrei");
    document.getElementById("alarmStatus").innerHTML = "Alarme Desligado";
    document.getElementById("alarmStatus").style.color="red";
    audio.pause();
    var image = document.getElementById('alarmPic');
    image.src = "images/AlarmOFF.png";
    $('#CO2Danger').css('display', 'none');
}

function ativarAlarme(){
    alarmeAtivo = true;
    document.getElementById("alarmStatus").innerHTML = "Alarme Ligado";
    document.getElementById("alarmStatus").style.color="green";

}

function fazerPedidoHTTP() {
    $.ajax(
            {
                type: 'GET',
                url: '/terceiro_trabalho/servlet',
                data: "alarme="+true,
                dataType: 'text',
                cache: false,
                async: true,
                success: function (responseData) {
                    
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $('#idMensagens').html('Erro: ' + thrownError);
                }
            }
    );
}
//------------------------------------------------------------------------------

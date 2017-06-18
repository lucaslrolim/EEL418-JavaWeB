window.onload = populatePage;

function main(){
    
    document.getElementById('botaoEnviar').addEventListener('click',enviar);
    
}

function showModal(id) {
    var fileName = document.getElementsByName('deviceName')[0].value;
    console.log(fileName);
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'js/'+fileName+'.js'; 
    script.onload = function () {
        fillDeviceModal(); /// TODOS OS DISPOSITIVOS DEVEM TER A FUNÇÃO INICIAR()
    };
    document.head.appendChild(script);
    $("#" + id).fadeIn('slow');
}

function hideModal(id) {
   var sel = document.getElementById('buttons');
   while (sel.firstChild) {
        sel.removeChild(sel.firstChild);
   }
    $("#" + id).fadeOut('slow');
}

function populatePage(){
    var sendData = {'typeOfRequest':'1'};
    fazerPedidoAJAX(sendData,fillInitialFields);
}
function populateDevices(){
    var roomId = document.getElementsByName('roomName')[0].value;
    var sendData = {'typeOfRequest':'2',
                    'roomId': roomId};
    fazerPedidoAJAX(sendData,fillDevices);    
}
function changeHomeName(){
    var newName = document.getElementsByName('newHomeName')[0].value;
    // Change the HomeName on the page
    document.getElementById("homeName").innerHTML = newName ;
    // Send an AJAX request to change the name on the server
    var sendData = {'typeOfRequest':'3',
                    'homeName':newName};
    fazerPedidoAJAX(sendData,fillInitialFields);
};

function debug(objJSONresp){
    console.log(objJSONresp);
}

function fillInitialFields(objJSONresp){
   var sel = document.getElementById('selectRoom');
   for(var i = 0; i < objJSONresp["rooms"].length; i++) {
    var opt = document.createElement('option');
    opt.innerHTML = objJSONresp["rooms"][i].name;
    opt.value = objJSONresp["rooms"][i].id;
    sel.appendChild(opt);
    }
  document.getElementById("homeName").innerHTML = objJSONresp.homeName;
};
function fillDevices(objJSONresp){
   var sel = document.getElementById('selectDevice');
   while (sel.firstChild) {
        sel.removeChild(sel.firstChild);
   }
   for(var i = 0; i < objJSONresp["devices"].length; i++) {
    var opt = document.createElement('option');
    opt.innerHTML = objJSONresp["devices"][i].name;
    opt.value = objJSONresp["devices"][i].FileName;
    sel.appendChild(opt);
    }
}


function fazerPedidoAJAX(objetoJSON,funcPopularPagina){
    
    var stringJSON = JSON.stringify(objetoJSON);
    var objPedidoAJAX = new XMLHttpRequest();
    objPedidoAJAX.open("POST", "controller");
    objPedidoAJAX.setRequestHeader("Content-Type","application/json;charset=UTF-8");
    // Prepara recebimento da resposta: tipo da resposta JSON!
    objPedidoAJAX.responseType = 'json';
    
    objPedidoAJAX.onreadystatechange =
        function() {
            if(objPedidoAJAX.readyState===4 && objPedidoAJAX.status===200){
                // A resposta 'response' já é avaliada para json!
                // Ao contraro da resposta responseText.
                var respJSON = objPedidoAJAX.response;
                funcPopularPagina(respJSON);
            };
        };
        
    // Envio do pedido
    objPedidoAJAX.send(stringJSON);
};

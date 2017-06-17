function fillDeviceModal(){
    var deviceName = "lampada";
   // var deviceName = document.getElementsByName('deviceName')[0].value;
    document.getElementById("deviceNameModal").innerHTML = deviceName;
    var file = "json/"+deviceName+".json"
    $.getJSON(file, function(json) {
        if(json.status === "on"){
            document.getElementById("on_off").innerHTML = "Desligar";
            document.getElementById("on_off").className='btn btn-warning';
        }
        else{
            alert("2");
            document.getElementById("on_off").innerHTML = "Ligar";
            document.getElementById("on_off").className='btn btn-success';
        }
    });
}

function toggleDeviceState (){
    var image = document.getElementById('myImage');
    var status = document.getElementById('on_off').innerHTML;
    if(status == "Desligar"){
    	var status = "on";
    	image.src = "https://www.w3schools.com/js/pic_bulbon.gif"
        document.getElementById("on_off").innerHTML = "Desligar";
        document.getElementById("on_off").className='btn btn-warning';
    }
    else{
    	var status = "off";
    	image.src = "https://www.w3schools.com/js/pic_bulboff.gif";
        document.getElementById("on_off").innerHTML = "Ligar";
        document.getElementById("on_off").className='btn btn-success';
    }
    var sendData = {'typeOfRequest':'4',
                    'status':status};  
    fazerPedidoAJAX(sendData,fillInitialFields);                      
}

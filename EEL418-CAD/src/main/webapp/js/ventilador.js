function fillDeviceModal(){
    var deviceName = "ventilador";
   // var deviceName = document.getElementsByName('deviceName')[0].value;
    document.getElementById("deviceNameModal").innerHTML = deviceName;
    var file = "json/"+deviceName+".json"
    $.getJSON(file, function(json) {
        if(json.status === "on"){
            document.getElementById("on_off").innerHTML = "Desligar";
            document.getElementById("on_off").className='btn btn-warning';
            image.src = "images/ventilador_on.jpg"
        }
        else{
            image.src = "images/ventilador_off.jpg"
            document.getElementById("on_off").innerHTML = "Ligar";
            document.getElementById("on_off").className='btn btn-success';
        }
    });
}

function toggleDeviceState (){
    console.log("status changed");
    var image = document.getElementById('myImage');
    var status = document.getElementById('on_off').innerHTML;
    if(status == "Ligar"){
    	var status = "on";
    	image.src = "images/ventilador_on.jpg"
        document.getElementById("on_off").innerHTML = "Desligar";
        document.getElementById("on_off").className='btn btn-warning';
    }
    else{
    	var status = "off";
    	image.src = "images/ventilador_off.jpg";
        document.getElementById("on_off").innerHTML = "Ligar";
        document.getElementById("on_off").className='btn btn-success';
    }
    var sendData = {'typeOfRequest':'4',
                    'status':"oi"};  
    fazerPedidoAJAX(sendData,debug);                      
}

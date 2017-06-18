function fillDeviceModal(){
    var deviceName = document.getElementsByName('deviceName')[0].value;
    var image = document.getElementById('myImage');
   // var deviceName = document.getElementsByName('deviceName')[0].value;
    document.getElementById("deviceNameModal").innerHTML = deviceName;
    var file = "json/"+deviceName+".json"
    $.getJSON(file, function(json) {
        if(json.status === "on"){
            document.getElementById("on_off").innerHTML = "Desligar";
            document.getElementById("on_off").className='btn btn-warning';
            image.src = "images/pic_bulbon.gif";
        }
        else{
            image.src = "images/pic_bulboff.gif";
            document.getElementById("on_off").innerHTML = "Ligar";
            document.getElementById("on_off").className='btn btn-success';
        }
    });
}

function toggleDeviceState (){
    console.log("status changed");
    var fileName = document.getElementsByName('deviceName')[0].value;
    var image = document.getElementById('myImage');
    var status = document.getElementById('on_off').innerHTML;
    if(status == "Ligar"){
        console.log("Entrei no 1")
    	var status = "on";
    	image.src = "images/pic_bulbon.gif"
        document.getElementById("on_off").innerHTML = "Desligar";
        document.getElementById("on_off").className='btn btn-warning';
    }
    else{
        console.log("Entrei no 2")
    	var status = "off";
    	image.src = "images/pic_bulboff.gif";
        document.getElementById("on_off").innerHTML = "Ligar";
        document.getElementById("on_off").className='btn btn-success';
    }
    var sendData = {'typeOfRequest':'4',
                    'status':status,
                    'fileName':fileName};   
    fazerPedidoAJAX(sendData,debug);                      
}

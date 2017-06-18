function fillDeviceModal(){
    var deviceName = document.getElementsByName('deviceName')[0].value;
    var image = document.getElementById('myImage')
   // var deviceName = document.getElementsByName('deviceName')[0].value;
    document.getElementById("deviceNameModal").innerHTML = deviceName;
    var file = "json/"+deviceName+".json"
    $.getJSON(file, function(json) {
    	console.log(json.status);
    	console.log(json.status == "on");
        if(json.status == "on"){
            document.getElementById("on_off").innerHTML = "Desligar";
            document.getElementById("on_off").className='btn btn-warning';
            image.src = "images/ar_on.png"
        }
        else{
            image.src = "images/ar_off.png"
            document.getElementById("on_off").innerHTML = "Ligar";
            document.getElementById("on_off").className='btn btn-success';
        }
    });
    ventilate();
}

function ventilate(){
	var sel = document.getElementById('buttons');
	var btn = document.createElement("BUTTON");        // Create a <button> element
	var t = document.createTextNode("Modo ventilação desligado");       // Create a text node
	btn.id = 'ventilate'  
    btn.appendChild(t); 
	btn.addEventListener('click', function () {
	var fileName = document.getElementsByName('deviceName')[0].value;
	console.log("status changed");
	var status = document.getElementById('ventilate').innerHTML;
	if(status === "Modo ventilação ativado"){
		var status = "Modo ventilação desligado";
		document.getElementById("ventilate").innerHTML = "Modo ventilação desligado";
	}
	else{
		var status = "Modo ventilação ativado";
		document.getElementById("ventilate").innerHTML = "Modo ventilação ativado";
	}
    var sendData = {'typeOfRequest':'6',
                    'status':status,
                	'fileName':fileName};
    fazerPedidoAJAX(sendData,debug);
    }, false)                
	sel.appendChild(btn);	
}


function toggleDeviceState (){
	var fileName = document.getElementsByName('deviceName')[0].value;
    console.log("status changed");
    var image = document.getElementById('myImage');
    var status = document.getElementById('on_off').innerHTML;
    if(status === "Ligar"){
    	var status = "on";
    	image.src = "images/ar_on.png"
        document.getElementById("on_off").innerHTML = "Desligar";
        document.getElementById("on_off").className='btn btn-warning';
    }
    else{
    	var status = "off";
    	image.src = "images/ar_off.png";
        document.getElementById("on_off").innerHTML = "Ligar";
        document.getElementById("on_off").className='btn btn-success';
    }
    var sendData = {'typeOfRequest':'4',
                    'status':status,
                	'fileName':fileName};  
    fazerPedidoAJAX(sendData,debug);                      
}


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
            image.src = "images/tv_on.jpg"
        }
        else{
            image.src = "images/tv_off.jpg"
            document.getElementById("on_off").innerHTML = "Ligar";
            document.getElementById("on_off").className='btn btn-success';
        }
    });
    sound();
}

function sound(){
	var sel = document.getElementById('buttons');
	var btn = document.createElement("BUTTON");        // Create a <button> element
	var t = document.createTextNode("Som ligado");       // Create a text node
	btn.id = 'sound'  
    btn.appendChild(t); 
	btn.addEventListener('click', function () {
	var fileName = document.getElementsByName('deviceName')[0].value;
	console.log("status changed");
	var status = document.getElementById('sound').innerHTML;
	if(status === "Som ligado"){
		var status = "Som desligado";
		document.getElementById("sound").innerHTML = "Som desligado";
	}
	else{
		var status = "Som ligado";
		document.getElementById("sound").innerHTML = "Som ligado";
	}
    var sendData = {'typeOfRequest':'5',
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
    	image.src = "images/tv_on.jpg"
        document.getElementById("on_off").innerHTML = "Desligar";
        document.getElementById("on_off").className='btn btn-warning';
    }
    else{
    	var status = "off";
    	image.src = "images/tv_off.jpg";
        document.getElementById("on_off").innerHTML = "Ligar";
        document.getElementById("on_off").className='btn btn-success';
    }
    var sendData = {'typeOfRequest':'4',
                    'status':status,
                	'fileName':fileName};  
    fazerPedidoAJAX(sendData,debug);                      
}


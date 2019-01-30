var stompClient = null;


function init(x) {
    var bulbValue = document.getElementById("bulb"+x).innerHTML;
    if (bulbValue == 'off'){
        updateBulb('off',x);
    }
    if (bulbValue == 'on'){
        updateBulb('on',x);
    }
}

function connect(x) {
    var socket = new SockJS('/hello');

    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/greetings', function (greeting) {
            updateBulb(JSON.parse(greeting.body).content, x)
        });
    });
    init(x);
}

function updateBulb(message,x) {
    var state = "";
    if (message == 'off'){
        state = "Bulb is off"
    }
    if (message == 'on'){
        state = 'Bulb is on'
    }
    document.getElementById("bulb"+x).innerHTML=state;
}

function turnOn(x) {
    stompClient.send("/app/hello", {}, JSON.stringify({'id': x, 'currentState': 'on'}));
    updateBulb(x);
}

function turnOff(x) {
    stompClient.send("/app/hello", {}, JSON.stringify({'id': x, 'currentState': 'off'}));
    updateBulb(x);
}
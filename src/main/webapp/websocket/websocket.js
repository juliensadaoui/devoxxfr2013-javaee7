function init() {
    output = document.getElementById("output");
}

function connectToServer(uri) {
    var websocket = new WebSocket(wsUri);
    websocket.onopen = function(evt) { onOpen(evt) };
    websocket.onmessage = function(evt) { onMessage(evt) };
    websocket.onerror = function(evt) { onError(evt) };    
}

function send_binary() {
    var buffer = new ArrayBuffer(myField.value.length);
    var bytes = new Uint8Array(buffer);
    for (var i=0; i<bytes.length; i++) {
        bytes[i] = i;
    }
    websocket.send(buffer);
    writeToScreen("SENT (binary): " + buffer.byteLength + " bytes");
}            

function send_text() {
    websocket.send(textID.value);
    writeToScreen("SENT (text): " + textID.value);
}

function onOpen(evt) {
    writeToScreen("CONNECTED");
}

function onMessage(evt) {
    writeToScreen("RECEIVED: " + evt.data);
}

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    pre.innerHTML = message;
    output.appendChild(pre);
}

window.addEventListener("load", init, false);



function connectToServer() {
    const socket = new WebSocket('ws://localhost:1234');
    
    socket.onopen = function(event) {
        document.getElementById('serverResponse').innerHTML = 'WebSocket connection established';
        const messageInput = document.getElementById('username');
        socket.send(messageInput.value);
    }

    socket.onmessage = function(event) {
        const response = event.data;
        document.getElementById('serverResponse').innerHTML = 'Received message:', response;
        socket.close();
    }
  }
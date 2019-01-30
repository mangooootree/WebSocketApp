<!DOCTYPE html>
<html>
  <head>
  </head>
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/sockjs-client/sockjs.min.js"></script>
  <script src="/webjars/stomp-websocket/stomp.min.js"></script>
  <script src="/app.js"></script>
  <body onload="connect(${roomId}); ">
    <div align="center">
        <h2>Room ${roomId}</h2>
        <br><br>
        <label id="bulb${roomId}">${initialValue}</label>
        <br><br>
        <a href="#" onclick="turnOn(${roomId})">Turn on</a>
        <br><br>
        <a href="#" onclick="turnOff(${roomId})">Turn off</a>
    </div>
  </body>
</html>
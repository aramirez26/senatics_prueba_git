<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Senatics</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/stylelogin.css">

  
</head>

<body>
  
<!-- Form Mixin-->
<!-- Input Mixin-->
<!-- Button Mixin-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Senatics Prueba</h1>
  <label onchange="informar_registro();" id="msg"
    style="font-size:x-large ;  font-weight: bold; font-style: italic; color: #FE2E2E;"
    >
  </label>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    <div class="tooltip">Click Me</div>
  </div>
  <div class="form">
    <h2>Autenticación de su cuenta</h2>
    <form method="post" action="login" name="login">
      <input name="user" type="text" placeholder="Usuario"/>
      <input name="password" type="password" placeholder="Contraseña"/>
      <button>Login</button>
    </form>
  </div>
  <div class="form">
    <h2>Crear una Cuenta</h2>
    <form method="post" action="login" name="login2">
      <input name="user2" type="text" placeholder="Usuario"/>
      <input name="password2" type="password" placeholder="Contraseña"/>
      <input style="display: none" name="pantalla" type="text" value="registro"/>
      <button>Registrar</button>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://codepen.io/andytran/pen/vLmRVp.js'></script>

    <script src="js/index.js"></script>  

<script type="text/javascript">
    window.onload = function() {
        
    
    var name = '<%= session.getAttribute("respuesta_registro") %>';
    if(name != "null" && name != "") {
        alert(name);
        <% session.setAttribute("respuesta_registro",""); %>         
    }
  }
</script>   
    
</body>
</html>

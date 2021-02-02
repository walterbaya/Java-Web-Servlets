let tabla = document.getElementById("tabla");
window.addEventListener("resize", e => {
  if(window.innerWidth < 1160){
    tabla.setAttribute("style","padding-top: 4em;padding-bottom: 4em;" );
  }
  else{
    tabla.setAttribute("style","width: 40%; position: absolute; right: 5em;top: 4em" );
  }
});

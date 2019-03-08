$(document).ready(function getRate(){
  var input, star, starEmpty, hole;
   input = document.getElementById("media");
   star = document.createElement("span");
  star.setAttribute("class", "glyphicon glyphicon-star");
   starEmpty = document.createElement("span");
  starEmpty.setAttribute("class", "glyphicon glyphicon-star-empty");

    hole = document.getElementsByClassName("media-body");
    for(j= 0; j<hole.length;j++){
    var rate = hole[j].querySelector("#rated").value;
    for( i=1; i<6; i++){
      if(rate>=i){
       hole[j].querySelector("#rew").appendChild(star.cloneNode(true));
      }else {
       hole[j].querySelector("#rew").appendChild(starEmpty.cloneNode(true));
      }
    }
}
});
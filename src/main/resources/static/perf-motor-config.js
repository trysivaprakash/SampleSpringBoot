document.addEventListener('DOMContentLoaded', function() {

  var headSection = document.getElementById("perf-motor-ui");

  var htmlContent = '<div class="centerme"><h4 id="myAppHeader" class="opblock-tag">'
      + 'Performance Testing Configuration</h4></div>'

  var confDetails = '<div class="config-styleme">'
      + '<span><div class="opblock opblock-conf"><table>'
      + '<tr><td><div class="opblock-summary">'
      + '<span class="opblock-summary-method">Number of requests</span>'
      + '</div></td>'
      + '<td><input type="text" id="nbrOfReq" value="100"/></td></tr>'
      + '<tr><td><div class="opblock-summary">'
      + '<span class="opblock-summary-method">Number of Loops</span>'
      + '</div></td>'
      + '<td><input type="text" id="nbrOfLoops" value="10"/></td></tr>'
      + '<tr><td><div class="opblock-summary">'
      + '<span class="opblock-summary-method">Feeder</span>'
      + '</div></td>'
      + '<td><input type="file" id="fileinput" onchange="readSingleFile(event)" name="csv feeder file"/></td></tr>'
      + '</table></div></span></div>';

  headSection.innerHTML = htmlContent + confDetails;

}, false);

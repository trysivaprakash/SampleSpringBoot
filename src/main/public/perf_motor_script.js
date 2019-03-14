/*jshint esversion: 6 */
$(function(){
    "use strict";
	
    /*$('#getEndPointsBtn').click(function(){
        let swaggerDocsVal = $('#swaggerDocsUrlInput').val();*/
		let swaggerDocsVal = "http://localhost:8082/v2/api-docs";
        if(swaggerDocsVal){
            console.log('Invoking Get End Points Ajax!');
            $.get(swaggerDocsVal)
                .done(getEndpointsDone);
        }
    /*});*/

    function getEndpointsDone(data){
        console.log('Endpoints Data Received from Ajax!');
		//console.log(data);
        let endpointsElm = $('.endpoints');
        endpointsElm.empty();
		let hostUrl = data["host"];
		//console.log(hostUrl);
		let endpointPaths = data['paths'];
		
		for(let pathKey in endpointPaths){
			//console.log("Current Path is " + pathKey);
			let curPath = endpointPaths[pathKey];

			for(let methodKey in curPath){
				//console.log("Current method " + methodKey + "inside Path " + pathKey);
				let pathVal = pathKey;
				let pathParameters = curPath[methodKey].parameters;					
				let queryString;
				$.each(pathParameters, function(index, element) {
					if(element.in === "query"){
						if(queryString){
							queryString = queryString + "&" + element.name + "=" + "${" + element.name + "}";
						}else{
							queryString = "?" + element.name + "=" + "${" + element.name + "}";
						}
					}else if(element.in === "path"){
						let pathParamName = "{" + element.name + "}";
						pathVal = pathVal.replace(pathParamName, "$" + pathParamName);
					}
				});
				
				if(queryString){
					pathVal = pathVal + queryString;
				}
				
				let endpointKey = pathVal + "-" + methodKey;
				let endpointElm = $('<div>').attr('data-endpointid', endpointKey).addClass('endpoint');
				
				let spanMethodElm = $('<span>').text(methodKey.toUpperCase()).addClass('endpointMethod');
				spanMethodElm.appendTo(endpointElm);
				
				let spanPathElm = $('<span>').text(pathVal).attr('data-hosturl', hostUrl).addClass('endpointPath');
				spanPathElm.appendTo(endpointElm);
				
				let btnElm = $('<button>').attr('data-endpointid', endpointKey).addClass('executeBtn').text('Execute');
				btnElm.appendTo(endpointElm);
				
				endpointElm.appendTo(endpointsElm);
			}	
		}
		
    };	

	
    $('.endpoints').on('click','.executeBtn',function () {
        let endpointId = $(this).attr('data-endpointid');
        let endpointDivElm = $( "div[data-endpointid='"+endpointId+"']" )[0];
		//console.log(endpointDivElm);
		let requestCount = $( "input[name='numberOfRequests']" ).val();
		let loopCount = $( "input[name='loopCount']" ).val();
		let endPointMethod = $(endpointDivElm).find("span.endpointMethod").html();
		let endPointUrl = /*"http://" + $(endpointDivElm).find("span.endpointPath").attr('data-hosturl') +*/ $(endpointDivElm).find("span.endpointPath").html();
        //console.log('Button With Endpoint ID = ' + endpointId + " Clicked!");
		let configData = {"requestCount" : requestCount, "loopCount" : loopCount, "endpointUrl" : endPointUrl, "requestMethod" : endPointMethod};
		
		//console.log(configData);
		
		let file_data = $('#csvFeederFileId')[0].files[0];
		
		//console.log(file_data);
		
		var dataWrapper = new FormData();
		dataWrapper.append('feeder_csv', file_data);
		dataWrapper.append("config_data", JSON.stringify(configData));
		/*dataWrapper.append('config_data', new Blob([JSON.stringify(configData)], 
			{
                type: "application/json"
            }));*/
		
		
		$.ajax({
			url: 'http://localhost:8082/executePerformanceTest',
			data: dataWrapper,
			cache: false,
			contentType:false,
			processData: false,
			method: 'POST',
			success: function(data){
				alert(data);
			}
		});		

    });
	

})();
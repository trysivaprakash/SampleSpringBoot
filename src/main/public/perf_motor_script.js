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
				
				let spanPathElm = $('<span>').text(pathVal).addClass('endpointPath');
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
		let endPointUrl = $(endpointDivElm).find("span.endpointPath").html();
        //console.log('Button With Endpoint ID = ' + endpointId + " Clicked!");
		let configData = {"requestCount" : requestCount, "loopCount" : loopCount, "endpointUrl" : endPointUrl, "requestMethod" : endPointMethod};
		
		console.log(configData);
		
        /*$.get('http://jsonplaceholder.typicode.com/comments', {postId: postIdVal})
            .done(function(data){
                container.show();
                $.each(data, function(index, element) {

                    let emailElm = $('<span>').text(element.email).addClass('commentEmail');
                    let titleElm = $('<span>').text(element.name).addClass('commentTitle');
                    let pElm = $('<p>').text(element.body);

                    let commentElm = $('<div>').addClass('comment');

                    emailElm.appendTo(commentElm);
                    titleElm.appendTo(commentElm);
                    pElm.appendTo(commentElm);

                    commentElm.appendTo(container);

                });
                event.stopPropagation();
            });*/

    });
	

})();
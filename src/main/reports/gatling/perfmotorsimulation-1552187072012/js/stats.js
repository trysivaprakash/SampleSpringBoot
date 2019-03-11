var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "100",
        "ok": "81",
        "ko": "19"
    },
    "minResponseTime": {
        "total": "166",
        "ok": "166",
        "ko": "500"
    },
    "maxResponseTime": {
        "total": "636",
        "ok": "499",
        "ko": "636"
    },
    "meanResponseTime": {
        "total": "395",
        "ok": "364",
        "ko": "529"
    },
    "standardDeviation": {
        "total": "99",
        "ok": "82",
        "ko": "29"
    },
    "percentiles1": {
        "total": "397",
        "ok": "352",
        "ko": "523"
    },
    "percentiles2": {
        "total": "480",
        "ok": "437",
        "ko": "533"
    },
    "percentiles3": {
        "total": "529",
        "ok": "487",
        "ko": "557"
    },
    "percentiles4": {
        "total": "549",
        "ok": "495",
        "ko": "620"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 81,
        "percentage": 81
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 19,
        "percentage": 19
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "100",
        "ok": "81",
        "ko": "19"
    }
},
contents: {
"req_sample-req-b6114": {
        type: "REQUEST",
        name: "Sample_req",
path: "Sample_req",
pathFormatted: "req_sample-req-b6114",
stats: {
    "name": "Sample_req",
    "numberOfRequests": {
        "total": "100",
        "ok": "81",
        "ko": "19"
    },
    "minResponseTime": {
        "total": "166",
        "ok": "166",
        "ko": "500"
    },
    "maxResponseTime": {
        "total": "636",
        "ok": "499",
        "ko": "636"
    },
    "meanResponseTime": {
        "total": "395",
        "ok": "364",
        "ko": "529"
    },
    "standardDeviation": {
        "total": "99",
        "ok": "82",
        "ko": "29"
    },
    "percentiles1": {
        "total": "397",
        "ok": "352",
        "ko": "523"
    },
    "percentiles2": {
        "total": "480",
        "ok": "437",
        "ko": "533"
    },
    "percentiles3": {
        "total": "529",
        "ok": "487",
        "ko": "557"
    },
    "percentiles4": {
        "total": "549",
        "ok": "495",
        "ko": "620"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 81,
        "percentage": 81
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 19,
        "percentage": 19
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "100",
        "ok": "81",
        "ko": "19"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}

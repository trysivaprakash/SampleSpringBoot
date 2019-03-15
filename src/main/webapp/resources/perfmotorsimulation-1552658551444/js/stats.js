var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000",
        "ok": "1000",
        "ko": "1000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "269",
        "ok": "124",
        "ko": "269"
    },
    "meanResponseTime": {
        "total": "47",
        "ok": "19",
        "ko": "74"
    },
    "standardDeviation": {
        "total": "43",
        "ok": "23",
        "ko": "41"
    },
    "percentiles1": {
        "total": "39",
        "ok": "6",
        "ko": "64"
    },
    "percentiles2": {
        "total": "71",
        "ok": "30",
        "ko": "95"
    },
    "percentiles3": {
        "total": "125",
        "ok": "70",
        "ko": "171"
    },
    "percentiles4": {
        "total": "178",
        "ok": "94",
        "ko": "187"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1000,
        "percentage": 50
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
        "count": 1000,
        "percentage": 50
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1000",
        "ok": "500",
        "ko": "500"
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
        "total": "2000",
        "ok": "1000",
        "ko": "1000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "269",
        "ok": "124",
        "ko": "269"
    },
    "meanResponseTime": {
        "total": "47",
        "ok": "19",
        "ko": "74"
    },
    "standardDeviation": {
        "total": "43",
        "ok": "23",
        "ko": "41"
    },
    "percentiles1": {
        "total": "39",
        "ok": "6",
        "ko": "64"
    },
    "percentiles2": {
        "total": "71",
        "ok": "30",
        "ko": "95"
    },
    "percentiles3": {
        "total": "126",
        "ok": "70",
        "ko": "171"
    },
    "percentiles4": {
        "total": "178",
        "ok": "94",
        "ko": "187"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1000,
        "percentage": 50
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
        "count": 1000,
        "percentage": 50
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1000",
        "ok": "500",
        "ko": "500"
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

var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2500",
        "ok": "1378",
        "ko": "1122"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "503"
    },
    "maxResponseTime": {
        "total": "3397",
        "ok": "495",
        "ko": "3397"
    },
    "meanResponseTime": {
        "total": "796",
        "ok": "63",
        "ko": "1696"
    },
    "standardDeviation": {
        "total": "915",
        "ok": "100",
        "ko": "621"
    },
    "percentiles1": {
        "total": "207",
        "ok": "17",
        "ko": "1471"
    },
    "percentiles2": {
        "total": "1442",
        "ok": "64",
        "ko": "1818"
    },
    "percentiles3": {
        "total": "2812",
        "ok": "305",
        "ko": "3041"
    },
    "percentiles4": {
        "total": "3131",
        "ok": "453",
        "ko": "3205"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1378,
        "percentage": 55
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
        "count": 1122,
        "percentage": 45
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "312.5",
        "ok": "172.25",
        "ko": "140.25"
    }
},
contents: {
"req_for-given-reque-6d48d": {
        type: "REQUEST",
        name: "For given request",
path: "For given request",
pathFormatted: "req_for-given-reque-6d48d",
stats: {
    "name": "For given request",
    "numberOfRequests": {
        "total": "2500",
        "ok": "1378",
        "ko": "1122"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "503"
    },
    "maxResponseTime": {
        "total": "3397",
        "ok": "495",
        "ko": "3397"
    },
    "meanResponseTime": {
        "total": "796",
        "ok": "63",
        "ko": "1696"
    },
    "standardDeviation": {
        "total": "915",
        "ok": "100",
        "ko": "621"
    },
    "percentiles1": {
        "total": "207",
        "ok": "17",
        "ko": "1471"
    },
    "percentiles2": {
        "total": "1442",
        "ok": "64",
        "ko": "1819"
    },
    "percentiles3": {
        "total": "2812",
        "ok": "305",
        "ko": "3041"
    },
    "percentiles4": {
        "total": "3131",
        "ok": "453",
        "ko": "3205"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1378,
        "percentage": 55
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
        "count": 1122,
        "percentage": 45
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "312.5",
        "ok": "172.25",
        "ko": "140.25"
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

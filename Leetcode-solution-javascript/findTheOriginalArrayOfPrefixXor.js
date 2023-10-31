var findArray = function(pref) {
    const n = pref.length;
    let result = new Array(n);
    for(let i = n-1; i > 0; i--) {
        result[i] = pref[i] ^ pref[i-1];
    }
    result[0] = pref[0];
    return result;
};

// original arr =  5, 7, 2, 3, 2
// prefix arr   =  5, 2, 0, 3, 1

// 0 0 1 1
// 0 0 1 0 
//----------
// 0 0 0 1

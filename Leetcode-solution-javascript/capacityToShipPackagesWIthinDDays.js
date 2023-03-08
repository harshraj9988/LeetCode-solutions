/**
 * @param {number[]} weights
 * @param {number} days
 * @return {number}
 */
var shipWithinDays = function (weights, days) {
    let n = weights.length;
    let totalWeight = 0;
    for (let i = 0; i < n; i++) {
        totalWeight += weights[i];
    }
    let start = 1;
    let end = totalWeight;
    let ans = 0;
    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        let d = check(weights, mid, n, days);
        if (d <= days) {
            end = mid-1;
            ans = mid;
        } else {
            start = mid+1;
        }
    }
    return ans;
};


var check = (weights, value, n, days) => {
    let count = 1;
    let currWeight = 0;
    for (let i = 0; i < n; i++) {
        if(weights[i] > value) return days+1;
        currWeight += weights[i];
        if(currWeight > value) {
            count++;
            currWeight = weights[i];
        }
    }
    return count;
};
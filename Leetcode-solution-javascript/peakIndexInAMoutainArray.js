/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray = function (arr) {
    let start = 0;
    let end = arr.length - 1;

    if (arr[start] > arr[start + 1]) return 0;
    if (arr[end] > arr[end - 1]) return end;

    start++;
    end--;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (mid === 0) {
            if (arr[mid] > arr[mid + 1]) return mid;
            else start = mid + 1;
        } else if (mid === arr.length - 1) {
            if (arr[mid - 1] < arr[mid]) return mid;
            else end = mid - 1;
        } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid - 1] >= arr[mid]) {
            end = mid - 1;
        } else if (arr[mid] <= arr[mid + 1]) {
            start = mid + 1;
        }
    }
    return 0;
};

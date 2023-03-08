/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function (nums) {
    const n = nums.length;
    let start = 0;
    let end = n - 1;
    while (start <= end) {
        const mid = start + Math.floor((end - start) / 2);
        if (
            (mid === n - 1 && nums[mid - 1] !== nums[mid]) ||
            (mid === 0 && nums[mid] !== nums[mid + 1]) ||
            (nums[mid - 1] !== nums[mid] && nums[mid] !== nums[mid + 1])
        ) {
            return nums[mid];
        } else if (mid !== n - 1 && nums[mid] === nums[mid + 1]) {
            if ((mid + 1) % 2 === 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } else if (mid !== 0 && nums[mid - 1] === nums[mid]) {
            if ((mid + 1) % 2 === 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return nums[0];
};

const nums = [1, 1, 2, 2, 3];
console.log(singleNonDuplicate(nums));

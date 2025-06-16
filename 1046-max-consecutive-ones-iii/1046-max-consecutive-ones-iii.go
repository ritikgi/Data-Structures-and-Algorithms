func longestOnes(nums []int, k int) int {
    left := 0
    maxLength := 0
    zerosCount := 0

    for right := 0; right < len(nums); right++ {
        if nums[right] == 0 {
            zerosCount++
        }

        for zerosCount > k {
            if nums[left] == 0 {
                zerosCount--
            }
            left++
        }

        maxLength = max(maxLength, right - left + 1)
    }

    return maxLength
}
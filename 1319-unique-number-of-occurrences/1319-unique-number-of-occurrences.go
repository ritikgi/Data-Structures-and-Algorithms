func uniqueOccurrences(arr []int) bool {
    frequencyMap := make(map[int]int)
	for _, num := range arr {
		frequencyMap[num]++
	}
	occurrenceSet := make(map[int]bool)

	for _, freq := range frequencyMap {
		if occurrenceSet[freq] {
			return false
		}
		occurrenceSet[freq] = true
	}
	return true
}
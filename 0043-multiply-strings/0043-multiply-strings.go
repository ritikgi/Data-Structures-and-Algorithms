func multiply(num1 string, num2 string) string {
    if num1 == "0" || num2 == "0"{
        return "0"
    }
    m,n := len(num1), len(num2)
    res := make([]int, m+n)
    for i := m-1; i >= 0; i--{ // i =2  = j = 1
        for j:= n-1; j >= 0; j-- {
            mul := int(num1[i] - '0') * int(num2[j] - '0')  // 3 * 5
            p1 := i + j     // 2+1
            p2 := i + j + 1 // 4  
            sum := mul + res[p2] // 15 + 0

            res[p2] = sum % 10 // 5
            res[p1] += sum / 10 // 15/10  = 1    0 0 1 3 5
            fmt.Println(mul)
        }
    }
    // var ans []byte
    result := ""
    leadingZero := true
    for _,digit := range res{
        if digit == 0 && leadingZero {
            continue
        }
        // fmt.Println(digit)
        leadingZero = false
        result += string(byte(digit) + '0')
        // ans = append(ans, byte(digit)+'0')
    }
    return result
    
}


// 123
//  45
// ---
//  615
// 4920
// ----
// 5535
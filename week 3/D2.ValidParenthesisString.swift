class Solution {
    func checkValidString(_ s: String) -> Bool {
        var lo = 0, hi = 0
        
        for c in Array(s){
            lo += c == "(" ? 1 : -1
            hi += c != ")" ? 1 : -1
            if hi < 0 {break}
            lo = max(lo,0)
        }
        print("lo \(lo) hi \(hi)")
        return lo == 0
    }
}
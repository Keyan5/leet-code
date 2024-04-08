class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        unordered_map<bool, int> freq;
        for(int student: students)
            freq[student]++;
        int accepted = 0;
        for(int sandwich: sandwiches) {
            if(freq[sandwich] > 0)  {
                freq[sandwich]--;
                accepted++;
            }
            else
                break;
        }
        return sandwiches.size() - accepted;
    }
};
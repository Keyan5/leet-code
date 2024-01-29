class MyQueue {
public:
    stack<int> q;
    stack<int> helper;
    MyQueue() {
        
    }
    
    void push(int x) {
        while(!q.empty()) {
            helper.push(q.top());
            q.pop();
        }
        q.push(x);
        while(!helper.empty()) {
            q.push(helper.top());
            helper.pop();
        }
    }
    
    int pop() {
        int first = q.top();
        q.pop();
        return first;
    }
    
    int peek() {
        return q.top();
    }
    
    bool empty() {
        return q.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
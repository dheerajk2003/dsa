class Data{
    char c;
    int frequency;
    int t;
    Data(char c){
        this.c = c;
        t = 0;
        frequency = 1;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        HashMap<Character, Data> hashMap = new HashMap<>();
        PriorityQueue<Data> maxHeap = new PriorityQueue<>((a,b) -> (b.frequency - a.frequency));
        Queue<Data> q = new LinkedList<>();

        for(int i=0; i<tasks.length; i++){
            if(hashMap.containsKey(tasks[i]))
                hashMap.get(tasks[i]).frequency++;
            else
                hashMap.put(tasks[i], new Data(tasks[i]));
        }

        hashMap.forEach((k, v) -> {
            maxHeap.offer(v);
        });

        while(true){
            if(maxHeap.isEmpty() && q.isEmpty())
                break;
            if(!q.isEmpty() && q.peek().t <= time){
                Data dt = q.remove();
                if(dt.frequency > 0){
                    maxHeap.add(dt);
                }
            }
            if(!maxHeap.isEmpty()){
                Data dt = maxHeap.poll();
                if(dt.frequency > 1){
                    dt.frequency--;
                    dt.t = time + n + 1;
                    q.add(dt);
                }
            }
            time++;
        }
        return time;
    }
}

// this we have solved by creating hash map of character and its(frequency , time) , that we add to max heap(highest frequency first), then we take data from heap one by one if its has remaining frequency add it to queue, and on every iteration if the time is passed on front node of queue then we re add it to max heap and remove it from queue

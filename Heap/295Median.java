
class MedianFinder {
    int Ssize;
    int Lsize;
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        Ssize = 0;
        Lsize = 0;
        small = new PriorityQueue<>((a,b) -> b-a);
        large = new PriorityQueue<>();
    }

    void balance(){
        if(Ssize - Lsize > 1){
            large.offer(small.remove());
            Ssize--;
            Lsize++;
        }
        else if(Lsize - Ssize > 1){
            small.offer(large.remove());
            Ssize++;
            Lsize--;
        }
    }
    
    public void addNum(int num) {
        small.offer(num);
        Ssize++;
        balance();
        if(Lsize > 0 && small.element() > large.element()){
            large.offer(small.remove());
            Ssize--;
            Lsize++;
        }
        balance();
    }
    
    public double findMedian() {
        if((Ssize + Lsize) % 2 == 0){
            return (float)(small.element() + large.element()) / 2;
        }
        if(Ssize < Lsize)
            return (float)large.element();
        return (float)small.element();
    }
}

//this is done by keeping one min heap and one max heap, and balancing their sizes, and if the top of min heap is greater than the top of max heap then we add the top of min heap to max heap
class Post{
    int postId;
    int count;
    Post(int postId, int count){
        this.postId = postId;
        this.count = count;
    }
}

class Tweet{
    int postId;
    int count;
    int index;
    int followee;
    Tweet(int postId, int count, int index, int followee){
        this.postId = postId;
        this.count = count;
        this.index  = index;
        this.followee = followee;
    }
}

class Twitter {
    HashMap<Integer, HashSet<Integer>> follow ;
    HashMap<Integer, List<Post>> tweet;
    int count=0;

    public Twitter() {
        follow = new HashMap<>();
        tweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweet.containsKey(userId)){
            tweet.put(userId, new ArrayList<>());
        }
        tweet.get(userId).add(new Post(tweetId, count));
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> (b.count - a.count));
        List<Integer> res = new ArrayList<>();
        follow.putIfAbsent(userId, new HashSet<>()); 
        follow.get(userId).add(userId);
        for(int i : follow.get(userId)){
            if(tweet.containsKey(i)){
                int index = tweet.get(i).size();
                Post p = tweet.get(i).get(index-1);
                maxHeap.offer(new Tweet(p.postId, p.count, index-1, i));
            }
        }
        while(!maxHeap.isEmpty() && res.size() < 10){
            Tweet t = maxHeap.poll();
            res.add(t.postId);
            if (t.index > 0) { // Ensure index doesn't go negative
                Post nextPost = tweet.get(t.followee).get(t.index - 1);
                maxHeap.offer(new Tweet(nextPost.postId, nextPost.count, t.index - 1, t.followee));
            }

        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)){
            follow.put(followerId, new HashSet<>());
        }
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId))
        follow.get(followerId).remove(followeeId);
    }
}

// In this we have first created a hashmap<int, list> to contain followers and followee,
// then a hashmap<int, List> to contain posts,
// then we put every last element from the post of lists of every followee, then if there is still remaining post in followee's post and res < 10 list we add it to max heap.
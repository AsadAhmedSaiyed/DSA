import java.util.*;
class Twitter {
    private static int time = 0;
    private HashMap<Integer, User> users;

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;
        public Tweet(int id){
            this.id = id;
            this.time = Twitter.time++;
            this.next = null;
        }
    }

    public class User{
        public int id;
        public HashSet<Integer> following;
        public Tweet thead;

        public User(int id){
            this.id = id;
            this.following = new HashSet<>();
            this.thead = null;
        }

        public void follow(int id){
            following.add(id);
        }

        public void unfollow(int id){
            following.remove(id);
        }

        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = this.thead;
            thead = t;
        }
    }

    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)){
            User u = new User(userId);
            users.put(userId, u);
        }
        users.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> res = new LinkedList<>();
        if(!users.containsKey(userId)) return res;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time-a.time);
        HashSet<Integer> followers = users.get(userId).following;
        followers.add(userId);
        for(int follower : followers){
            Tweet t = users.get(follower).thead;
            if(t != null){
                pq.add(t);
            }
        }
        int n = 0;
        while(!pq.isEmpty() && n<10){
            Tweet t = pq.remove();
            res.add(t.id);
            n++;
            if(t.next != null){
                pq.add(t.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            User u = new User(followerId);
            users.put(followerId, u);
        }
        if(!users.containsKey(followeeId)){
            User u = new User(followeeId);
            users.put(followeeId, u);
        }
        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) return;
        users.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
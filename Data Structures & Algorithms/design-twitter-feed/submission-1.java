class Twitter {
    List<Tweet> tweets;
    // Fix 1: Use a Set to prevent duplicate follow entries
    Map<Integer, Set<Integer>> follows;

    public Twitter() {
        this.tweets = new ArrayList<>();
        this.follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        this.tweets.add(new Tweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int i = tweets.size() - 1;
        List<Integer> feed = new ArrayList<>(10);

        // putIfAbsent is a cleaner way to initialize
        this.follows.putIfAbsent(userId, new HashSet<>());
        this.follows.get(userId).add(userId);

        while (i >= 0 && feed.size() < 10) {
            Tweet tweet = tweets.get(i);
            if (follows.get(userId).contains(tweet.userId)) {
                feed.add(tweet.tweetId);
            }
            i--;
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        this.follows.putIfAbsent(followerId, new HashSet<>());
        this.follows.get(followerId).add(followerId); 
        this.follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // Fix 2 & 3: Check for null AND prevent user from unfollowing themselves
        if (this.follows.containsKey(followerId) && followerId != followeeId) {
            this.follows.get(followerId).remove(followeeId);
        }
    }
}

class Tweet {
    int userId;
    int tweetId;

    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }
}
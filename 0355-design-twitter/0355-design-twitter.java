import java.util.*;

class Twitter {

    private static int time = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = Twitter.time++;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        for (int followee : followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                pq.offer(tweetMap.get(followee));
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            Tweet curr = pq.poll();
            result.add(curr.id);

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
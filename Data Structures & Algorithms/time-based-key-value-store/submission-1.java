class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.putIfAbsent(key, new ArrayList<Pair>());
        this.map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key)) {
            return "";
        }
        List<Pair> values = this.map.get(key);
        int left = 0;
        int right = values.size() - 1;
        String ans = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (values.get(mid).getTimestamp() <= timestamp) {
                ans = values.get(mid).getValue();
                left = mid + 1;
            } else if (values.get(mid).getTimestamp() > timestamp) {
                right = mid - 1;
            } else {
                return values.get(mid).getValue();
            }
        }

        return ans;
    }
}

class Pair {
    String val;
    int time;

    public Pair(String val, int time) {
        this.val = val;
        this.time = time;
    }

    public String getValue() {
        return this.val;
    }

    public int getTimestamp() {
        return this.time;
    }
}

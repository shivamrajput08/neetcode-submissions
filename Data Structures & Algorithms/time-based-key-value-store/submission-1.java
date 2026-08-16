class TimeStampedValue{
    public int timestamp;
    public String value;

    public TimeStampedValue(int timestamp , String  value){
        this.timestamp  = timestamp;
        this.value = value;
    }
}
class TimeMap {
    Map<String , ArrayList<TimeStampedValue>> entriesByKey;
    public TimeMap() {
     entriesByKey = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
       if(!entriesByKey.containsKey(key)){
        entriesByKey.put(key , new ArrayList<>());
       } 
       ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
       timeStampedValues.add(new TimeStampedValue(timestamp , value));
    }
    
    public String get(String key, int timestamp) {
         if (!entriesByKey.containsKey(key)) return "";

    ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
    Optional<TimeStampedValue> timeStamp =
            binarySearchTimestamp(timeStampedValues, timestamp);

    if (timeStamp.isEmpty()) {
        return "";
    }

    return timeStamp.get().value;
    }
     private Optional<TimeStampedValue> binarySearchTimestamp(
            ArrayList<TimeStampedValue> list, int timestamp) {

        int low = 0, high = list.size() - 1;
        TimeStampedValue ans = null;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid);   // valid candidate
                low = mid + 1;         // move right
            } else {
                high = mid - 1;        // move left
            }
        }

        return Optional.ofNullable(ans);
    }
}
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
   Input
   ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
	[[2],       [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

		LRUCache:2
						lru
		put(1,1)    -> {1:1}

						lru
		put(2,2)    -> {1:1, 2:2}

								   lru
		get(1)      -> return 1   {2:2, 1:1}   

						lru            
		put(3:3)    -> {1:1, 3:3}

									lru
		get(2)      -> return -1   {1:1, 3:3}  

						lru
		put(4:4)    -> {3:3, 4:4}

									lru
		get(1)      -> return -1   {3:3, 4:4}  

						lru
		get(4)      -> {3:3, 4:4}

	ALGORITHM
		STEP 1: - implement LRUCache
			- create a linkedhashmap (keeps track of insertion order)
				- the first item will represent the least recently used pair
			- set the size to the passed capacity

		STEP 2: implement get function
			- if the key is not in the map return -1
			- if the key is in the map 
				- stored the key's value
				- remove the key from the map 
				- insert the key,value pair back into the map

		STEP 3: implement the put 
			- if the capcity is reached and the key is not in the map
				- remove the first pair 
				- insert the new pair
			- if the key is in the map
				- remove the key from the map
				- insert the new pair
			- if the capacity has not been reach 
				- insert new pair

*/
public class LRUCache {

	int size;
	Map<Integer, Integer> cache;
	
	public LRUCache(int capacity) {
		// TODO Auto-generated constructor stub
		this.size = capacity;
		this.cache = new LinkedHashMap<>();
	}
	
	public int get(int key) {
		if (!this.cache.containsKey(key))
			return -1;
		
		int val = this.cache.get(key);
		// Recently used to add it in last
		this.cache.remove(key);
		this.cache.put(key, val);
		return val;
	}
	
	public void put(int key, int val) {
		if (this.cache.size() == this.size && !this.cache.containsKey(key)) {
			// if the size of cache is full and also the key is present in the map
			int firstKey = getFirstKey();
			this.cache.remove(firstKey);
		}
		else if (this.cache.containsKey(key)) {
			// Remove if found, to add in last
			this.cache.remove(key);
		}
		
		this.cache.put(key, val);
	}
	
	private int getFirstKey() {
		if (this.cache.size() == 0)
			return -1;
		
		int firstkey = -1;
		for (int k: this.cache.keySet()) {
			firstkey = k;
			break;
		}
		
		return firstkey;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

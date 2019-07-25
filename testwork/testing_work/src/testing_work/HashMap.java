package testing_work;

public class HashMap {
	Long hashTable[][][][] = new Long[256][][][];
	long size = 0;
	public void put(int key, long value) {
		int lowestIndex = key & 0xFF;
		if (hashTable[lowestIndex] == null) {
			hashTable[lowestIndex] = new Long[256][][];
		}

		int penultimateIndex = (key >> 8) & 0xFF;
		if (hashTable[lowestIndex][penultimateIndex] == null) {
			hashTable[lowestIndex][penultimateIndex] = new Long[256][];
		}

		int thirdIndex = (key >> 16) & 0xFF;
		if (hashTable[lowestIndex][penultimateIndex][thirdIndex] == null) {
			hashTable[lowestIndex][penultimateIndex][thirdIndex] = new Long[256];
		}
		int highestIndex = (key >> 24) & 0xFF;
		if(hashTable[lowestIndex][penultimateIndex][thirdIndex][highestIndex] == null) {
			size++;
		}
		
		hashTable[lowestIndex][penultimateIndex][thirdIndex][highestIndex] = value;
	}

	public long get(int key) throws KeyNotFoundException {
		int lowestIndex = key & 0xFF;
		Long result = null;
		if (hashTable[lowestIndex] != null) {
			int penultimateIndex = (key >> 8) & 0xFF;
			if (hashTable[lowestIndex][penultimateIndex] != null) {
				int thirdIndex = (key >> 16) & 0xFF;
				if (hashTable[lowestIndex][penultimateIndex][thirdIndex] != null) {
					result = hashTable[lowestIndex][penultimateIndex][thirdIndex][(key >> 24) & 0xFF];
				}
			}
		}
		if (result == null) {
			throw new KeyNotFoundException();
		}
		return result;
	}

	public long size() {
		return size;
	}
}

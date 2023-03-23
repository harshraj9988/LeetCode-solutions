from collections import Counter


class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if(len(word1)!=len(word2)):
            return False
        charactersOfWord1 = Counter(word1)
        charactersOfWord2 = Counter(word2)

        sameCharacters = charactersOfWord1.keys == charactersOfWord2.keys
        sameFreq = sorted(charactersOfWord1.values) == sorted(charactersOfWord2.values)
        return sameCharacters and sameFreq

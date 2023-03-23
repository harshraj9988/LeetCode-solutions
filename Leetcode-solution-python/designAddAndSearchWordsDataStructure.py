class WordDictionary:
    class Trie:
        def __init__(self):
            self.children = dict()
            self.isWord = False

    def __init__(self):
        self.trie = self.Trie()

    def addWord(self, word: str) -> None:
        trie = self.trie
        for c in word:
            if c not in trie.children:
                trie.children[c] = self.Trie()
            trie = trie.children[c]
        trie.isWord = True

    def helper(self, trie: Trie, word: str, i: int, n: int) -> bool:
        if i == n:
            return trie.isWord
        if word[i] != '.':
            if word[i] not in trie.children:
                return False
            else:
                return self.helper(trie.children[word[i]], word, i + 1, n)
        else:
            for skip in trie.children:
                if self.helper(trie.children[skip], word, i+1, n):
                    return True
        return False

    def search(self, word: str) -> bool:
        trie = self.trie
        return self.helper(trie, word, 0, len(word))


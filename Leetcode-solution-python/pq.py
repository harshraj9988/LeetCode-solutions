class MySpecialQueue:
    def __init__(self):
        self.queue = None
        self.temp = None

    def insert(self, bids):
        self.queue = bids[::]
        self.temp = sorted(bids)

    def dequeue(self):
        self.queue.remove(self.temp[-1])
        self.temp.pop()


if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    q  = MySpecialQueue()
    q.insert(arr)

    for i in range(2):
        q.dequeue()

    print(q.queue.__str__())
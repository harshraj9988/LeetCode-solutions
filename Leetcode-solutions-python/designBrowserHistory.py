class Node:
    def __init__(self, url="", _next=None, _prev=None):
        self.data = url
        self.next = _next
        self.prev = _prev


class BrowserHistory:

    def __init__(self, homepage: str):
        self.curr = Node(homepage)

    def visit(self, url: str) -> None:
        self.curr.next = Node(url, None, self.curr)
        self.curr = self.curr.next

    def back(self, steps: int) -> str:
        while steps > 0:
            steps -= 1
            if not self.curr.prev:
                return self.curr.data
            self.curr = self.curr.prev
        return self.curr.data

    def forward(self, steps: int) -> str:
        while steps > 0:
            steps -= 1
            if not self.curr.next:
                return self.curr.data
            self.curr = self.curr.next
        return self.curr.data

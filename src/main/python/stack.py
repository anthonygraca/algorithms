class stack:
    def __init__(self):
        self.m_size = 0
        self.m_collection = []

    def isEmpty(self):
        return self.m_size == 0

    def push(self, item):
        self.m_collection.append(item)
        self.m_size+=1

    def getSize(self):
        return self.m_size

    def pop(self):
        self.m_size-=1
        return self.m_collection.pop(self.m_size)


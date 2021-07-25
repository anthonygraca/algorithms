import unittest

from queue import queue

class QueueTest(unittest.TestCase):
    def test_initialized_queue_is_empty(self):
        my_queue = queue()
        assert my_queue.isEmpty() == True

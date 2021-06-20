import unittest

from stack import stack

class StackTest(unittest.TestCase):
    def test_initialized_stack_is_empty(self):
        my_stack = stack()
        assert my_stack.isEmpty() == True

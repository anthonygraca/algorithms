import unittest

from stack import stack

class StackTest(unittest.TestCase):
    def test_initialized_stack_is_empty(self):
        my_stack = stack()
        assert my_stack.isEmpty() == True

    def test_push_a_string(self):
        my_stack = stack()
        item = "dummy string"
        my_stack.push(item)
        assert my_stack.isEmpty() == False

    def test_verify_size(self):
        my_stack = stack()
        item = "dummy string"
        my_stack.push(item)
        assert my_stack.getSize() == 1

    def test_verify_pop(self):
        my_stack = stack()
        item = "dummy string"
        my_stack.push(item)
        assert my_stack.pop() == item

    def test_verify_pop_size(self):
        my_stack = stack()
        item = "dummy string"
        my_stack.push(item)
        my_stack.pop()
        assert my_stack.getSize() == 0

    # Tests after this point didn't change code
    def test_verify_multiple_pop(self):
        my_stack = stack()
        item1 = "dummy string 1"
        item2 = "dummy string 2"
        my_stack.push(item1)
        my_stack.push(item2)
        assert my_stack.pop() == item2
        assert my_stack.pop() == item1

    def test_verify_stack_does_not_overflow(self):
        my_stack = stack()
        item1 = "dummy string 1"
        item2 = "dummy string 2"
        item3 = "dummy string 3"
        item4 = "dummy string 4"
        my_stack.push(item1)
        my_stack.push(item2)
        my_stack.push(item3)
        my_stack.push(item4)
        assert my_stack.pop() == item4
        assert my_stack.pop() == item3
        assert my_stack.pop() == item2
        assert my_stack.pop() == item1

    def test_verify_template_type(self):
        my_stack = stack()
        item1 = 1234
        my_stack.push(item1)
        assert my_stack.pop() == item1


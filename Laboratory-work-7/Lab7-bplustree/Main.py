from BPlusTree import BPlusTree
import random
import time

degree = 5
count_nodes = 12
start = 0
end = 80
key = 15

print('Initializing B+ tree with degree=', count_nodes)
bPlusTree = BPlusTree(degree)

print("Filling tree:")

counter = 0
while counter < count_nodes:
    random_value = random.randint(start, end)
    bPlusTree.insert(random_value, "Value" + str(random_value))
    counter += 1


print("Printing BPlusTree:")
bPlusTree.show()

print('\nRetrieving values with key ', key)
start_time = time.time()
print(bPlusTree.retrieve(key))
end_time = time.time()
print("time=", end_time - start_time)

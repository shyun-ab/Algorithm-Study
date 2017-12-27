#2017-12-28

def duplicate(numbers):
    for i in range(10):
        if numbers.count(str(i)) > 1:
            return False
    else:
        return True

print(duplicate("0123456789"))
print(duplicate("334444123"))
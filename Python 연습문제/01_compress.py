#2017-12-28

text = input("Write your sentence: ")
count = 0
temp = ""
new_text = ""

for c in text:
    if c != temp:
        temp = c
        if count != 0:
            new_text += str(count)
        new_text += c
        count = 1
    else:
        count += 1
if count != 0:
    new_text += str(count)

print(new_text)
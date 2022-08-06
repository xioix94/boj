N = int(input())
sum = 0

n = str(input())
for i in n:
    if int(i) != 0:
        sum += int(i)
print(sum)
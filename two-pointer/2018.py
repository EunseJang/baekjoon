N = int(input())

sum = 1
count = 1
start = 1
end = 1

while end != N:
    if sum == N:
        end += 1
        sum += end
        count += 1
    elif sum < N:
        end += 1
        sum += end
    else:
        sum -= start
        start += 1

print(count)

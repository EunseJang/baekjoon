N = int(input())
M = int(input())
material = list(map(int, input().split()))

material.sort()

count = 0
start = 0
end = N-1

while (start < end):
    if material[start] + material[end] == M:
        count += 1
        start += 1
        end -= 1
    elif material[start] + material[end] < M:
        start += 1
    else:
        end -= 1

print(count)

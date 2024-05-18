import sys
input = sys.stdin.readline

N, M = map(int, input().split())

arr = list(map(int, input().split()))
arrSum = [0] * (N+1)

for i in range(1, N+1):
    arrSum[i] = arrSum[i-1] + arr[i-1]

for i in range(1, N+1):
    arrSum[i] = arrSum[i] % M

count = 0
for i in range(1, N+1):
    if (arrSum[i] == 0):
        count += 1

howMany = [0] * (M)
for i in range(1, N+1):
    howMany[arrSum[i]] += 1

for i in range(M):
    if (howMany[i] > 1):
        tmp = (howMany[i] * (howMany[i]-1)) // 2
        count += tmp

print(count)

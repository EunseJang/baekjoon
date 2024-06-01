N = int(input())
arr = list(map(int, input().split()))

for i in range(1, N):
    num = arr[i]
    idx = i

    for j in range(0, i):
        if arr[j] > num:
            idx = j
            break
    for k in range(i, idx, -1):
        arr[k] = arr[k-1]

    arr[idx] = num

for i in range(1, N):
    arr[i] += arr[i-1]

print(sum(arr))

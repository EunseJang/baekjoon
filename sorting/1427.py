arr = list(map(int, input()))
N = len(arr)

for i in range(N):
    idx = i

    for j in range(i+1, N):
        if (arr[idx] < arr[j]):
            idx = j

    arr[i], arr[idx] = arr[idx], arr[i]

for i in arr:
    print(i, end="")

# bubble sort

N = int(input())
arr = []

for i in range(N):
    arr.append(int(input()))

for i in range(N-1):
    for j in range(N-1-i):
        if (arr[j] > arr[j+1]):
            tmp = arr[j]
            arr[j] = arr[j+1]
            arr[j+1] = tmp

for i in arr:
    print(i)

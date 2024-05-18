N = int(input())

A = list(map(int, input().split()))
A.sort()

count = 0
for i in range(N):
    s = 0
    e = N-1

    while (s < e):
        if (A[i] == (A[s] + A[e])):
            if (s != i and e != i):
                count += 1
                break
            elif s == i:
                s += 1
            else:
                e -= 1
        elif (A[i] < (A[s] + A[e])):
            e -= 1
        else:
            s += 1

print(count)

n = int(input())

A = []
for i in range(n):
    A.append(int(input()))

B = []
ans = []
tmp = 1
isValid = True

for i in range(n):
    while (A[i] >= tmp):
        B.append(tmp)
        tmp += 1
        ans.append('+')

    if A[i] == B[-1]:
        B.pop()
        ans.append('-')

    elif A[i] < B[-1]:
        isValid = False
        print("NO")
        break

if (isValid):
    for i in ans:
        print(i)

import sys
input = sys.stdin.readline

S, P = map(int, input().split())
DNA = input()
kind = list(map(int, input().split()))
tmp = kind.copy()
count = 0

for i in range(P):
    if DNA[i] == 'A':
        kind[0] -= 1
    elif DNA[i] == 'C':
        kind[1] -= 1
    elif DNA[i] == 'G':
        kind[2] -= 1
    else:
        kind[3] -= 1

check = True
for K in range(4):
    if kind[K] > 0:
        check = False

if check == True:
    count += 1

# 슬라이딩 윈도우 수행
for i in range(P, S):
    if DNA[i] == 'A':
        kind[0] -= 1
    elif DNA[i] == 'C':
        kind[1] -= 1
    elif DNA[i] == 'G':
        kind[2] -= 1
    else:
        kind[3] -= 1

    if DNA[i-P] == 'A':
        kind[0] += 1
    elif DNA[i-P] == 'C':
        kind[1] += 1
    elif DNA[i-P] == 'G':
        kind[2] += 1
    else:
        kind[3] += 1

    check = True
    for K in range(4):
        if kind[K] > 0:
            check = False

    if check == True:
        count += 1

print(count)

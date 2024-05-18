import sys
input = sys.stdin.readline

N, case = map(int, input().split())

matrix = []
for i in range(N):
    row = list(map(int, input().split()))
    matrix.append(row)


# 합 배열 만들기
sumMatrix = [[0] * (N+1) for _ in range(N+1)]
for i in range(1, N+1):
    for j in range(1, N+1):
        sumMatrix[i][j] = sumMatrix[i][j-1] + sumMatrix[i-1][j] - \
            sumMatrix[i-1][j-1] + matrix[i-1][j-1]

for i in range(0, case):
    x1, y1, x2, y2 = map(int, input().split())
    answer = sumMatrix[x2][y2] - sumMatrix[x1-1][y2] - \
        sumMatrix[x2][y1-1] + sumMatrix[x1-1][y1-1]
    print(answer)

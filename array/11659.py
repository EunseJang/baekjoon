import sys

input = sys.stdin.readline
N, case = map(int, input().split())

nums = list(map(int, input().split()))
sums = []

tmp = nums[0]
sums.append(0)
sums.append(tmp)

for i in range(1, N):
    tmp += nums[i]
    sums.append(tmp)

for i in range(0, case):
    start, end = map(int, input().split())
    print(sums[end] - sums[start-1])

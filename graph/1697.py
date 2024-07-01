from collections import deque

N, K = map(int, input().split())
max = 100000
visited = [False] * (max+1)


def FindK(N, K):
    q = deque([(N, 0)])
    visited[N] = True

    while q:
        nowP, nowT = q.popleft()

        if nowP == K:
            return nowT

        for nextP in (nowP-1, nowP+1, nowP*2):
            if 0 <= nextP <= max and not visited[nextP]:
                visited[nextP] = True
                q.append((nextP, nowT + 1))


print(FindK(N, K))
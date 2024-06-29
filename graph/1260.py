from collections import deque

N, M, V = map(int, input().split())
A = [[] for _ in range(N+1)]

for i in range(M):
    s, e = map(int, input().split())
    A[s].append(e)
    A[e].append(s)

for i in range(N+1):
    A[i].sort()

visited = [False] * (N+1)
def DFS(v):
    print(v, end = ' ')
    visited[v] = True
    for i in A[v]:
        if not visited[i]:
            DFS(i)

DFS(V)


visited = [False] * (N+1)
def BFS(v):
    q = deque()
    q.append(v)
    visited[v] = True

    while q:
        nowN = q.popleft()
        print(nowN, end = ' ')
        
        for i in A[nowN]:
            if not visited[i]:
                visited[i] = True
                q.append(i)


print()
BFS(V)
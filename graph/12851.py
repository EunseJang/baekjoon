from collections import deque

N, K = map(int, input().split())
max = 100000
visited = [-1] * (max+1)  # 최소 시간을 기록하는 리스트로 변경
ways = [0] * (max+1)  # 방법의 수를 기록하는 리스트 추가

def FindK(N, K):
    q = deque([(N, 0)])
    visited[N] = 0
    ways[N] = 1

    while q:
        nowP, nowT = q.popleft()
        
        if nowP == K:
            continue
        
        for nextP in (nowP-1, nowP+1, nowP*2):
            if 0 <= nextP <= max:
                if visited[nextP] == -1: # 이전에 방문한 적이 없음
                    q.append((nextP, nowT + 1))
                    visited[nextP] = nowT + 1
                    ways[nextP] += ways[nowP]
                elif visited[nextP] == nowT + 1: # 방문할 수 있는 또 다른 경로가 있음
                    ways[nextP] += ways[nowP]

    return visited[K], ways[K]

minT, path = FindK(N, K)
print(minT)
print(path)

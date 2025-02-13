import sys
from collections import deque

input = sys.stdin.read
data = input().strip().splitlines()
N = int(data[0])
boards = [list(map(int, line)) for line in data[1:N+1]]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x, y):
    queue = deque([(x, y)])
    boards[x][y] = 0  # 방문 표시
    count = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and boards[nx][ny] == 1:
                boards[nx][ny] = 0  # 방문 표시
                queue.append((nx, ny))
                count += 1
    return count

result = []
for i in range(N):
    for j in range(N):
        if boards[i][j] == 1:
            result.append(bfs(i, j))

result.sort()
print(len(result))
for r in result:
    print(r)

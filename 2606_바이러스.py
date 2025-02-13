import sys
from collections import deque

computers = int(input())
edge_num = int(input())

graph = [] 
for i in range(computers + 1):
    graph.append([]) 

for _ in range(edge_num):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

que = deque([1])  
visited = [False] * (computers + 1)
visited[1] = True  
cnt = 0  

# BFS
while que:
    cur = que.popleft()  
    cnt += 1 

    for neighbor in graph[cur]:  
        if not visited[neighbor]:  
            visited[neighbor] = True  
            que.append(neighbor)  

print(cnt - 1)  

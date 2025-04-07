n, w, l = map(int, input().split())
trucks_queue = list(map(int, input().split()))
 
bridge = [0] * w
time = 0
 
while bridge: # 다리위에 트럭이 있는 동안 진행
    time += 1 # 반복마다 1초 증가
    bridge.pop(0)
    if trucks_queue:
        if sum(bridge) + trucks_queue[0] <= l: # 현재의 다리위 무게와 다음 트럭의 무게를 합쳐 최대 무게 비교
            bridge.append(trucks_queue.pop(0)) # 초과하지 않으면 다음 트럭 추가
        else:
            bridge.append(0) # 초과하면 빈공간인 0을 추가
print(time)
n = int(input())
score = []
for i in range(n):
    score.append(int(input()))

cnt = 0
# 뒷게임 부터 레벨을 낮춰줌
for i in range(n-2, -1, -1):
    if score[i] >= score[i+1]:
        cnt += score[i] - score[i+1] + 1
        score[i] = score[i+1]-1

print(cnt)
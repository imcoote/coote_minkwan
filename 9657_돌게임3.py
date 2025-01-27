from sys import stdin

n = int(stdin.readline())
# N이 5일때 까지는 결과를 알 수 있음
dp = [0, 1, 0, 1, 1] + [0] * (n - 4) # N이 5이상이면 그 뒤 요소들을 0으로 채움

for i in range(5, n + 1):
    if 0 in [dp[i - 1], dp[i - 4], dp[i - 3]]: # dp[i - 1], dp[i - 4], dp[i - 3]가 하나라도 0이면 창영이는 이길 수 없음
        dp[i] = 1
    else:
        dp[i] = 0

if dp[n]:
    print('SK')
else:
    print('CY')